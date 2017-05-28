/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.ss.Opcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jcsoriano
 */
@Named
@ViewScoped
public class Principal implements Serializable {

    private List<Opcion> ssMenu;
    private List<Opcion> subMenu;

    public Principal() {
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (user.equals("admin")) {
            armarMenuAdmin();
        } else if (user.equals("clsoriano")) {
            armarMenuAlumno();
        } else if (user.equals("inst1234")) {
            armarMenuSolicitante();
        }

    }

    public void armarMenuSolicitante() {
        
    }

    public void armarMenuAlumno() {
//        ssMenu = new ArrayList<>();
//        Opcion m = new Opcion();
//        Opcion sm = new Opcion();
//        //Agregando submenu
//        m = new Opcion();
//        m.setIdMenu(3L);
//        m.setDescripcion("Inicio");
//        m.setIcon("#");
//        m.setUrl("/SistemaServicioSocial-war/faces/principal.xhtml");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(3L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Instructor");
//        sm.setIcon("fa-user");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/instructor.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Proyectos");
//        sm.setIcon("fa-archive");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/proyectoServicioSocial.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Solicitudes ingresadas");
//        sm.setIcon("fa-list-alt");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listaSolicitud.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(5L);
//        m.setDescripcion("Expediente");
//        m.setIcon("fa-list-alt");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(7L);
//        m.setDescripcion("Acerca de");
//        m.setIcon("fa-paperclip");
//        m.setFuncion("$('.modalArcecade').modal();return false;");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(8L);
//        m.setDescripcion("Salir");
//        m.setIcon("fa-power-off");
//        m.setFuncion("$('.modalPseudoClass').modal();return false;");
//        ssMenu.add(m);
    }

    public void armarMenuAdmin() {
//        ssMenu = new ArrayList<>();
//        Opcion m = new Opcion();
//        Opcion sm = new Opcion();
//        m.setIdMenu(1L);
//        m.setDescripcion("Dashboard");
//        m.setIcon("fa-tachometer");
//        m.setUrl("/SistemaServicioSocial-war/faces/index.xhtml");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(2L);
//        m.setDescripcion("Reportes");
//        m.setIcon("fa-file");
//        m.setUrl("#");
//        ssMenu.add(m);
//        //Agregando submenu
//        m = new Opcion();
//        m.setIdMenu(3L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Lista de solicitudes");
//        sm.setIcon("fa-list");
//        sm.setUrl("/SistemaServicioSocial-war/faces/aprobacion/lineaDeAprobacion.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Reporte de proyectos por estado");
//        sm.setIcon("fa-check-square");
//        sm.setUrl("/SistemaServicioSocial-war/faces/aprobacion/aprobacionProyecto.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Instructor");
//        sm.setIcon("fa-user");
//        sm.setUrl("#");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Proyectos");
//        sm.setIcon("fa-archive");
//        sm.setUrl("/SistemaServicioSocial-war/faces/listasMantenimiento/listaProyecto.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Formularios");
//        sm.setIcon("fa fa-window-maximize");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listFormulario.xhtml");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Demo");
//        sm.setIcon("fa-puzzle-piece");
//        sm.setUrl("/SistemaServicioSocial-war/faces/solicitud/listFormulario.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Mantenimiento
//        m = new Opcion();
//        m.setIdMenu(3L);
//        m.setDescripcion("Mantenimiento");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Usuario");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Alumnos");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Catalogos");
//        sm.setIcon("fa-list");
//        sm.setUrl("/SistemaServicioSocial-war/faces/listasMantenimiento/listaCatalogo.xhtml");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Mantenimiento
//        //Herramientas
//        m = new Opcion();
//        m.setIdMenu(3L);
//        m.setDescripcion("Herramientas");
//        m.setIcon("#");
//        m.setUrl("#");
//        subMenu = new ArrayList<>();
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Menu");
//        sm.setIcon("fa-list");
//        sm.setUrl("");
//        subMenu.add(sm);
//        sm = new Opcion();
//        sm.setIdMenu(4L);
//        sm.setDescripcion("Roles");
//        sm.setIcon("fa-user");
//        sm.setUrl("");
//        subMenu.add(sm);
//        m.setSubMenu(subMenu);
//        ssMenu.add(m);
//        //Herramientas
//        m = new Opcion();
//        m.setIdMenu(5L);
//        m.setDescripcion("Expediente");
//        m.setIcon("fa-list-alt");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(6L);
//        m.setDescripcion("Solicitudes");
//        m.setIcon("fa-exclamation-circle");
//        m.setUrl("#");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(7L);
//        m.setDescripcion("Acerca de");
//        m.setIcon("fa-paperclip");
//        m.setFuncion("$('.modalArcecade').modal();return false;");
//        ssMenu.add(m);
//        m = new Opcion();
//        m.setIdMenu(8L);
//        m.setDescripcion("Salir");
//        m.setIcon("fa-power-off");
//        m.setFuncion("$('.modalPseudoClass').modal();return false;");
//        ssMenu.add(m);
    }

    public List<Opcion> getSsMenu() {
        return ssMenu;
    }
}
