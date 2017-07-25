/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Perfil;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.PerfilFacade;
import com.uca.edu.sv.facade.SsMenuFacade;
import com.uca.edu.sv.facade.SsPerfilXMenuFacade;
import com.uca.edu.sv.ss.SsMenu;
import com.uca.edu.sv.ss.SsPerfilXMenu;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class PerfilXMenuController implements Serializable {

    private static final Logger LOG = Logger.getLogger(PerfilXMenuController.class.getName());

    @Inject
    private SsPerfilXMenuFacade ssPerfilXMenuFacade;
    @Inject
    private SsMenuFacade ssMenuFacade;
    @Inject
    private PerfilFacade perfilFacade;
    private SsPerfilXMenu ssPerfilXMenu;
    private boolean isEditPerfilXMenu;
    private List<SsMenu> listSsMenu;
    private List<Perfil> listPerfil;
    private BigDecimal codMenu;

    @PostConstruct
    public void _init() {
        ssPerfilXMenu = new SsPerfilXMenu();
        listSsMenu = ssMenuFacade.getMenuXCodMenuPadreList(new HashMap<String, Object>());
        listPerfil = perfilFacade.findAll();
    }

    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public List<SsMenu> getListSsMenu() {
        return listSsMenu;
    }

    public void setListSsMenu(List<SsMenu> listSsMenu) {
        this.listSsMenu = listSsMenu;
    }

    public SsPerfilXMenu getSsPerfilXMenu() {
        return ssPerfilXMenu;
    }

    public void setSsPerfilXMenu(SsPerfilXMenu ssPerfilXMenu) {
        this.ssPerfilXMenu = ssPerfilXMenu;
    }

    public boolean isIsEditPerfilXMenu() {
        return isEditPerfilXMenu;
    }

    public void setIsEditPerfilXMenu(boolean isEditPerfilXMenu) {
        this.isEditPerfilXMenu = isEditPerfilXMenu;
    }

    public List<SsPerfilXMenu> getListPerfilXMenu() {
        return ssPerfilXMenuFacade.findAll();
    }

    public void valueMenuChange(ValueChangeEvent event) {
        codMenu = (BigDecimal) event.getNewValue();
    }

    public List<SsMenu> getMenuChildList() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codMenuPadre", codMenu != null ? codMenu : ssPerfilXMenu.getCodMenu());
        return ssMenuFacade.getMenuXCodMenuChildList(parametros);
    }

    public String getDescripcionMenu(BigDecimal codMenu) {
        for (SsMenu m : ssMenuFacade.findAll()) {
            if (m.getCodMenu().equals(codMenu)) {
                return m.getDescripcion();
            }
        }
        return null;
    }

    public void setSelectedPerfilXMenu(SsPerfilXMenu ssPerfilXMenu) {
        this.isEditPerfilXMenu = true;
        this.ssPerfilXMenu = ssPerfilXMenu;
    }

    public void newPerfilMenu() {
        isEditPerfilXMenu = false;
        ssPerfilXMenu = new SsPerfilXMenu();
    }

    public void savePerfilMenu() {
        try {
            if (!isEditPerfilXMenu) {
                ssPerfilXMenuFacade.create(ssPerfilXMenu);
            } else {
                ssPerfilXMenuFacade.edit(ssPerfilXMenu);
            }
            addMessage(FacesMessage.SEVERITY_INFO, "Guardar", "Se almaceno correctamente perfil/menu.");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando perfil/menu", ex);
            addMessage(FacesMessage.SEVERITY_INFO, "Error", "Error almacenando perfil/menu.");
        }
    }

    public void removePerfilXMenu() {
        try {
            ssPerfilXMenuFacade.remove(ssPerfilXMenu);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando perfil/menu", ex);
            addMessage(FacesMessage.SEVERITY_INFO, "Error", "Error almacenando perfil/menu.");
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

}
