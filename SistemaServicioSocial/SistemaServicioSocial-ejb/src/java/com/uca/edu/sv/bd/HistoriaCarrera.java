/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "HISTORIA_CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaCarrera.findAll", query = "SELECT h FROM HistoriaCarrera h")})
public class HistoriaCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoriaCarreraPK historiaCarreraPK;
    @Column(name = "ESTADO_ALUMNO_CARRERA")
    private Character estadoAlumnoCarrera;
    @Size(max = 5)
    @Column(name = "CICLO_EGRESO")
    private String cicloEgreso;
    @Column(name = "FECHA_GRADUACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGraduacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORC_AVANCE")
    private BigDecimal porcAvance;
    @Column(name = "CUM_CARRERA")
    private BigDecimal cumCarrera;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "COD_CICLO_ING", referencedColumnName = "COD_CICLO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciclo ciclo;

    public HistoriaCarrera() {
    }

    public HistoriaCarrera(HistoriaCarreraPK historiaCarreraPK) {
        this.historiaCarreraPK = historiaCarreraPK;
    }

    public HistoriaCarrera(String carne, String codCarrera, String planCarreraIngreso, String codCicloIng) {
        this.historiaCarreraPK = new HistoriaCarreraPK(carne, codCarrera, planCarreraIngreso, codCicloIng);
    }

    public HistoriaCarreraPK getHistoriaCarreraPK() {
        return historiaCarreraPK;
    }

    public void setHistoriaCarreraPK(HistoriaCarreraPK historiaCarreraPK) {
        this.historiaCarreraPK = historiaCarreraPK;
    }

    public Character getEstadoAlumnoCarrera() {
        return estadoAlumnoCarrera;
    }

    public void setEstadoAlumnoCarrera(Character estadoAlumnoCarrera) {
        this.estadoAlumnoCarrera = estadoAlumnoCarrera;
    }

    public String getCicloEgreso() {
        return cicloEgreso;
    }

    public void setCicloEgreso(String cicloEgreso) {
        this.cicloEgreso = cicloEgreso;
    }

    public Date getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(Date fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public BigDecimal getPorcAvance() {
        return porcAvance;
    }

    public void setPorcAvance(BigDecimal porcAvance) {
        this.porcAvance = porcAvance;
    }

    public BigDecimal getCumCarrera() {
        return cumCarrera;
    }

    public void setCumCarrera(BigDecimal cumCarrera) {
        this.cumCarrera = cumCarrera;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historiaCarreraPK != null ? historiaCarreraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaCarrera)) {
            return false;
        }
        HistoriaCarrera other = (HistoriaCarrera) object;
        if ((this.historiaCarreraPK == null && other.historiaCarreraPK != null) || (this.historiaCarreraPK != null && !this.historiaCarreraPK.equals(other.historiaCarreraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HistoriaCarrera[ historiaCarreraPK=" + historiaCarreraPK + " ]";
    }
    
}
