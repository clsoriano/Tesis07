/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import java.io.Serializable;

/**
 *
 * @author jcsoriano
 */
@Controller
public class ConsultaLineaDeAprobacion implements Serializable {

    public ConsultaLineaDeAprobacion() {

    }

    public String crearLineaDeAprobacion() {
        return "nuevaLineaDeAprobacion?faces-redirect=true";
    }

    public String cancelarLineaDeAprobacion() {
        return "lineaDeAprobacion?faces-redirect=true";
    }

    public String rechazarLineaDeAprobacion() {
        return "lineaDeAprobacion?faces-redirect=true";
    }
}
