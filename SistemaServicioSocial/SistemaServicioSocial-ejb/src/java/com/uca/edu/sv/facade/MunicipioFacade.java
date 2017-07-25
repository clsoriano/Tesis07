/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Municipio;
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
public class MunicipioFacade extends AbstractFacade<Municipio> implements Serializable {

    public MunicipioFacade() {
        super(Municipio.class);
    }

    public List<Municipio> findByDepto(String codDepartamento) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codDepartamento", codDepartamento);
        return createQueryListNombra("Municipio.findByDepto", parametros, Municipio.class);
    }
}
