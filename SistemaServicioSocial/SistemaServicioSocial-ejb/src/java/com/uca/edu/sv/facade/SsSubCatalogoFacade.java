/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsSubCatalogo;
import java.io.Serializable;
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
public class SsSubCatalogoFacade extends AbstractFacade<SsSubCatalogo> implements Serializable {

    public SsSubCatalogoFacade() {
        super(SsSubCatalogo.class);
    }

    public List<SsSubCatalogo> getListSsSubCatalogo(HashMap<String, Object> parametros) {
        return null;
    }
}