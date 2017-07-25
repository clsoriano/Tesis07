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
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jcsoriano
 */
@Controller
public class CatalogoController implements Serializable {

    private static final Logger LOG = Logger.getLogger(CatalogoController.class.getName());

    @Inject
    private SsTipoCatalogoFacade ssTipoCatalogoFacade;
    @Inject
    private SsSubCatalogoFacade ssSubCatalogoFacade;
    private SsTipoCatalogo ssTipoCatalogo;
    private List<SsTipoCatalogo> listSsTipoCatalogo;
    private SsSubCatalogo ssSubCatalogo;
    private List<SsSubCatalogo> listSsSubCatalogo;
    private boolean isEditCatalogo;
    private boolean isEditSubCatalogo;
//    private boolean isEdiCatalogo;
//    private boolean isSubCatalogo;

    @PostConstruct
    public void _init() {
        isEditCatalogo = false;
        obtenerListaSsTipoCatalogo();
    }

    public void obtenerListaSsTipoCatalogo() {
        listSsTipoCatalogo = ssTipoCatalogoFacade.findAll();
    }

    // <editor-fold defaultstate="collapsed" desc="Administracion de SstipoCatalogo">
    public SsTipoCatalogo getSsTipoCatalogo() {
        return ssTipoCatalogo;
    }

    public void setSsTipoCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        this.ssTipoCatalogo = ssTipoCatalogo;
    }

    public List<SsTipoCatalogo> getListSsTipoCatalogo() {
        return listSsTipoCatalogo;
    }

    public void setListSsTipoCatalogo(List<SsTipoCatalogo> listSsTipoCatalogo) {
        this.listSsTipoCatalogo = listSsTipoCatalogo;
    }

    public void setSelectedSsTipoCatalogo(SsTipoCatalogo ssTipoCatalogo) {
        this.ssTipoCatalogo = ssTipoCatalogo;
        this.listSsSubCatalogo = ssTipoCatalogo.getSsSubCatalogoList();
    }

    public SsTipoCatalogo getSelectedSsTipoCatalogo() {
        return ssTipoCatalogo;
    }

    //Eventos de seleccion
    public boolean isIsEditCatalogo() {
        return isEditCatalogo;
    }

    public void setIsEditCatalogo(boolean isEditCatalogo) {
        this.isEditCatalogo = isEditCatalogo;
    }
    //Eventos de seleccion

    public void newEditSsTipoCatalogo() {
        if (!isEditCatalogo) {
            this.ssTipoCatalogo = new SsTipoCatalogo();
        }
    }

    public void saveSsTipoCatalogo() {
        try {
            if (!isEditCatalogo) {
                ssTipoCatalogoFacade.create(ssTipoCatalogo);
                addMessages(FacesMessage.SEVERITY_INFO, "Guardar", "Se guardo catalogo:" + ssTipoCatalogo.getCodTipo());
            } else {
                ssTipoCatalogoFacade.edit(ssTipoCatalogo);
                addMessages(FacesMessage.SEVERITY_INFO, "Edicion", "Se modifico correctamente catalogo:" + ssTipoCatalogo.getCodTipo());
            }
            obtenerListaSsTipoCatalogo();
            RequestContext.getCurrentInstance().execute("PF('modalAddEditTipoCatalogo').hide()");
        } catch (Exception ex) {
            addMessages(FacesMessage.SEVERITY_ERROR, "Guardar", "Error guardando catalogo:" + ssTipoCatalogo.getCodTipo());
            LOG.log(Level.SEVERE, "Error guardando catalogo", ex);
        }
    }

    public void removeSsTipoCatalogo() {
        try {
            ssTipoCatalogoFacade.remove(ssTipoCatalogo);
            addMessages(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimino correctamente catalogo:" + ssTipoCatalogo.getCodTipo());
            obtenerListaSsTipoCatalogo();
        } catch (Exception ex) {
            addMessages(FacesMessage.SEVERITY_ERROR, "Eliminar", "Error eliminando catalogo:" + ssTipoCatalogo.getCodTipo());
            LOG.log(Level.SEVERE, "Error eliminando catalogo", ex);
        }
    }

    public void cancelTipoCatalogo() {
        this.isEditCatalogo = false;
        RequestContext.getCurrentInstance().execute("PF('modalAddEditTipoCatalogo').hide()");
    }

    // </editor-fold>
//--------------------------------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Administracion de SsSubCatalogo">
    public void setSelectedSsSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        this.ssSubCatalogo = ssSubCatalogo;
    }

    public SsSubCatalogo getSelectedSsSubCatalogo() {
        return this.ssSubCatalogo;
    }

    public boolean isIsEditSubCatalogo() {
        return isEditSubCatalogo;
    }

    public void setIsEditSubCatalogo(boolean isEditSubCatalogo) {
        this.isEditSubCatalogo = isEditSubCatalogo;
    }

    public SsSubCatalogo getSsSubCatalogo() {
        return ssSubCatalogo;
    }

    public void setSsSubCatalogo(SsSubCatalogo ssSubCatalogo) {
        this.ssSubCatalogo = ssSubCatalogo;
    }

    public List<SsSubCatalogo> getListSsSubCatalogo() {
        return listSsSubCatalogo;
    }

    public void setListSsSubCatalogo(List<SsSubCatalogo> listSsSubCatalogo) {
        this.listSsSubCatalogo = listSsSubCatalogo;
    }

    public void newEditSsSubCatalogo() {
        if (isEditSubCatalogo) {
            this.ssSubCatalogo = new SsSubCatalogo();
            this.ssSubCatalogo.setCodCatalogo(ssTipoCatalogo);
            LOG.log(Level.INFO, "Inicializando SsSubCatalogo");
        }
        RequestContext.getCurrentInstance().execute("PF('modalAddEditSubCatalogo').show()");
    }

    public void saveSsSubCatalogo() {
        try {
            if (isEditSubCatalogo) {
                ssSubCatalogoFacade.create(ssSubCatalogo);
                addMessages(FacesMessage.SEVERITY_INFO, "Guardar", "Se guardo subcatalogo:" + ssSubCatalogo.getDescripcion());
            } else {
                ssSubCatalogoFacade.edit(ssSubCatalogo);
                addMessages(FacesMessage.SEVERITY_INFO, "Edicion", "Se modifico correctamente subcatalogo:" + ssSubCatalogo.getDescripcion());
            }
            RequestContext.getCurrentInstance().execute("PF('modalAddEditSubCatalogo').show()");
        } catch (Exception ex) {
            addMessages(FacesMessage.SEVERITY_FATAL, "Guardar", "Ocurrio un error modificando subcatalogo:" + ssSubCatalogo.getDescripcion());
            LOG.log(Level.INFO, "Ocurrio un error almacenando SsSubCatalogo", ex);
        }
    }

    public void removeSsSubCatalogo() {
        try {
            ssSubCatalogoFacade.edit(ssSubCatalogo);
            addMessages(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimino correctamente subcatalogo:" + ssSubCatalogo.getDescripcion());
        } catch (Exception ex) {
            addMessages(FacesMessage.SEVERITY_INFO, "Eliminar", "Ocurrio un error eliminando subcatalogo:" + ssSubCatalogo.getDescripcion());
            LOG.log(Level.INFO, "Ocurrio un error eliminando SsSubCatalogo", ex);
        }
    }

    public void cancelSubTipoCatalogo() {
        this.isEditCatalogo = false;
        RequestContext.getCurrentInstance().execute("PF('modalAddEditSubCatalogo').hide()");
    }
    // </editor-fold>

//Manejo de mensajes growl
    public void addMessages(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));

    }
}
