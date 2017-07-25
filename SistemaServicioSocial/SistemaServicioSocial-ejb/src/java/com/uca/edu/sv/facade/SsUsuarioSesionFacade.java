/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsUsuarioSesion;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class SsUsuarioSesionFacade extends AbstractFacade<SsUsuarioSesion> implements Serializable {

    public SsUsuarioSesionFacade() {
        super(SsUsuarioSesion.class);
    }

    public SsUsuarioSesion findByCodUsuarioCarnet(String codUsuarioCarnet) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codUsuarioCarnet", codUsuarioCarnet);
        return createQueryNombra("SsUsuarioSesion.findByCodUsuarioCarnet", parametros, SsUsuarioSesion.class);
    }

}
