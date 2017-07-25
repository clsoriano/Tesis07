/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.SsMenuFacade;
import com.uca.edu.sv.process.Constantes;
import com.uca.edu.sv.ss.SsMenu;
import com.uca.edu.sv.util.UsuarioLogueado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jcsoriano
 */
@Controller
public class Principal implements Serializable {

    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

    @Inject
    private SsMenuFacade ssMenuFacade;
    private List<Menu> listMenu = new ArrayList<>();
    private String path;
    private UsuarioLogueado usuarioLogueado;

    @PostConstruct
    public void _init() {
        try {
            HashMap<String, Object> parametros = new HashMap<>();
            usuarioLogueado = (UsuarioLogueado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Constantes.USER_LOG);
            parametros.put("codPerfil", usuarioLogueado.getCodPerfil());
            List<SsMenu> opciones = ssMenuFacade.getMenuXUsuario(parametros);
            path = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
            path += ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServletPath();
            for (SsMenu o : opciones) {
                Menu menu = new Menu(o);
                parametros.put("codMenuPadre", o.getCodMenu());
                menu.setSubMenu(ssMenuFacade.getMenuXCodMenuPadre(parametros));
                listMenu.add(menu);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error obteniendo el usuario logueado.", ex);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaServicioSocial-war/info/login.xhtml");
                addMessage("growlSpecific", FacesMessage.SEVERITY_ERROR, "Sesion", "No pudo encontrarse el usuario como logueado en el sistema. Favor inciar sesion nuevamente.");
            } catch (Exception exp) {
                LOG.log(Level.SEVERE, "No se presento el usuario logueado", exp);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Menu> getMenu() {
        return listMenu;
    }

    public UsuarioLogueado getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(UsuarioLogueado usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public void addMessage(String clientId, FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity, summary, detail));
    }
}
