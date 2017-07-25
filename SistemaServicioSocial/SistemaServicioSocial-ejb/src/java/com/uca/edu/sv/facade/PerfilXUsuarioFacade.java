/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.PerfilXUsuario;
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
public class PerfilXUsuarioFacade extends AbstractFacade<PerfilXUsuario> implements Serializable {

    public PerfilXUsuarioFacade() {
        super(PerfilXUsuario.class);
    }

    public PerfilXUsuario findByUsuario(String codUsuario) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codUsuario", codUsuario);
        return createQueryNombra("PerfilXUsuario.findByCodUsuario", parametros, PerfilXUsuario.class);
    }
}
