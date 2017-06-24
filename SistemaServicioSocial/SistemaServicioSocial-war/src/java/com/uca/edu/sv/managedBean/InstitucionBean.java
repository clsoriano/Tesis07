/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jcsoriano
 */
@Controller
public class InstitucionBean implements Serializable {

    @PostConstruct
    public void _init() {

    }

    public void registrar() {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Envio", "Se envio correo para confirmacion.");
        context.addMessage(null, facesMessage);
//        return "/login?faces-redirect=true";
    }

    public String login() {
        return "/login?faces-redirect=true";
    }
}
