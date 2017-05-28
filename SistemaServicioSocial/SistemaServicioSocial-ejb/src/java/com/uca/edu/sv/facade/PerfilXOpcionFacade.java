/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.PerfilXOpcion;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class PerfilXOpcionFacade extends AbstractFacade<PerfilXOpcion> implements Serializable {

    public PerfilXOpcionFacade() {
        super(PerfilXOpcion.class);
    }
}
