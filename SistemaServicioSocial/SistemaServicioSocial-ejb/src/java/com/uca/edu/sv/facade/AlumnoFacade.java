/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.bd.Alumno;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
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
public class AlumnoFacade extends AbstractFacade<Alumno> implements Serializable {

    private static final Logger LOG = Logger.getLogger(UsuarioFacade.class.getName());

    public AlumnoFacade() {
        super(Alumno.class);
    }

    public Alumno validaAlumnoLogin(String carne, String password) {
        HashMap<String, Object> parametros = new HashMap<>();
        try {
            parametros.put("carne", carne);
            parametros.put("password", encryptPasswordAlumno(password));
            return createQueryNombra("Alumno.findCarne", parametros, Alumno.class);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error validando usuario", ex);
        }
        return null;
    }

    private String encryptPasswordAlumno(String password) throws Exception {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes("UTF-8"));
            byte[] hash = digest.digest();
            Formatter formatter = new Formatter();
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            String result = formatter.toString();
            formatter.close();
            return result;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error encriptando password.", ex);
            throw new Exception("Error encriptando password");
        }
    }

    public List<Alumno> findAll() {
        return createQueryNombra("Alumno.findAll", Alumno.class);
    }
}
