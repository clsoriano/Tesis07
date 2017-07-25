/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.SsPerfilXAlumno;
import java.io.Serializable;
import java.util.HashMap;
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
public class SsPerfilXAlumnoFacade extends AbstractFacade<SsPerfilXAlumno> implements Serializable {

    private static final Logger LOG = Logger.getLogger(UsuarioFacade.class.getName());

    public SsPerfilXAlumnoFacade() {
        super(SsPerfilXAlumno.class);
    }

    public SsPerfilXAlumno findPerfilAlumno(String carne) {
        HashMap<String, Object> parametros = new HashMap<>();
        try {
            parametros.put("carne", carne);
            return createQueryNombra("SsPerfilXAlumno.findCarne", parametros, SsPerfilXAlumno.class);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error validando usuario", ex);
        }
        return null;
    }
}
