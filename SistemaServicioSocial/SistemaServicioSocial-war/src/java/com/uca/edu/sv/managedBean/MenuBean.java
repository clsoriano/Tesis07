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
    private boolean editable;

    @PostConstruct
    public void _init() {
        
    }

    public List<SsMenu> getListMenu() {
        return ssMenuFacade.findAll();
    }

    public List<SsMenu> getListMenuPadre() {
        return ssMenuFacade.findMenuPadre();
    }

    public String nuevoMenu() {
        ssMenu = new SsMenu();
        return "menu?faces-redirect=true";
    }

    public SsMenu getSsMenu() {
        return ssMenu;
    }

    public void setSsMenu(SsMenu ssMenu) {        
        this.editable = true;
        this.ssMenu = ssMenu;
    }

    public String saveMenu() {
        ssMenuFacade.create(ssMenu);
        addMessage("Almacenado", "Se almacana opcion de menu correctamente.");
        return "listaMenu?faces-redirect=true";
    }

    public String editMenu() {
        ssMenuFacade.edit(ssMenu);
        addMessage("Almacenado", "Se modifica opcion de menu correctamente.");
        return "listaMenu?faces-redirect=true";
    }

    public void deleteMenu() {
        this.editable = false;
        ssMenuFacade.remove(ssMenu);
        addMessage("Eliminar", "Se elimina opcion de menu correctamente.");
    }

    public String redirectEditMenu() {
        this.editable = false;
        return "editMenu?faces-redirec=true";
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public void addMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public String getNamePadre(String codMenu) {
        if (codMenu != null && !codMenu.equals("0")) {
            SsMenu ssMenu = ssMenuFacade.findMenuPadreByCod(codMenu);
            return ssMenu.getDescripcion();
        }
        return "";
    }
    
    public String cancel(){
        return "listaMenu?faces-redirect=true";
    }
}
