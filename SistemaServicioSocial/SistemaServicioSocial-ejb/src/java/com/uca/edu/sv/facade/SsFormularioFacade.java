/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsFormulario;
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
public class SsFormularioFacade extends AbstractFacade<SsFormulario> implements Serializable {

    public SsFormularioFacade() {
        super(SsFormulario.class);
    }
    
    public List<SsFormulario> findAll() throws Exception {
        return createQueryNombra("SsFormulario.findAll", SsFormulario.class);
    }

}
