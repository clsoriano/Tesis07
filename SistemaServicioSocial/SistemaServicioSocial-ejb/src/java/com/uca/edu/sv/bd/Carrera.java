/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_CARRERA")
    private String codCarrera;
    @Size(max = 50)
    @Column(name = "NBR_CARRERA")
    private String nbrCarrera;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR")
    private String codCoordinador;
    @JoinColumn(name = "COD_FACULTAD", referencedColumnName = "COD_FACULTAD")
    @ManyToOne
    private Facultad codFacultad;
    @JoinColumn(name = "COD_TIPO_CARRERA", referencedColumnName = "COD_TIPO_CARRERA")
    @ManyToOne
    private TipoCarrera codTipoCarrera;
    @OneToMany(mappedBy = "codCarrera")
    private List<Alumno> alumnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrera")
    private List<PlanCarrera> planCarreraList;

    public Carrera() {
    }

    public Carrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNbrCarrera() {
        return nbrCarrera;
    }

    public void setNbrCarrera(String nbrCarrera) {
        this.nbrCarrera = nbrCarrera;
    }

    public String getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(String codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

    public Facultad getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Facultad codFacultad) {
        this.codFacultad = codFacultad;
    }

    public TipoCarrera getCodTipoCarrera() {
        return codTipoCarrera;
    }

    public void setCodTipoCarrera(TipoCarrera codTipoCarrera) {
        this.codTipoCarrera = codTipoCarrera;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @XmlTransient
    public List<PlanCarrera> getPlanCarreraList() {
        return planCarreraList;
    }

    public void setPlanCarreraList(List<PlanCarrera> planCarreraList) {
        this.planCarreraList = planCarreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarrera != null ? codCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codCarrera == null && other.codCarrera != null) || (this.codCarrera != null && !this.codCarrera.equals(other.codCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Carrera[ codCarrera=" + codCarrera + " ]";
    }
    
}
