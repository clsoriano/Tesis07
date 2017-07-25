/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Pais;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.PaisFacade;
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
public class PaisController implements Serializable {

    private static final Logger LOG = Logger.getLogger(PaisController.class.getName());

    @Inject
    private PaisFacade paisFacade;
    private Pais pais;
    private List<Pais> paisList;
    private boolean isEditPais;

    @PostConstruct
    public void _init() {

    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getPaisList() {
        return paisFacade.findAll();
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public boolean isIsEditPais() {
        return isEditPais;
    }

    public void setIsEditPais(boolean isEditPais) {
        this.isEditPais = isEditPais;
    }

    public void setSelectedPais(Pais pais) {
        isEditPais = true;
        this.pais = pais;
    }

    public void newPais() {
        isEditPais = false;
        this.pais = new Pais();
    }

    public void savePais() {
        try {
            if (!isEditPais) {
                paisFacade.create(pais);
            } else {
                paisFacade.edit(pais);
            }
            isEditPais = false;
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almacena correctamente el pais.");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el pais", ex);
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error almacenando el pais.");
        }
    }

    public void removePais() {
        try {
            paisFacade.remove(pais);
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se elimina correctamente el pais.");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el pais", ex);
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error eliminando el pais.");
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}
