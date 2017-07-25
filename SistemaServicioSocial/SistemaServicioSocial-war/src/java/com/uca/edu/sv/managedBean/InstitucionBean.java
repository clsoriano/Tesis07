/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Departamento;
import com.uca.edu.sv.bd.Institucion;
import com.uca.edu.sv.bd.Municipio;
import com.uca.edu.sv.bd.MunicipioPK;
import com.uca.edu.sv.bd.Pais;
import com.uca.edu.sv.bd.PerfilXUsuario;
import com.uca.edu.sv.bd.TipoInstitucion;
import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.DepartamentoFacade;
import com.uca.edu.sv.facade.InstitucionFacade;
import com.uca.edu.sv.facade.MunicipioFacade;
import com.uca.edu.sv.facade.PaisFacade;
import com.uca.edu.sv.facade.PerfilXUsuarioFacade;
import com.uca.edu.sv.facade.SsUsuarioSesionFacade;
import com.uca.edu.sv.facade.TipoInstitucionFacade;
import com.uca.edu.sv.facade.UsuarioFacade;
import com.uca.edu.sv.mail.SendMail;
import com.uca.edu.sv.process.Constantes;
import com.uca.edu.sv.ss.SsUsuarioSesion;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jcsoriano
 */
@Controller
public class InstitucionBean implements Serializable {

    public static final Logger LOG = Logger.getLogger(InstitucionBean.class.getName());

    @Inject
    private InstitucionFacade institucionFacade;
    @Inject
    private TipoInstitucionFacade tipoInstitucionFacade;
    @Inject
    private PaisFacade paisFacade;
    @Inject
    private DepartamentoFacade departamentoFacade;
    @Inject
    private MunicipioFacade municipioFacade;
    @Inject
    private UsuarioFacade usuarioFacade;
    @Inject
    private PerfilXUsuarioFacade perfilXUsuarioFacade;
    @Inject
    private SsUsuarioSesionFacade ssUsuarioSesionFacade;
    @Inject
    private SendMail sendMail;
    private Institucion institucion;
    private List<TipoInstitucion> tipoInstitucionList;
    private List<Pais> paisList;
    private List<Municipio> municipioList;
    private List<Departamento> departamentoList;
    private Usuario usuario;

    @PostConstruct
    public void _init() {
        institucion = new Institucion();
        institucion.setCodPais(new Pais());
        institucion.setMunicipio(new Municipio(new MunicipioPK()));
        institucion.setCorrTipoInstitucion(new TipoInstitucion());
        paisList = paisFacade.findAll();
        departamentoList = departamentoFacade.findAll();
        tipoInstitucionList = tipoInstitucionFacade.findAll();
        usuario = new Usuario();
    }

    public List<TipoInstitucion> getTipoInstitucionList() {
        return tipoInstitucionList;
    }

    public void setTipoInstitucionList(List<TipoInstitucion> tipoInstitucionList) {
        this.tipoInstitucionList = tipoInstitucionList;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public void saveInstitucion() {
        try {
            institucionFacade.create(institucion);
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almacena correctamente la institucion.");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Guardar", "Error almacenando la institucion.");
            LOG.log(Level.SEVERE, "Ocurrio un error almancenando la institucion", ex);
        }
    }

    public void registrar() {
        try {
            institucionFacade.create(institucion);
            saveUsuario();
            savePerfilXUsuario();
            saveSsUsuarioSesion();
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se enviara usuario a correo electronico.");
            executeFunction("PF('modalRegistarDatos').show();");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Guardar", "Error almacenando la institucion.");
            LOG.log(Level.SEVERE, "Ocurrio un error almancenando la institucion", ex);
        }
    }

    private void saveUsuario() {
        try {
            String codUsuario = institucion.getCorreoElectronico().split("@")[0];
            usuario = new Usuario();
            usuario.setCodUsuario(codUsuario.length() > 8 ? codUsuario.substring(0, 7) : codUsuario);
            usuario.setNbrUsuario(institucion.getNbrInstitucion());
            usuario.setEstado(Constantes.ESTADO_INACTIVO);
            usuarioFacade.create(usuario);
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Guardar", "Error almacenando usaurio.");
            LOG.log(Level.SEVERE, "Ocurrio un error almancenando el usuario", ex);
        }
    }

    private void savePerfilXUsuario() {
        PerfilXUsuario perfilXUsuario = new PerfilXUsuario();
        perfilXUsuario.setCodPerfil(Constantes.PERFIL_INSTI);
        perfilXUsuario.setCodUsuario(usuario.getCodUsuario());
        perfilXUsuarioFacade.create(perfilXUsuario);
    }

    private void saveSsUsuarioSesion() {
        SsUsuarioSesion ssUsuarioSesion = new SsUsuarioSesion();
        ssUsuarioSesion.setCodUsuarioCarnet(usuario.getCodUsuario());
        ssUsuarioSesion.setEsAlumno(Constantes.ESTADO_NO);
        ssUsuarioSesion.setEsPrimerInicioSesion(Constantes.ESTADO_SI);
        ssUsuarioSesion.setEsCambioClave(Constantes.ESTADO_SI);
        ssUsuarioSesion.setCorreo(institucion.getCorreoElectronico());
        ssUsuarioSesionFacade.create(ssUsuarioSesion);
    }

    public String login() {
        return "/login?faces-redirect=true";
    }

    public String cancelar() {
        return "/login?faces-redirect=true";
    }

    public void deptoValueChange(ValueChangeEvent event) {
        municipioList = municipioFacade.findByDepto((String) event.getNewValue());
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void executeFunction(String function) {
        RequestContext.getCurrentInstance().execute(function);
    }
}
