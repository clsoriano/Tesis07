/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Perfil;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.PerfilFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class PerfilController implements Serializable {

    public static final Logger LOG = Logger.getLogger(PerfilController.class.getName());

    @Inject
    private PerfilFacade perfilFacade;
    private Perfil perfil;
    private List<Perfil> listPerfil;
    private boolean isEditPerfil;

    @PostConstruct
    public void _init() {
        perfil = new Perfil();
//        listPerfil = perfilFacade.findAll();
    }

    public boolean isIsEditPerfil() {
        return isEditPerfil;
    }

    public void setIsEditPerfil(boolean isEditPerfil) {
        this.isEditPerfil = isEditPerfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setSelectedPerfil(Perfil perfil) {
        this.isEditPerfil = true;
        this.perfil = perfil;
    }

    public Perfil getSelectedPerfil() {
        return perfil;
    }

    public List<Perfil> getListPerfil() {
        return perfilFacade.findAll();
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public void newPerfil() {
        isEditPerfil = false;
        this.perfil = new Perfil();
    }

    public void savePerfil() {
        try {
            if (!isEditPerfil) {
                perfilFacade.create(perfil);
            } else {
                perfilFacade.edit(perfil);
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almacena correctamente el perfil");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un error almacenando el perfil");
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el perfil", ex);
        }
    }

    public void removePerfil() {
        try {
            perfilFacade.remove(perfil);
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimino correctamente el perfil");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un error eliminando el perfil");
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el perfil", ex);
        }
    }

    public void addMessage(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
