/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsCampoFormulario;
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
public class SsCampoFormularioFacade extends AbstractFacade<SsCampoFormulario> implements Serializable {

    public SsCampoFormularioFacade() {
        super(SsCampoFormulario.class);
    }

    public List<SsCampoFormulario> findAll() throws Exception {
        return createQueryNombra("SsCampoFormulario.findAll", SsCampoFormulario.class);
    }

}
