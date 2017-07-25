/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Pais;
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
public class PaisFacade extends AbstractFacade<Pais> implements Serializable {

    public PaisFacade() {
        super(Pais.class);
    }

    public List<Pais> findAll() {
        return createQueryNombra("Pais.findAll", Pais.class);
    }
}
