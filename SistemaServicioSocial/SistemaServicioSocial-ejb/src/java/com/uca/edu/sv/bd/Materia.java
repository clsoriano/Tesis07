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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "MATERIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_MATERIA")
    private String codMateria;
    @Size(max = 50)
    @Column(name = "NBR_MATERIA")
    private String nbrMateria;
    @Column(name = "UV")
    private Long uv;
    @JoinTable(name = "MATERIA_X_USUARIO", joinColumns = {
        @JoinColumn(name = "COD_MATERIA", referencedColumnName = "COD_MATERIA")}, inverseJoinColumns = {
        @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Semestre> semestreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<Expediente> expedienteList;
    @JoinColumn(name = "COD_DEPTO_ACADEMICO", referencedColumnName = "COD_DEPTO_ACADEMICO")
    @ManyToOne
    private DepartamentoAcademico codDeptoAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private List<MateriaSeccion> materiaSeccionList;

    public Materia() {
    }

    public Materia(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getNbrMateria() {
        return nbrMateria;
    }

    public void setNbrMateria(String nbrMateria) {
        this.nbrMateria = nbrMateria;
    }

    public Long getUv() {
        return uv;
    }

    public void setUv(Long uv) {
        this.uv = uv;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Semestre> getSemestreList() {
        return semestreList;
    }

    public void setSemestreList(List<Semestre> semestreList) {
        this.semestreList = semestreList;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    public DepartamentoAcademico getCodDeptoAcademico() {
        return codDeptoAcademico;
    }

    public void setCodDeptoAcademico(DepartamentoAcademico codDeptoAcademico) {
        this.codDeptoAcademico = codDeptoAcademico;
    }

    @XmlTransient
    public List<MateriaSeccion> getMateriaSeccionList() {
        return materiaSeccionList;
    }

    public void setMateriaSeccionList(List<MateriaSeccion> materiaSeccionList) {
        this.materiaSeccionList = materiaSeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Materia[ codMateria=" + codMateria + " ]";
    }
    
}
