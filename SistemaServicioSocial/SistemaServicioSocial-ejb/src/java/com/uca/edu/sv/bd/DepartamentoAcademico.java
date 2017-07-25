/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "DEPARTAMENTO_ACADEMICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentoAcademico.findAll", query = "SELECT d FROM DepartamentoAcademico d")})
public class DepartamentoAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COD_DEPTO_ACADEMICO")
    private String codDeptoAcademico;
    @Size(max = 50)
    @Column(name = "NBR_DEPTO_ACADEMICO")
    private String nbrDeptoAcademico;
    @JoinColumn(name = "COD_JEFE", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codJefe;
    @OneToMany(mappedBy = "codDeptoAcademico")
    private List<Materia> materiaList;

    public DepartamentoAcademico() {
    }

    public DepartamentoAcademico(String codDeptoAcademico) {
        this.codDeptoAcademico = codDeptoAcademico;
    }

    public String getCodDeptoAcademico() {
        return codDeptoAcademico;
    }

    public void setCodDeptoAcademico(String codDeptoAcademico) {
        this.codDeptoAcademico = codDeptoAcademico;
    }

    public String getNbrDeptoAcademico() {
        return nbrDeptoAcademico;
    }

    public void setNbrDeptoAcademico(String nbrDeptoAcademico) {
        this.nbrDeptoAcademico = nbrDeptoAcademico;
    }

    public Empleado getCodJefe() {
        return codJefe;
    }

    public void setCodJefe(Empleado codJefe) {
        this.codJefe = codJefe;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDeptoAcademico != null ? codDeptoAcademico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoAcademico)) {
            return false;
        }
        DepartamentoAcademico other = (DepartamentoAcademico) object;
        if ((this.codDeptoAcademico == null && other.codDeptoAcademico != null) || (this.codDeptoAcademico != null && !this.codDeptoAcademico.equals(other.codDeptoAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.DepartamentoAcademico[ codDeptoAcademico=" + codDeptoAcademico + " ]";
    }
    
}
