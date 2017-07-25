/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SEMESTRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SemestrePK semestrePK;
    @Size(max = 2)
    @Column(name = "SECCION")
    private String seccion;
    @Column(name = "MATRICULA")
    private Character matricula;
    @Size(max = 2)
    @Column(name = "ESTADO_MATERIA")
    private String estadoMateria;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "COD_CICLO", referencedColumnName = "COD_CICLO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciclo ciclo;
    @JoinColumn(name = "COD_MATERIA", referencedColumnName = "COD_MATERIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Semestre() {
    }

    public Semestre(SemestrePK semestrePK) {
        this.semestrePK = semestrePK;
    }

    public Semestre(String carne, String codCiclo, String codMateria) {
        this.semestrePK = new SemestrePK(carne, codCiclo, codMateria);
    }

    public SemestrePK getSemestrePK() {
        return semestrePK;
    }

    public void setSemestrePK(SemestrePK semestrePK) {
        this.semestrePK = semestrePK;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Character getMatricula() {
        return matricula;
    }

    public void setMatricula(Character matricula) {
        this.matricula = matricula;
    }

    public String getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (semestrePK != null ? semestrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.semestrePK == null && other.semestrePK != null) || (this.semestrePK != null && !this.semestrePK.equals(other.semestrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Semestre[ semestrePK=" + semestrePK + " ]";
    }
    
}
