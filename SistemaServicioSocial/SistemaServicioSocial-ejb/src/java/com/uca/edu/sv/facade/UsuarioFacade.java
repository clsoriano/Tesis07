/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import com.uca.edu.exception.ExceptionServicioSocial;
import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.mail.SendMail;
import com.uca.edu.sv.process.Constantes;
import com.uca.edu.sv.ss.SsUsuarioSesion;
import java.io.Serializable;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sun.misc.BASE64Encoder;

/**
 *
 * @author jcsoriano
 */
@Stateless
@LocalBean
public class UsuarioFacade extends AbstractFacade<Usuario> implements Serializable {

    private static final Logger LOG = Logger.getLogger(UsuarioFacade.class.getName());

    @Inject
    private SendMail sendMail;
    @Inject
    private SsUsuarioSesionFacade ssUsuarioSesionFacade;

    private byte[] salt = {
        -87, -101, -56, 50,
        86, 53, -29, 3};
    private int iterationCount = 19;
    private String passPhrase = "ckret4all";
    private Cipher cipher;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @PostConstruct
    public void _init() {
        try {
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), this.salt, this.iterationCount);
            SecretKey key = SecretKeyFactory.getInstance(
                    "PBEWithMD5AndDES").generateSecret(keySpec);
            cipher = Cipher.getInstance(key.getAlgorithm());
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(this.salt, this.iterationCount);
            cipher.init(1, key, paramSpec);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error encriptando password.", ex);
        }
    }

    @Override
    public void create(Usuario usuario) {
        try {
            if (usuario.getClave() != null && !usuario.getClave().isEmpty()) {
                usuario.setClave(encryptPasswordUsuario(usuario.getClave()));
            }
            getEntityManager().persist(usuario);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error guardando usuario", ex);
        }
    }

    @Override
    public void edit(Usuario usuario) {
        try {
            if (usuario.getClave() != null && !usuario.getClave().isEmpty()) {
                usuario.setClave(encryptPasswordUsuario(usuario.getClave()));
            }
            getEntityManager().merge(usuario);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error guardando usuario", ex);
        }
    }

    public Usuario validaUsuarioLogin(String usuario, String password) {
        HashMap<String, Object> parametros = new HashMap<>();
        try {
            parametros.put("codUsuario", usuario);
            parametros.put("clave", encryptPasswordUsuario(password));
            return createQueryNombra("Usuario.findUsuario", parametros, Usuario.class);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error validando usuario", ex);
        }
        return null;
    }

    private String encryptPasswordUsuario(String password) throws Exception {
        try {
            BASE64Encoder base = new BASE64Encoder();
            return base.encode(cipher.doFinal(password.getBytes("UTF8")));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error encriptando password.", ex);
            throw new ExceptionServicioSocial("Error encriptando password");
        }
    }

    private String generatorPassword() {
        char[] elementos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] conjunto = new char[8];
        for (int i = 0; i < 8; i++) {
            int el = (int) (Math.random() * 37);
            conjunto[i] = (char) elementos[el];
        }
        return new String(conjunto);
    }

    public void asignarPassword(Usuario usuario) throws ExceptionServicioSocial {
        String password = generatorPassword();
        usuario.setEstado(Constantes.ESTADO_ACTIVO);
        usuario.setClave(password);
        edit(usuario);
        SsUsuarioSesion ssUsuarioSesion = ssUsuarioSesionFacade.findByCodUsuarioCarnet(usuario.getCodUsuario());
        sendMail.buildMail(ssUsuarioSesion.getCorreo(), Constantes.MAIL_USUARIO, usuario, password);
    }

    public Usuario findByUsuario(String usuario) {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codUsuario", usuario);
        return createQueryNombra("Usuario.findByUsuario", parametros, Usuario.class);
    }

    public List<Usuario> findByTipInstitucion() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("codPerfil", Constantes.PERFIL_INSTI);
        parametros.put("estado", Constantes.ESTADO_INACTIVO);
        return createQueryListNombra("Usuario.findByTipInstitucion", parametros, Usuario.class);
    }

}
