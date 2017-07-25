/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "EXPEDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expediente.findAll", query = "SELECT e FROM Expediente e")})
public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExpedientePK expedientePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA")
    private BigDecimal nota;
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

    public Expediente() {
    }

    public Expediente(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public Expediente(String carne, String codCiclo, String codMateria, Character matricula) {
        this.expedientePK = new ExpedientePK(carne, codCiclo, codMateria, matricula);
    }

    public ExpedientePK getExpedientePK() {
        return expedientePK;
    }

    public void setExpedientePK(ExpedientePK expedientePK) {
        this.expedientePK = expedientePK;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
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
        hash += (expedientePK != null ? expedientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.expedientePK == null && other.expedientePK != null) || (this.expedientePK != null && !this.expedientePK.equals(other.expedientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Expediente[ expedientePK=" + expedientePK + " ]";
    }
    
}
