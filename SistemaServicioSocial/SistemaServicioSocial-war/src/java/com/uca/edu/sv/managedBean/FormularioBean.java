/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.SsCampoFormularioFacade;
import com.uca.edu.sv.facade.SsFormularioFacade;
import com.uca.edu.sv.ss.SsCampoFormulario;
import com.uca.edu.sv.ss.SsFormulario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class FormularioBean implements Serializable {

    @Inject
    private SsFormularioFacade ssFormularioFacade;
    @Inject
    private SsCampoFormularioFacade ssCampoFormularioFacade;
    private SsFormulario ssFormulario;
    private SsCampoFormulario ssCampoFormulario;

    public void formulario() {
        this.ssFormulario = new SsFormulario();
    }

    public void campoFormulario() {
        this.ssCampoFormulario = new SsCampoFormulario();
    }

    public SsCampoFormulario getSsCampoFormulario() {
        return this.ssCampoFormulario;
    }

    public SsFormulario getSsFormulario() {
        return this.ssFormulario;
    }

    public List<SsFormulario> getListSsFormulario() {
        List<SsFormulario> listSsFormulario = null;
        try {
            listSsFormulario = ssFormularioFacade.findAll();
        } catch (Exception ex) {

        }
        return listSsFormulario;
    }

    public List<SsFormulario> getListSsCampoFormulario() {
        List<SsFormulario> listSsFormulario = null;
        try {
            listSsFormulario = ssFormularioFacade.findAll();
        } catch (Exception ex) {

        }
        return listSsFormulario;
    }

    public String saveSsFormulario() {
        ssFormularioFacade.create(this.ssFormulario);
        return "listFormulario?faces-redirect=true";
    }

    public String saveSsCampoFormulario() {
        ssCampoFormularioFacade.create(this.ssCampoFormulario);
        return "listFormulario?faces-redirect=true";
    }
}
