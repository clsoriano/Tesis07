/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipioPK municipioPK;
    @Size(max = 50)
    @Column(name = "NBR_MUNICIPIO")
    private String nbrMunicipio;
    @OneToMany(mappedBy = "municipio")
    private List<Alumno> alumnoList;
    @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;
    @OneToMany(mappedBy = "municipio")
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "municipio")
    private List<Institucion> institucionList;

    public Municipio() {
    }

    public Municipio(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public Municipio(String codDepartamento, String codMunicipio) {
        this.municipioPK = new MunicipioPK(codDepartamento, codMunicipio);
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public String getNbrMunicipio() {
        return nbrMunicipio;
    }

    public void setNbrMunicipio(String nbrMunicipio) {
        this.nbrMunicipio = nbrMunicipio;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioPK != null ? municipioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioPK == null && other.municipioPK != null) || (this.municipioPK != null && !this.municipioPK.equals(other.municipioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Municipio[ municipioPK=" + municipioPK + " ]";
    }
    
}
