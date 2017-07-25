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
@Table(name = "CONSTANCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constancia.findAll", query = "SELECT c FROM Constancia c")})
public class Constancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConstanciaPK constanciaPK;
    @Column(name = "NUM_SOLICITUD")
    private Integer numSolicitud;
    @Column(name = "NUM_RECIBO")
    private Integer numRecibo;
    @Column(name = "TIPO_CONSTANCIA")
    private Character tipoConstancia;
    @Column(name = "FECHA_IMPRESION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaImpresion;
    @Column(name = "NUM_IMPRESIONES")
    private Integer numImpresiones;
    @Size(max = 80)
    @Column(name = "DIRIGIDA_A")
    private String dirigidaA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Constancia() {
    }

    public Constancia(ConstanciaPK constanciaPK) {
        this.constanciaPK = constanciaPK;
    }

    public Constancia(ConstanciaPK constanciaPK, String modificadoPor, Date fechaModificacion) {
        this.constanciaPK = constanciaPK;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Constancia(String carne, int corrConstancia) {
        this.constanciaPK = new ConstanciaPK(carne, corrConstancia);
    }

    public ConstanciaPK getConstanciaPK() {
        return constanciaPK;
    }

    public void setConstanciaPK(ConstanciaPK constanciaPK) {
        this.constanciaPK = constanciaPK;
    }

    public Integer getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(Integer numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public Integer getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(Integer numRecibo) {
        this.numRecibo = numRecibo;
    }

    public Character getTipoConstancia() {
        return tipoConstancia;
    }

    public void setTipoConstancia(Character tipoConstancia) {
        this.tipoConstancia = tipoConstancia;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public Integer getNumImpresiones() {
        return numImpresiones;
    }

    public void setNumImpresiones(Integer numImpresiones) {
        this.numImpresiones = numImpresiones;
    }

    public String getDirigidaA() {
        return dirigidaA;
    }

    public void setDirigidaA(String dirigidaA) {
        this.dirigidaA = dirigidaA;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constanciaPK != null ? constanciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constancia)) {
            return false;
        }
        Constancia other = (Constancia) object;
        if ((this.constanciaPK == null && other.constanciaPK != null) || (this.constanciaPK != null && !this.constanciaPK.equals(other.constanciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Constancia[ constanciaPK=" + constanciaPK + " ]";
    }
    
}
