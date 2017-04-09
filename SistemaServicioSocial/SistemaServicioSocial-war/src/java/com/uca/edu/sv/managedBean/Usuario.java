/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jcsoriano
 */
@ManagedBean(name = "usuario")
@RequestScoped
public class Usuario implements Serializable{
    
    /**
     * Creates a new instance of Usuario
     */
    public Usuario() {
    }
    
    public List<Usuario> getUsuarios(){
        return null;
    }
    
    public String renderUsuario(){
        return "usuario";
    }
}
