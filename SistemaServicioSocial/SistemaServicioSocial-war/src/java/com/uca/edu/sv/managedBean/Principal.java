/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.SsMenuFacade;
import com.uca.edu.sv.ss.SsMenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jcsoriano
 */
@Controller
public class Principal implements Serializable {

    @Inject
    private SsMenuFacade ssMenuFacade;
    private List<Menu> listMenu = new ArrayList<>();
    private String path;

    @PostConstruct
    public void _init() {
        HashMap<String, Object> parametros = new HashMap<>();
        List<SsMenu> opciones = ssMenuFacade.getMenuXUsuario(parametros);
        path = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
        path += ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getServletPath();
        for (SsMenu o : opciones) {
            Menu menu = new Menu(o);
            parametros.put("codMenuPadre", o.getCodMenu());
            menu.setSubMenu(ssMenuFacade.getMenuXCodMenuPadre(parametros));
            listMenu.add(menu);
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

    public void armarMenuSolicitante() {

    }

    public void armarMenuAlumno() {
//        ssMenu = new ArrayList<>();
//        SsMenu m = new SsMenu();
//        SsMenu sm = new SsMenu();
//        //Agregando submenu
//        m = new SsMenu();
//        m.setIdMenu(3L);
//        m.setDescripcion("Inicio");
//        m.setIcon("#");
//        m.setUrl("/SistemaServicioSocial-war/faces/principal.xhtml");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(3L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Instructor");
//        sm.setIcon("fa-user");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/instructor.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Proyectos");
//        sm.setIcon("fa-archive");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/proyectoServicioSocial.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Solicitudes ingresadas");
//        sm.setIcon("fa-list-alt");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listaSolicitud.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(5L);
//        m.setDescripcion("Expediente");
//        m.setIcon("fa-list-alt");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(7L);
//        m.setDescripcion("Acerca de");
//        m.setIcon("fa-paperclip");
//        m.setFuncion("$('.modalArcecade').modal();return false;");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(8L);
//        m.setDescripcion("Salir");
//        m.setIcon("fa-power-off");
//        m.setFuncion("$('.modalPseudoClass').modal();return false;");
//        ssMenu.add(m);
    }

    public void armarMenuAdmin() {
//        ssMenu = new ArrayList<>();
//        SsMenu m = new SsMenu();
//        SsMenu sm = new SsMenu();
//        m.setIdMenu(1L);
//        m.setDescripcion("Dashboard");
//        m.setIcon("fa-tachometer");
//        m.setUrl("/SistemaServicioSocial-war/faces/index.xhtml");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(2L);
//        m.setDescripcion("Reportes");
//        m.setIcon("fa-file");
//        m.setUrl("#");
//        ssMenu.add(m);
//        //Agregando submenu
//        m = new SsMenu();
//        m.setIdMenu(3L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Lista de solicitudes");
//        sm.setIcon("fa-list");
//        sm.setUrl("/SistemaServicioSocial-war/faces/aprobacion/lineaDeAprobacion.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Reporte de proyectos por estado");
//        sm.setIcon("fa-check-square");
//        sm.setUrl("/SistemaServicioSocial-war/faces/aprobacion/aprobacionProyecto.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Instructor");
//        sm.setIcon("fa-user");
//        sm.setUrl("#");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Proyectos");
//        sm.setIcon("fa-archive");
//        sm.setUrl("/SistemaServicioSocial-war/faces/listasMantenimiento/listaProyecto.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Formularios");
//        sm.setIcon("fa fa-window-maximize");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listFormulario.xhtml");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Demo");
//        sm.setIcon("fa-puzzle-piece");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listFormulario.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Mantenimiento
//        m = new SsMenu();
//        m.setIdMenu(3L);
//        m.setDescripcion("Mantenimiento");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Usuario");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Alumnos");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Catalogos");
//        sm.setIcon("fa-list");
//        sm.setUrl("/SistemaServicioSocial-war/faces/listasMantenimiento/listaCatalogo.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Mantenimiento
//        //Herramientas
//        m = new SsMenu();
//        m.setIdMenu(3L);
//        m.setDescripcion("Herramientas");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Menu");
//        sm.setIcon("fa-list");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new SsMenu();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Roles");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Herramientas
//        m = new SsMenu();
//        m.setIdMenu(5L);
//        m.setDescripcion("Expediente");
//        m.setIcon("fa-list-alt");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(6L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("fa-exclamation-circle");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(7L);
//        m.setDescripcion("Acerca de");
//        m.setIcon("fa-paperclip");
//        m.setFuncion("$('.modalArcecade').modal();return false;");
//        ssMenu.add(m);
//        m = new SsMenu();
//        m.setIdMenu(8L);
//        m.setDescripcion("Salir");
//        m.setIcon("fa-power-off");
//        m.setFuncion("$('.modalPseudoClass').modal();return false;");
//        ssMenu.add(m);
    }

}
