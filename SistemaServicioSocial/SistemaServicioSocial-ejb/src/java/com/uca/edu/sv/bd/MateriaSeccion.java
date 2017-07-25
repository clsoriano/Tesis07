/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "MATERIA_SECCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaSeccion.findAll", query = "SELECT m FROM MateriaSeccion m")})
public class MateriaSeccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaSeccionPK materiaSeccionPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaSeccion")
    private List<HsXInstructoria> hsXInstructoriaList;
    @JoinColumn(name = "COD_CICLO", referencedColumnName = "COD_CICLO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciclo ciclo;
    @JoinColumn(name = "COD_PROFESOR", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codProfesor;
    @JoinColumn(name = "COD_MATERIA", referencedColumnName = "COD_MATERIA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public MateriaSeccion() {
    }

    public MateriaSeccion(MateriaSeccionPK materiaSeccionPK) {
        this.materiaSeccionPK = materiaSeccionPK;
    }

    public MateriaSeccion(String codMateria, String codCiclo, String seccion) {
        this.materiaSeccionPK = new MateriaSeccionPK(codMateria, codCiclo, seccion);
    }

    public MateriaSeccionPK getMateriaSeccionPK() {
        return materiaSeccionPK;
    }

    public void setMateriaSeccionPK(MateriaSeccionPK materiaSeccionPK) {
        this.materiaSeccionPK = materiaSeccionPK;
    }

    @XmlTransient
    public List<HsXInstructoria> getHsXInstructoriaList() {
        return hsXInstructoriaList;
    }

    public void setHsXInstructoriaList(List<HsXInstructoria> hsXInstructoriaList) {
        this.hsXInstructoriaList = hsXInstructoriaList;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Empleado getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(Empleado codProfesor) {
        this.codProfesor = codProfesor;
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
        hash += (materiaSeccionPK != null ? materiaSeccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaSeccion)) {
            return false;
        }
        MateriaSeccion other = (MateriaSeccion) object;
        if ((this.materiaSeccionPK == null && other.materiaSeccionPK != null) || (this.materiaSeccionPK != null && !this.materiaSeccionPK.equals(other.materiaSeccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.MateriaSeccion[ materiaSeccionPK=" + materiaSeccionPK + " ]";
    }
    
}
