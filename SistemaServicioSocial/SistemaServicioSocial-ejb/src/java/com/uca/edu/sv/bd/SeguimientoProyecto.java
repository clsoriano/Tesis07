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
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
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
@Table(name = "SEGUIMIENTO_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoProyecto.findAll", query = "SELECT s FROM SeguimientoProyecto s")})
public class SeguimientoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientoProyectoPK seguimientoProyectoPK;
    @Column(name = "COD_TIPO_SEGUIMIENTO")
    private Integer codTipoSeguimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AVANCE")
    private BigDecimal avance;
    @Size(max = 80)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Lob
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Size(max = 8)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumns({
        @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
        , @JoinColumn(name = "CORR_PROYECTO", referencedColumnName = "CORR_PROYECTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public SeguimientoProyecto() {
    }

    public SeguimientoProyecto(SeguimientoProyectoPK seguimientoProyectoPK) {
        this.seguimientoProyectoPK = seguimientoProyectoPK;
    }

    public SeguimientoProyecto(int codInstitucion, int corrProyecto, int corrSeguimiento) {
        this.seguimientoProyectoPK = new SeguimientoProyectoPK(codInstitucion, corrProyecto, corrSeguimiento);
    }

    public SeguimientoProyectoPK getSeguimientoProyectoPK() {
        return seguimientoProyectoPK;
    }

    public void setSeguimientoProyectoPK(SeguimientoProyectoPK seguimientoProyectoPK) {
        this.seguimientoProyectoPK = seguimientoProyectoPK;
    }

    public Integer getCodTipoSeguimiento() {
        return codTipoSeguimiento;
    }

    public void setCodTipoSeguimiento(Integer codTipoSeguimiento) {
        this.codTipoSeguimiento = codTipoSeguimiento;
    }

    public BigDecimal getAvance() {
        return avance;
    }

    public void setAvance(BigDecimal avance) {
        this.avance = avance;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientoProyectoPK != null ? seguimientoProyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoProyecto)) {
            return false;
        }
        SeguimientoProyecto other = (SeguimientoProyecto) object;
        if ((this.seguimientoProyectoPK == null && other.seguimientoProyectoPK != null) || (this.seguimientoProyectoPK != null && !this.seguimientoProyectoPK.equals(other.seguimientoProyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.SeguimientoProyecto[ seguimientoProyectoPK=" + seguimientoProyectoPK + " ]";
    }
    
}
