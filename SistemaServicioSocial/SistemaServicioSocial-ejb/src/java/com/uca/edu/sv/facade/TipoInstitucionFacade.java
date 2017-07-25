/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.TipoInstitucion;
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
public class TipoInstitucionFacade extends AbstractFacade<TipoInstitucion> implements Serializable {

    public TipoInstitucionFacade() {
        super(TipoInstitucion.class);
    }

    public List<TipoInstitucion> findAll() {
        return createQueryNombra("TipoInstitucion.findAll", TipoInstitucion.class);
    }
}
