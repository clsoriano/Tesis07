/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.UsuarioFacade;
import com.uca.edu.sv.ss.Usuario;
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
    private Usuario usuario;
    private boolean editable;

    @PostConstruct
    public void _init() {

    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String newUsuario() {
        this.usuario = new Usuario();
        return "nuevoUsuario?faces-redirect=true";
    }

    public String editUsuario() {
        return "editUsuario?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.editable = true;
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return usuarioFacade.createQueryNombra("Usuario.findAll", Usuario.class);
    }

    public String create() {
        try {
            usuarioFacade.create(usuario);
            return "listaUsuario?faces-redirect=true";
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el usuario", ex);
            addMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Error guardando usuario");
            return null;
        }
    }

    public String edit() {
        try {
            usuarioFacade.edit(usuario);
            this.editable = false;
            return "listaUsuario?faces-redirect=true";
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error editando el usuario", ex);
            addMessage(FacesMessage.SEVERITY_ERROR, "Edicion", "Error modificando usuario");
            return null;
        }
    }

    public void remove() {
        try {
            usuarioFacade.remove(usuario);
            this.editable = false;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el usuario", ex);
            addMessage(FacesMessage.SEVERITY_ERROR, "Eliminar", "Error eliminando usuario");
        }
    }

    public String cancel() {
        this.editable = false;
        return "listaUsuario?faces-redirect=true";
    }

    public void addMessage(FacesMessage.Severity severity,String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
