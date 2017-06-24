/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsPerfilXMenu;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class PerfilXMenuFacade extends AbstractFacade<SsPerfilXMenu> implements Serializable {

    public PerfilXMenuFacade() {
        super(SsPerfilXMenu.class);
    }
}