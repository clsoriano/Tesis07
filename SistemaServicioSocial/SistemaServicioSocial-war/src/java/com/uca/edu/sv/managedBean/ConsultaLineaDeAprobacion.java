/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author jcsoriano
 */
@Named
@ViewScoped
public class ConsultaLineaDeAprobacion implements Serializable {

    public ConsultaLineaDeAprobacion(){
        
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
