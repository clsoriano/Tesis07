/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.controller;

import com.uca.edu.sv.bd.Usuario;
import com.uca.edu.sv.facade.UsuarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class SolicitudUsuario implements Serializable {

    @Inject
    private UsuarioFacade usuarioFacade;
    private List<Usuario> usuarioList;
    private Usuario usuario;
    private boolean onUsuario;

    @PostConstruct
    public void _init() {
        refrescarUsuarioList();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isOnUsuario() {
        return onUsuario;
    }

    public void setOnUsuario(boolean onUsuario) {
        this.onUsuario = onUsuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    private void refrescarUsuarioList() {
        usuarioList = usuarioFacade.findByTipInstitucion();
    }

    public void verUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void activarUsuario(Usuario usuario) {
        try {
            usuarioFacade.asignarPassword(usuario);
            refrescarUsuarioList();
        } catch (Exception ex) {

        }
    }

}
