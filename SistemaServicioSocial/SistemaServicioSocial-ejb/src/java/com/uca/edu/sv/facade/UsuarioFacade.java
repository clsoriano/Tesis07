/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.sv.ss.Usuario;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
public class UsuarioFacade extends AbstractFacade<Usuario> implements Serializable {

    private static final Logger LOG = Logger.getLogger(UsuarioFacade.class.getName());

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public void create(Usuario usuario) {
        try {
            usuario.setClave(encryptPassword(usuario.getClave()));
            getEntityManager().persist(usuario);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error guardando usuario", ex);
        }
    }

    @Override
    public void edit(Usuario usuario) {
        try {
            usuario.setClave(encryptPassword(usuario.getClave()));
            getEntityManager().merge(usuario);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error guardando usuario", ex);
        }
    }

    public String encryptPassword(String password) throws Exception {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return new String(hash);
        } catch (Exception ex) {
            throw new Exception("Error encriptando password");
        }
    }
}
