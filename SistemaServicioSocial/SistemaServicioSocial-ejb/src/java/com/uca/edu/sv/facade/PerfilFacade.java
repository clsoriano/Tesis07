/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Perfil;
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
public class PerfilFacade extends AbstractFacade<Perfil> implements Serializable {

    public PerfilFacade() {
        super(Perfil.class);
    }

    public List<Perfil> findAll() {
        return createQueryNombra("Perfil.findAll", Perfil.class);
    }

    public List<Perfil> findByPerfil(String codPerfil) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codPerfil", codPerfil);
        return createQueryListNombra("Perfil.findPerfil", parametros, Perfil.class);
    }
}
