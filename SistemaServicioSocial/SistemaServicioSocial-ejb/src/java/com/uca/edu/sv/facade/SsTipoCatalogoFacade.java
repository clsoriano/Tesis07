/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsTipoCatalogo;
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
public class SsTipoCatalogoFacade extends AbstractFacade<SsTipoCatalogo> implements Serializable {

    public SsTipoCatalogoFacade() {
        super(SsTipoCatalogo.class);
    }

    public List<SsTipoCatalogo> findAll() {
        return createQueryNombra("SsTipoCatalogo.findAll", SsTipoCatalogo.class);
    }
}
