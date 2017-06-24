/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.ss.SsMenu;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jcsoriano
 */
public class Menu implements Serializable {

    private SsMenu menu;
    private List<SsMenu> subMenu;
    private String nameMenuPadre;

    public Menu() {
    }

    public Menu(SsMenu menu) {
        //Buscar opciones
        this.menu = menu;        
    }

    public SsMenu getMenu() {
        return menu;
    }

    public void setMenu(SsMenu menu) {
        this.menu = menu;
    }

    public List<SsMenu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<SsMenu> subMenu) {
        this.subMenu = subMenu;
    }

    public String getNameMenuPadre() {
        return nameMenuPadre;
    }

    public void setNameMenuPadre(String nameMenuPadre) {
        this.nameMenuPadre = nameMenuPadre;
    }
    
    

}
