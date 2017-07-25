/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SEGUIMIENTO_ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoAlumno.findAll", query = "SELECT s FROM SeguimientoAlumno s")})
public class SeguimientoAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientoAlumnoPK seguimientoAlumnoPK;
    @Column(name = "COD_TIPO_SEGUIMIENTO")
    private Integer codTipoSeguimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AVANCE")
    private BigDecimal avance;
    @Size(max = 80)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTREGA_PLAN")
    private boolean entregaPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUNTUALIDAD")
    private BigDecimal puntualidad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "METAS_PROPUESTAS")
    private String metasPropuestas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "METAS_CUMPLIDAS")
    private String metasCumplidas;
    @Basic(optional = false)
    @NotNull
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
        , @JoinColumn(name = "CORR_PROYECTO", referencedColumnName = "CORR_PROYECTO", insertable = false, updatable = false)
        , @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private HsXProyecto hsXProyecto;

    public SeguimientoAlumno() {
    }

    public SeguimientoAlumno(SeguimientoAlumnoPK seguimientoAlumnoPK) {
        this.seguimientoAlumnoPK = seguimientoAlumnoPK;
    }

    public SeguimientoAlumno(SeguimientoAlumnoPK seguimientoAlumnoPK, boolean entregaPlan, BigDecimal puntualidad, String metasPropuestas, String metasCumplidas, String observaciones) {
        this.seguimientoAlumnoPK = seguimientoAlumnoPK;
        this.entregaPlan = entregaPlan;
        this.puntualidad = puntualidad;
        this.metasPropuestas = metasPropuestas;
        this.metasCumplidas = metasCumplidas;
        this.observaciones = observaciones;
    }

    public SeguimientoAlumno(int codInstitucion, int corrProyecto, String carne, int corrSeguimiento) {
        this.seguimientoAlumnoPK = new SeguimientoAlumnoPK(codInstitucion, corrProyecto, carne, corrSeguimiento);
    }

    public SeguimientoAlumnoPK getSeguimientoAlumnoPK() {
        return seguimientoAlumnoPK;
    }

    public void setSeguimientoAlumnoPK(SeguimientoAlumnoPK seguimientoAlumnoPK) {
        this.seguimientoAlumnoPK = seguimientoAlumnoPK;
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

    public boolean getEntregaPlan() {
        return entregaPlan;
    }

    public void setEntregaPlan(boolean entregaPlan) {
        this.entregaPlan = entregaPlan;
    }

    public BigDecimal getPuntualidad() {
        return puntualidad;
    }

    public void setPuntualidad(BigDecimal puntualidad) {
        this.puntualidad = puntualidad;
    }

    public String getMetasPropuestas() {
        return metasPropuestas;
    }

    public void setMetasPropuestas(String metasPropuestas) {
        this.metasPropuestas = metasPropuestas;
    }

    public String getMetasCumplidas() {
        return metasCumplidas;
    }

    public void setMetasCumplidas(String metasCumplidas) {
        this.metasCumplidas = metasCumplidas;
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

    public HsXProyecto getHsXProyecto() {
        return hsXProyecto;
    }

    public void setHsXProyecto(HsXProyecto hsXProyecto) {
        this.hsXProyecto = hsXProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientoAlumnoPK != null ? seguimientoAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoAlumno)) {
            return false;
        }
        SeguimientoAlumno other = (SeguimientoAlumno) object;
        if ((this.seguimientoAlumnoPK == null && other.seguimientoAlumnoPK != null) || (this.seguimientoAlumnoPK != null && !this.seguimientoAlumnoPK.equals(other.seguimientoAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.SeguimientoAlumno[ seguimientoAlumnoPK=" + seguimientoAlumnoPK + " ]";
    }
    
}
