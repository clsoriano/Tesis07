/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.login;

import com.uca.edu.sv.bd.Alumno;
import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.AlumnoFacade;
import com.uca.edu.sv.facade.PerfilXUsuarioFacade;
import com.uca.edu.sv.facade.SsPerfilXAlumnoFacade;
import com.uca.edu.sv.facade.UsuarioFacade;
import com.uca.edu.sv.process.Constantes;
import com.uca.edu.sv.bd.PerfilXUsuario;
import com.uca.edu.sv.facade.SsUsuarioSesionFacade;
import com.uca.edu.sv.ss.SsUsuarioSesion;
import com.uca.edu.sv.util.UsuarioLogueado;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jcsoriano
 */
@Controller
public class ManageLogin implements Serializable {

    private static final Logger LOG = Logger.getLogger(ManageLogin.class.getName());

    @Inject
    private UsuarioFacade usuarioFacade;
    @Inject
    private AlumnoFacade alumnoFacade;
    @Inject
    private SsPerfilXAlumnoFacade ssPerfilXAlumnoFacade;
    @Inject
    private PerfilXUsuarioFacade perfilXUsuarioFacade;
    @Inject
    private SsUsuarioSesionFacade ssUsuarioSesionFacade;
    private String user;
    private String password;
    private String passwordNew;
    private String passwordRepite;
    private String message;
    private UsuarioLogueado usuarioLogueado;
    private SsUsuarioSesion ssUsuarioSesion;

    @PostConstruct
    public void _init() {
        usuarioLogueado = new UsuarioLogueado();
        ssUsuarioSesion = new SsUsuarioSesion();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getPasswordRepite() {
        return passwordRepite;
    }

    public void setPasswordRepite(String passwordRepite) {
        this.passwordRepite = passwordRepite;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String validateUser() {
        if (validaUsuario()) {
            try {
                ssUsuarioSesion = ssUsuarioSesionFacade.findByCodUsuarioCarnet(usuarioLogueado.getUser());
                if (ssUsuarioSesion.getEsCambioClave().equals(Constantes.ESTADO_SI)) {//Verificar cambio de clave
                    return "ingreso/cambiarClave?faces-redirect=true";
                }
                return "index?faces-redirect=true";
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "No pudo validarse si se requiere cambiar clave", ex);
                return "index?faces-redirect=true";
            }
        } else if (validaAlumno()) {
            ssUsuarioSesion = ssUsuarioSesionFacade.findByCodUsuarioCarnet(usuarioLogueado.getUser());
            if ((ssUsuarioSesion.getEsAlumno().equals(Constantes.ESTADO_SI)
                    && ssUsuarioSesion.getEsPrimerInicioSesion().equals(Constantes.ESTADO_NO))) { //Verificar expediente
                return "principal?faces-redirect=true";
            }
        }
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingreso", "Usuario o contraseña incorrectas");
        context.addMessage(null, facesMessage);
        return null;
    }

    private boolean validaUsuario() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Usuario usuario = usuarioFacade.validaUsuarioLogin(user, password);
            usuarioLogueado.setFechaInicio(format.format(new Date()));
            if (usuario != null && usuario.getEstado() == Constantes.ESTADO_ACTIVO) {
                PerfilXUsuario perfilXUsuario = perfilXUsuarioFacade.findByUsuario(usuario.getCodUsuario());
                usuarioLogueado.setCodPerfil(perfilXUsuario.getCodPerfil());
                usuarioLogueado.setUser(usuario.getCodUsuario());
                usuarioLogueado.setNombreCompleto(usuario.getNbrUsuario());
                usuarioLogueado.setNombrePerfil(perfilXUsuario.getCodPerfil());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constantes.USER_LOG, usuarioLogueado);
                return true;
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo determinar si es usuario.", ex);
        }
        return false;
    }

    private boolean validaAlumno() {
        try {
            Alumno alumno = alumnoFacade.validaAlumnoLogin(user, password);
            if (alumno != null && alumno.getEstadoAlumno() == Constantes.ESTADO_ACTIVO) {
                String codPerfil = ssPerfilXAlumnoFacade.findPerfilAlumno(user).getSsPerfilXAlumnoPK().getCodPerfil();
                usuarioLogueado.setUser(alumno.getCarne());
                usuarioLogueado.setCodPerfil(codPerfil);
                usuarioLogueado.setNombreCompleto(alumno.getNombres().concat(Constantes.CAD_ESPACIO).concat(alumno.getApellidos()));
                usuarioLogueado.setNombrePerfil(codPerfil);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Constantes.USER_LOG, usuarioLogueado);
                return true;
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "No se pudo determinar si es alumno.", ex);
        }
        return false;
    }

    public void cambioClave() {
        usuarioLogueado = (UsuarioLogueado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Constantes.USER_LOG);
        try {
            Usuario usuario = usuarioFacade.findByUsuario(usuarioLogueado.getUser());
            ssUsuarioSesion = ssUsuarioSesionFacade.findByCodUsuarioCarnet(usuarioLogueado.getUser());
            if (passwordNew.equals(passwordRepite)) {
                usuario.setClave(passwordNew);
                usuarioFacade.edit(usuario);
                ssUsuarioSesion.setEsCambioClave(Constantes.ESTADO_NO);
                ssUsuarioSesionFacade.edit(ssUsuarioSesion);
                addMessages(FacesMessage.SEVERITY_INFO, "Contraseña", "Se modifica de manera exitosa la contraseña.");
                RequestContext.getCurrentInstance().execute("PF('modalCambioClave').show()");
            } else {
                addMessages(FacesMessage.SEVERITY_INFO, "Error", "Las contraseñas no coinciden, favor verificar.");
            }
        } catch (Exception ex) {
            addMessages(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error al intentar modificar la contraseña.");
            LOG.log(Level.INFO, "Ocurrio un error enviando correo electronico", ex);
        }
    }

    public String logout() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "/login?faces-redirect=true";
    }

    public String registrate() throws Exception {
        return "/registro/registrarInstitucion?faces-redirect=true";
    }

    public void addMessages(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));

    }
}
