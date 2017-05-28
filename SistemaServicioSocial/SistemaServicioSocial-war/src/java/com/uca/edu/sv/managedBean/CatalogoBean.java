/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.facade.SsSubCatalogoFacade;
import com.uca.edu.sv.facade.SsTipoCatalogoFacade;
import com.uca.edu.sv.ss.SsSubCatalogo;
import com.uca.edu.sv.ss.SsTipoCatalogo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jcsoriano
 */
@Named
@ViewScoped
public class CatalogoBean implements Serializable {

    private Logger log = Logger.getLogger(CatalogoBean.class.getName());

    @EJB
    private SsTipoCatalogoFacade ssTipoCatalogoFacade;
    @EJB
    private SsSubCatalogoFacade ssSubCatalogoFacade;
    private SsTipoCatalogo ssTipoCatalogo;
    private SsSubCatalogo ssSubCatalogo;
    private List<SsTipoCatalogo> listSsTipoCatalogo;
    private List<SsSubCatalogo> listSsSubCatalogo;

    public CatalogoBean() {
        this.ssTipoCatalogo = new SsTipoCatalogo();
    }

    public void setSsTipoCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        this.ssTipoCatalogo = ssTipoCatalogo;
    }

    public SsTipoCatalogo getSsTipoCatalogo() {
        return this.ssTipoCatalogo;
    }

    public void setSsSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        this.ssSubCatalogo = ssSubCatalogo;
    }

    public SsSubCatalogo getSsSubCatalogo() {
        return this.ssSubCatalogo;
    }

    public List<SsTipoCatalogo> getListSsTipoCatalogo() {
        try {
            this.listSsTipoCatalogo = ssTipoCatalogoFacade.findAll();
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error obteniendo lista de tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccion", "Ocurrio un error obteniendo lista de tipo catalogo"));
        }
        return this.listSsTipoCatalogo;
    }

    public void setSelectedCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        try {
            //jcsoriano-10052017:Se debe realizar la busqueda segun el tipo de catalogo seleccionado en data table
            if (ssTipoCatalogo != null) {
                HashMap<String, Object> parametros = new HashMap<>();
                parametros.put("codSubCatalogo", ssTipoCatalogo.getCodSubCatalogo().getCodSubCatalogo());
                this.listSsSubCatalogo = ssSubCatalogoFacade.getListSsSubCatalogo(parametros);
                this.ssTipoCatalogo = ssTipoCatalogo;
            }
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error obteniendo lista de sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccion", "Error seleccionando tipo catalogo"));
        }

    }

    public void setSelectedSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        try {
            //jcsoriano-10052017:Se debe realizar la busqueda segun el tipo de catalogo seleccionado en data table
            this.ssSubCatalogo = ssSubCatalogo;
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error obteniendo lista de sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccion", "Error seleccionando sub catalogo"));
        }

    }

    public List<SsSubCatalogo> getLisSsSubCatalogo() {
        return this.listSsSubCatalogo;
    }

    public String saveCatalogo() {
        try {
            ssTipoCatalogoFacade.create(this.ssTipoCatalogo);
            return "listaCatalogo?faces-redirect=true";
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error guardando tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ocurrio un error guardando tipo catalogo"));
        }
        return null;
    }

    public String saveSubCatalogo() {
        try {
            ssTipoCatalogoFacade.create(this.ssTipoCatalogo);
            return "listaCatalogo?faces-redirect=true";
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error guardando sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ocurrio un error guardando sub tipo catalogo"));
        }
        return null;
    }
}
