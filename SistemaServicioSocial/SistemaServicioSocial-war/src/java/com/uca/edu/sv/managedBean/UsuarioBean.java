/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.PerfilXUsuarioFacade;
import com.uca.edu.sv.facade.UsuarioFacade;
import com.uca.edu.sv.bd.PerfilXUsuario;
import com.uca.edu.sv.facade.SsUsuarioSesionFacade;
import com.uca.edu.sv.process.Constantes;
import com.uca.edu.sv.ss.SsUsuarioSesion;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class UsuarioBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(UsuarioBean.class.getName());

    @Inject
    private UsuarioFacade usuarioFacade;
    @Inject
    private PerfilXUsuarioFacade perfilXUsuarioFacade;
    @Inject
    private SsUsuarioSesionFacade ssUsuarioSesionFacade;
    private SsUsuarioSesion ssUsuarioSesion;
    private Usuario usuario;
    private boolean isEditUsuario;
    private PerfilXUsuario perfilXUsuario;
    private String isCambioClave;

    @PostConstruct
    public void _init() {
        this.usuario = new Usuario();
        perfilXUsuario = new PerfilXUsuario();
        isCambioClave = "N";
    }

    public String getIsCambioClave() {
        return isCambioClave;
    }

    public void setIsCambioClave(String isCambioClave) {
        this.isCambioClave = isCambioClave;
    }

    public PerfilXUsuario getPerfilXUsuario() {
        return perfilXUsuario;
    }

    public void setPerfilXUsuario(PerfilXUsuario perfilXUsuario) {
        this.perfilXUsuario = perfilXUsuario;
    }

    public boolean isIsEditUsuario() {
        return isEditUsuario;
    }

    public void setIsEditUsuario(boolean isEditUsuario) {
        this.isEditUsuario = isEditUsuario;
    }

    public void setSelectedUsuario(Usuario usuario) {
        this.isEditUsuario = true;
        this.usuario = usuario;
        perfilXUsuario = perfilXUsuarioFacade.findByUsuario(usuario.getCodUsuario());
        usuario.setClave(null);
    }

    public Usuario getSelectedUsuario() {
        return usuario;
    }

    public void newUsuario() {
        isEditUsuario = false;
        usuario = new Usuario();
        perfilXUsuario = new PerfilXUsuario();
    }

    public void saveUsuario() {
        try {
            if (!isEditUsuario || isCambioClave.equals(Constantes.ESTADO_SI)) {
                try {
                    ssUsuarioSesion = ssUsuarioSesionFacade.findByCodUsuarioCarnet(usuario.getCodUsuario());
                    ssUsuarioSesion.setEsCambioClave(Constantes.ESTADO_SI);
                    usuario.setClave(usuario.getCodUsuario());
                    ssUsuarioSesionFacade.edit(ssUsuarioSesion);
                } catch (Exception ex) {
                    usuario.setClave(usuario.getCodUsuario());
                    ssUsuarioSesion = new SsUsuarioSesion();
                    ssUsuarioSesion.setCodUsuarioCarnet(usuario.getCodUsuario());
                    ssUsuarioSesion.setEsAlumno(Constantes.ESTADO_NO);
                    ssUsuarioSesion.setEsCambioClave(Constantes.ESTADO_SI);
                    ssUsuarioSesion.setEsPrimerInicioSesion(Constantes.ESTADO_SI);
                    ssUsuarioSesionFacade.create(ssUsuarioSesion);
                }
            }
            if (!isEditUsuario) {
                usuarioFacade.create(usuario);
                perfilXUsuario.setCodUsuario(usuario.getCodUsuario());
                perfilXUsuarioFacade.create(perfilXUsuario);
            } else {
                usuarioFacade.edit(usuario);
                perfilXUsuario.setCodUsuario(usuario.getCodUsuario());
                perfilXUsuarioFacade.edit(perfilXUsuario);
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almaceno correctamente el usuario");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error editando el usuario", ex);
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error guardando usuario");
        }
    }

    public void removeUsuario() {
        try {
            usuarioFacade.remove(usuario);
            isEditUsuario = false;
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimino correctamente el usuario");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el usuario", ex);
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error eliminando usuario");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.isEditUsuario = true;
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return usuarioFacade.createQueryNombra("Usuario.findAll", Usuario.class);
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
