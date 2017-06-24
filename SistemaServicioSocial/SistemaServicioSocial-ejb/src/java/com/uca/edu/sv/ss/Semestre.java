/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SEMESTRE", schema = "SS")
public class Semestre implements Serializable {

    @Id
    @Column(name = "CARNE")
    private String carne;
    @Column(name = "COD_CICLO")
    private String codCiclo;
    @Column(name = "COD_MATERIA")
    private String codMateria;
    @Column(name = "SECCION")
    private String seccion;
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "ESTADO_MATERIA")
    private String estadoMateria;

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

}
