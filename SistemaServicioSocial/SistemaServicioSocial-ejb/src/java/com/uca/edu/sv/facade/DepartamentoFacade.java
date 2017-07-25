/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Departamento;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class DepartamentoFacade extends AbstractFacade<Departamento> implements Serializable {

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    public List<Departamento> findAll() {
        return createQueryNombra("Departamento.findAll", Departamento.class);
    }
}
