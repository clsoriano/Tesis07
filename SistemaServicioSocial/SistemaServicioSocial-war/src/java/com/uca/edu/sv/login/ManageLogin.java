/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.login;

import com.uca.edu.sv.controller.Controller;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jcsoriano
 */
@Controller
public class ManageLogin implements Serializable {

    private String user;
    private String password;
    private String message;

    public ManageLogin() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String validateUser() {
        if ((getUser().equals("admin") || getUser().equals("clsoriano") || getUser().equals("inst1234")) && getPassword().equals("1234")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", getUser());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(getUser(), getUser());
            if (getUser().equals("admin")) {
                return "index?faces-redirect=true";
            } else {
                return "principal?faces-redirect=true";
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingreso", "Usuario o contraseña incorrectas");
            context.addMessage(null, facesMessage);
        }
        return null;
    }

    public String logout() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        return "/login?faces-redirect=true";
    }

    public String registrate() throws Exception {
        return "/registro/registrarInstitucion?faces-redirect=true";
    }

}
