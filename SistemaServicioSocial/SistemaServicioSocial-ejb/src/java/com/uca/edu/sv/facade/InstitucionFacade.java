/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Institucion;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class InstitucionFacade extends AbstractFacade<Institucion> implements Serializable {

    private static final Logger LOG = Logger.getLogger(InstitucionFacade.class.getName());

    public InstitucionFacade() {
        super(Institucion.class);
    }

    @Override
    public void create(Institucion institucion) {
        try {
            institucion.setModificadoPor("PR");
            institucion.setFechaModificacion(new Date());
//        getEntityManager().persist(institucion);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error almacenando la institucion.", ex);
        }
    }

    @Override
    public void edit(Institucion institucion) {
        institucion.setModificadoPor("PR");
        institucion.setFechaModificacion(new Date());
        getEntityManager().merge(institucion);
    }
}
