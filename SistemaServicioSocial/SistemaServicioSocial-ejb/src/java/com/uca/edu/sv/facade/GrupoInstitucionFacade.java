/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.GrupoInstitucion;
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
public class GrupoInstitucionFacade extends AbstractFacade<GrupoInstitucion> implements Serializable {

    public GrupoInstitucionFacade() {
        super(GrupoInstitucion.class);
    }

    public List<GrupoInstitucion> findAll() {
        return createQueryNombra("GrupoInstitucion.findAll", GrupoInstitucion.class);
    }
}
