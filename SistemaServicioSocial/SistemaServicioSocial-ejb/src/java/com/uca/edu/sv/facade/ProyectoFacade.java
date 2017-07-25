/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.uca.edu.sv.bd.Proyecto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class ProyectoFacade extends AbstractFacade<Proyecto> implements Serializable {
    
    public ProyectoFacade() {
        super(Proyecto.class);
    }
    
    @Override
    public void edit(Proyecto proyecto) {
        proyecto.setFechaModificacion(new Date());
        getEntityManager().merge(proyecto);
    }
    
    public List<Proyecto> findAll() {
        return createQueryNombra("Proyecto.findAll", Proyecto.class);
    }
}
