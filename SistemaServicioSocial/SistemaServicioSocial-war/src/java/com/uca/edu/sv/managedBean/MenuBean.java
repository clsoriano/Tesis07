/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.SsMenuFacade;
import com.uca.edu.sv.ss.SsMenu;
import java.io.Serializable;
import java.util.List;
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
public class MenuBean implements Serializable {

    @Inject
    private SsMenuFacade ssMenuFacade;
    private SsMenu ssMenu;
    private boolean isEditMenu;

    @PostConstruct
    public void _init() {
        ssMenu = new SsMenu();
    }

    public boolean isIsEditMenu() {
        return isEditMenu;
    }

    public void setIsEditMenu(boolean isEditMenu) {
        this.isEditMenu = isEditMenu;
    }

    public void setSelectedSsMenu(SsMenu ssMenu) {
        this.isEditMenu = true;
        this.ssMenu = ssMenu;
    }

    public SsMenu getSelectedSsMenu() {
        return ssMenu;
    }

    public List<SsMenu> getListMenu() {
        return ssMenuFacade.findAll();
    }

    public List<SsMenu> getListMenuPadre() {
        return ssMenuFacade.findMenuPadre();
    }

    public void nuevoMenu() {
        isEditMenu = false;
        ssMenu = new SsMenu();
    }

    public SsMenu getSsMenu() {
        return ssMenu;
    }

    public void setSsMenu(SsMenu ssMenu) {
        this.ssMenu = ssMenu;
    }

    public void saveMenu() {
        try {
            if (!isEditMenu) {
                ssMenuFacade.create(ssMenu);
            } else {
                ssMenuFacade.edit(ssMenu);
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Almacenado", "Se almaceno menu correctamente.");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error almacenando menu correctamente.");
        }
    }

    public void removeMenu() {
        try {
            ssMenuFacade.remove(ssMenu);
            addMessage(FacesMessage.SEVERITY_INFO, "Eliminar", "Se elimina opcion de menu correctamente.");
        } catch (Exception ex) {
            addMessage(FacesMessage.SEVERITY_FATAL, "Error", "Error eliminando menu correctamente.");
        }
    }

    public void addMessage(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public String getNamePadre(String codMenu) {
        if (codMenu != null && !codMenu.equals("0")) {
            SsMenu ssMenu = ssMenuFacade.findMenuPadreByCod(codMenu);
            return ssMenu.getDescripcion();
        }
        return "";
    }

}
