/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "HS_X_EQUIVALENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsXEquivalencia.findAll", query = "SELECT h FROM HsXEquivalencia h")})
public class HsXEquivalencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsXEquivalenciaPK hsXEquivalenciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_ASIGNADAS")
    private int horasAsignadas;
    @Column(name = "FECHA_RECEPCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdicion;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Institucion institucion;

    public HsXEquivalencia() {
    }

    public HsXEquivalencia(HsXEquivalenciaPK hsXEquivalenciaPK) {
        this.hsXEquivalenciaPK = hsXEquivalenciaPK;
    }

    public HsXEquivalencia(HsXEquivalenciaPK hsXEquivalenciaPK, int horasAsignadas, String modificadoPor, Date fechaAdicion) {
        this.hsXEquivalenciaPK = hsXEquivalenciaPK;
        this.horasAsignadas = horasAsignadas;
        this.modificadoPor = modificadoPor;
        this.fechaAdicion = fechaAdicion;
    }

    public HsXEquivalencia(int codInstitucion, String carne) {
        this.hsXEquivalenciaPK = new HsXEquivalenciaPK(codInstitucion, carne);
    }

    public HsXEquivalenciaPK getHsXEquivalenciaPK() {
        return hsXEquivalenciaPK;
    }

    public void setHsXEquivalenciaPK(HsXEquivalenciaPK hsXEquivalenciaPK) {
        this.hsXEquivalenciaPK = hsXEquivalenciaPK;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsXEquivalenciaPK != null ? hsXEquivalenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXEquivalencia)) {
            return false;
        }
        HsXEquivalencia other = (HsXEquivalencia) object;
        if ((this.hsXEquivalenciaPK == null && other.hsXEquivalenciaPK != null) || (this.hsXEquivalenciaPK != null && !this.hsXEquivalenciaPK.equals(other.hsXEquivalenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXEquivalencia[ hsXEquivalenciaPK=" + hsXEquivalenciaPK + " ]";
    }
    
}
