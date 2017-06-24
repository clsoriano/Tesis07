/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsMenu;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class SsMenuFacade extends AbstractFacade<SsMenu> implements Serializable {

    public SsMenuFacade() {
        super(SsMenu.class);
    }

    public List<SsMenu> getMenuXUsuario(HashMap<String, Object> parametros) {
        return createQueryListNombra("SsMenu.findByUsuario", parametros, SsMenu.class);
    }

    public List<SsMenu> getMenuXCodMenuPadre(HashMap<String, Object> parametros) {
        return createQueryListNombra("SsMenu.findByCodMenuPadre", parametros, SsMenu.class);
    }

    public List<SsMenu> findAll() {
        return createQueryNombra("SsMenu.findAll", SsMenu.class);
    }

    public List<SsMenu> findMenuPadre() {
        return createQueryNombra("SsMenu.findMenuPadre", SsMenu.class);
    }

    public SsMenu findMenuPadreByCod(String codMenu) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codMenu", new BigDecimal(codMenu));
        return createQueryNombra("SsMenu.findByCodMenu", parametros, SsMenu.class);
    }
}
