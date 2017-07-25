/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Proyecto;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.ProyectoFacade;
import java.io.Serializable;
import java.util.List;
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
public class ProyectoController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProyectoController.class.getName());

    @Inject
    private ProyectoFacade proyectoFacade;
    private Proyecto proyecto;
    private List<Proyecto> proyectoList;
    private boolean isEditProyecto;

    @PostConstruct
    public void _init() {
        LOG.log(Level.INFO, "Inicializando variables proyecto.");
        proyecto = new Proyecto();
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Proyecto> getProyectoList() {
        proyectoList = proyectoFacade.findAll();
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public boolean isIsEditProyecto() {
        return isEditProyecto;
    }

    public void setIsEditProyecto(boolean isEditProyecto) {
        this.isEditProyecto = isEditProyecto;
    }

    public void setSelectedProyecto(Proyecto proyecto) {
        setIsEditProyecto(true);
        this.proyecto = proyecto;
    }

    public void newProyecto() {
        setIsEditProyecto(false);
        proyecto = new Proyecto();
        executeFunction("PF('modalAddEditProyecto').show();return false;");
    }

    public void saveProyecto() {
        try {
            if (!isEditProyecto) {
                proyectoFacade.create(proyecto);
            } else {
                proyectoFacade.edit(proyecto);
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almaceno correctamente proyecto.");
            executeFunction("PF('modalAddEditProyecto').hide();return false;");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el proyecto", ex);
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un error almaceno proyecto.");
        }
    }

    public void removeProyecto() {
        try {
            proyectoFacade.remove(proyecto);
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimino correctamente proyecto.");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error eliminandos el proyecto", ex);
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Ocurrio un error almaceno proyecto.");
        }
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    private void executeFunction(String execute) {
        RequestContext.getCurrentInstance().execute(execute);
    }
}
