/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author jcsoriano
 */
@ManagedBean(name = "proyecto")
@RequestScoped
public class Proyecto implements Serializable{
    
    private String institucion;
    private String actividad;
    private String perfil;
    private String inicio;
    private String horario;
    private String responsable;
    private String estado;

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    public List<Proyecto> getListProyecto(){
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        Proyecto p = new Proyecto();
        p.setInstitucion("Rectoria");
        p.setActividad("Actividades de proyecto social");
        p.setPerfil("3 Estudiantes de comunicaciones con experiencia en manejo de redes sociales.");
        p.setInicio("Lo antes posible");
        p.setHorario("2 horas diarias");
        p.setResponsable("Elsy Mavel Rivera erivera@uca.edu.sv Ext. 621");
        p.setEstado("A");
        proyectos.add(p);
        p = new Proyecto();
        p.setInstitucion("Departamento de organizacion del espacio");
        p.setActividad("Apoyo en entrevistas, toma de videos y edicion");
        p.setPerfil("2 Estudiantes de comunicaciones que puedan realizar entrevistas.");
        p.setInicio("Lo antes posible");
        p.setHorario("6 horas a la semana");
        p.setResponsable("Elsy Mavel Rivera erivera@uca.edu.sv Ext. 621");
        p.setEstado("I");
        proyectos.add(p);
        return proyectos;
    }
}
