/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.Alumno;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.AlumnoFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class AlumnoController implements Serializable {

    private static final Logger LOG = Logger.getLogger(AlumnoController.class.getName());

    @Inject
    private AlumnoFacade alumnoFacade;
    private Alumno alumno;
    private List<Alumno> alumnoList;
    private boolean isEditAlumno;

    @PostConstruct
    public void _init() {
        alumno = new Alumno();
        alumnoList = alumnoFacade.findAll();
    }

    public void setSelectedUsuario(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public boolean isIsEditAlumno() {
        return isEditAlumno;
    }

    public void setIsEditAlumno(boolean isEditAlumno) {
        this.isEditAlumno = isEditAlumno;
    }

}
