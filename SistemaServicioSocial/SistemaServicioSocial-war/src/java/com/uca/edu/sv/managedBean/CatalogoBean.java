/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.SsSubCatalogoFacade;
import com.uca.edu.sv.facade.SsTipoCatalogoFacade;
import com.uca.edu.sv.ss.SsSubCatalogo;
import com.uca.edu.sv.ss.SsTipoCatalogo;
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
public class CatalogoBean implements Serializable {

    private Logger log = Logger.getLogger(CatalogoBean.class.getName());

    @Inject
    private SsTipoCatalogoFacade ssTipoCatalogoFacade;
    @Inject
    private SsSubCatalogoFacade ssSubCatalogoFacade;
    private SsTipoCatalogo ssTipoCatalogo;
    private SsSubCatalogo ssSubCatalogo;
    private List<SsTipoCatalogo> listSsTipoCatalogo;
    private List<SsSubCatalogo> listSsSubCatalogo;
    private boolean isEditable;
    private boolean isNewCatalogo;
    private boolean isNewSubCatalogo;
    private boolean isEditSubCatalogo;

    @PostConstruct
    public void _init() {
        this.ssTipoCatalogo = new SsTipoCatalogo();
        this.ssSubCatalogo = new SsSubCatalogo();
        this.isEditable = false;
        this.isNewCatalogo = false;
        this.isNewSubCatalogo = false;
        this.isEditSubCatalogo = false;
    }

    public void newTipoCatalogo() {
        this.isNewCatalogo = true;
        this.isEditable = false;
        this.ssTipoCatalogo = new SsTipoCatalogo();
        RequestContext.getCurrentInstance().execute("PF('modalAddEditCatalogo').show()");
    }

    public void newSubCatalogo() {
        this.ssSubCatalogo = new SsSubCatalogo();
        this.ssSubCatalogo.setCodCatalogo(this.ssTipoCatalogo);
        RequestContext.getCurrentInstance().execute("PF('modalAddEditSubCatalogo').show()");
    }

    public void deleteTipoCatalogo() {
        ssTipoCatalogoFacade.remove(ssTipoCatalogo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminar", "Se elimina correctamente tipo de catalogo"));
    }

    public void deleteSubCatalogo() {
        ssSubCatalogoFacade.remove(ssSubCatalogo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Eliminar", "Se elimina correctamente detalle de catalogo"));
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

    public void setSelectedSsTipoCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        try {
            this.ssTipoCatalogo = ssTipoCatalogo;
            this.isEditable = true;
            this.ssSubCatalogo = new SsSubCatalogo();
            if (ssTipoCatalogo != null) {
                this.listSsSubCatalogo = ssTipoCatalogo.getSsSubCatalogoList();
            }
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error obteniendo lista de sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccion", "Error seleccionando tipo catalogo"));
        }

    }

    public SsTipoCatalogo getSelectedSsTipoCatalogo() {
        return ssTipoCatalogo;
    }

    public void setSelectedSsSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        try {
            //jcsoriano-10052017:Se debe realizar la busqueda segun el tipo de catalogo seleccionado en data table
            this.isEditSubCatalogo = true;
            this.ssSubCatalogo = ssSubCatalogo;
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error obteniendo lista de sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seleccion", "Error seleccionando sub catalogo"));
        }
    }

    public SsSubCatalogo getSelectedSsSubCatalogo() {
        return ssSubCatalogo;
    }

    public List<SsSubCatalogo> getLisSsSubCatalogo() {
        return this.listSsSubCatalogo;
    }

    public void saveCatalogo() {
        try {
            ssTipoCatalogoFacade.create(this.ssTipoCatalogo);
            this.isNewCatalogo = false;
            RequestContext.getCurrentInstance().execute("PF('modalAddEditCatalogo').hide()");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error guardando tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ocurrio un error guardando tipo catalogo"));
        }
    }

    public void saveSubCatalogo() {
        try {
            ssSubCatalogoFacade.create(this.ssSubCatalogo);
            this.isNewSubCatalogo = false;
            RequestContext.getCurrentInstance().execute("PF('modalAddEditSubCatalogo').hide()");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Ocurrio un error guardando sub tipo catalogo", ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Guardar", "Ocurrio un error guardando sub tipo catalogo"));
        }
    }

    public boolean isIsEditable() {
        return isEditable;
    }

    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public boolean isIsNewCatalogo() {
        return isNewCatalogo;
    }

    public void setIsNewCatalogo(boolean isNewCatalogo) {
        this.isNewCatalogo = isNewCatalogo;
    }

    public boolean isIsNewSubCatalogo() {
        return isNewSubCatalogo;
    }

    public void setIsNewSubCatalogo(boolean isNewSubCatalogo) {
        this.isNewSubCatalogo = isNewSubCatalogo;
    }

    public boolean isIsEditSubCatalogo() {
        return isEditSubCatalogo;
    }

    public void setIsEditSubCatalogo(boolean isEditSubCatalogo) {
        this.isEditSubCatalogo = isEditSubCatalogo;
    }

    public SsTipoCatalogo getSsTipoCatalogo() {
        return ssTipoCatalogo;
    }

    public void setSsTipoCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        this.ssTipoCatalogo = ssTipoCatalogo;
    }

    public SsSubCatalogo getSsSubCatalogo() {
        return ssSubCatalogo;
    }

    public void setSsSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        this.ssSubCatalogo = ssSubCatalogo;
    }

}
