/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Departamento;
import com.uca.edu.sv.bd.Municipio;
import com.uca.edu.sv.bd.MunicipioPK;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.DepartamentoFacade;
import com.uca.edu.sv.facade.MunicipioFacade;
import java.io.Serializable;
import java.util.ArrayList;
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
public class DeptoMuniController implements Serializable {

    private static final Logger LOG = Logger.getLogger(DeptoMuniController.class.getName());

    @Inject
    private DepartamentoFacade departamentoFacade;
    @Inject
    private MunicipioFacade municipioFacade;
    private Departamento departamento;
    private Municipio municipio;
    private List<Municipio> municipioList;
    private boolean isEditDepto;
    private boolean isEditMuni;

    @PostConstruct
    public void _init() {
        departamento = new Departamento();
        municipio = new Municipio();
        municipio.setMunicipioPK(new MunicipioPK());
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoFacade.findAll();
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
    }

    public List<Municipio> getMunicipioList() {
        if (departamento.getCodDepartamento() != null) {
            municipioList = municipioFacade.findByDepto(departamento.getCodDepartamento());
        } else {
            municipioList = new ArrayList<>();
        }
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public boolean isIsEditDepto() {
        return isEditDepto;
    }

    public void setIsEditDepto(boolean isEditDepto) {
        departamento = new Departamento();
        this.isEditDepto = isEditDepto;
    }

    public boolean isIsEditMuni() {
        return isEditMuni;
    }

    public void setIsEditMuni(boolean isEditMuni) {
        this.isEditMuni = isEditMuni;
    }

    public void setSelectedDepartamento(Departamento departamento) {
        isEditDepto = true;
        this.departamento = departamento;
    }

    public void newDepartamento() {
        isEditDepto = false;
        departamento = new Departamento();
    }

    public void saveDepartamento() {
        try {
            if (!isEditDepto) {
                departamentoFacade.create(departamento);
            } else {
                departamentoFacade.edit(departamento);
            }
            isEditDepto = false;
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almacena correctamente departamento");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error almacenando departamento");
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el departamento", ex);
        }
    }

    public void removeDepartamento() {
        try {
            departamentoFacade.remove(departamento);
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimina correctamente departamento");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error eliminando departamento");
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el departamento", ex);
        }
    }

    public void setSelectedMunicipio(Municipio municipio) {
        isEditMuni = true;
        this.municipio = municipio;
    }

    public void newMunicipio() {
        isEditMuni = false;
        municipio = new Municipio();
        municipio.setMunicipioPK(new MunicipioPK());
        municipio.getMunicipioPK().setCodDepartamento(departamento.getCodDepartamento());
    }

    public void saveMunicipio() {
        try {
            if (!isEditMuni) {
                municipioFacade.create(municipio);
            } else {
                municipioFacade.edit(municipio);
            }
            isEditMuni = false;
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almacena correctamente municipio");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error almacenando municipio");
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando el municipio", ex);
        }
    }

    public void removeMunicipio() {
        try {
            municipioFacade.remove(municipio);
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimina correctamente municipio");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error eliminando municipio");
            LOG.log(Level.SEVERE, "Ocurrio un error eliminando el municipio", ex);
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
