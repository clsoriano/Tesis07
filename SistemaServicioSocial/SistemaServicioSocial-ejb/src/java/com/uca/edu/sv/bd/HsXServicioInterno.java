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
@Table(name = "HS_X_SERVICIO_INTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsXServicioInterno.findAll", query = "SELECT h FROM HsXServicioInterno h")})
public class HsXServicioInterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsXServicioInternoPK hsXServicioInternoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_ASIGNADAS")
    private int horasAsignadas;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ESTADO")
    private Character estado;
    @Lob
    @Column(name = "OBSERVACIONES")
    private String observaciones;
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
    @Column(name = "TIPO")
    private Integer tipo;
    @Size(max = 2)
    @Column(name = "COD_DEPARTAMENTO")
    private String codDepartamento;
    @Size(max = 2)
    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumns({
        @JoinColumn(name = "COD_UNIDAD", referencedColumnName = "COD_UNIDAD", insertable = false, updatable = false)
        , @JoinColumn(name = "CORR_SERVICIO", referencedColumnName = "CORR_SERVICIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ServicioInterno servicioInterno;

    public HsXServicioInterno() {
    }

    public HsXServicioInterno(HsXServicioInternoPK hsXServicioInternoPK) {
        this.hsXServicioInternoPK = hsXServicioInternoPK;
    }

    public HsXServicioInterno(HsXServicioInternoPK hsXServicioInternoPK, int horasAsignadas, String modificadoPor, Date fechaModificacion) {
        this.hsXServicioInternoPK = hsXServicioInternoPK;
        this.horasAsignadas = horasAsignadas;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public HsXServicioInterno(String codUnidad, int corrServicio, String carne) {
        this.hsXServicioInternoPK = new HsXServicioInternoPK(codUnidad, corrServicio, carne);
    }

    public HsXServicioInternoPK getHsXServicioInternoPK() {
        return hsXServicioInternoPK;
    }

    public void setHsXServicioInternoPK(HsXServicioInternoPK hsXServicioInternoPK) {
        this.hsXServicioInternoPK = hsXServicioInternoPK;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ServicioInterno getServicioInterno() {
        return servicioInterno;
    }

    public void setServicioInterno(ServicioInterno servicioInterno) {
        this.servicioInterno = servicioInterno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsXServicioInternoPK != null ? hsXServicioInternoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXServicioInterno)) {
            return false;
        }
        HsXServicioInterno other = (HsXServicioInterno) object;
        if ((this.hsXServicioInternoPK == null && other.hsXServicioInternoPK != null) || (this.hsXServicioInternoPK != null && !this.hsXServicioInternoPK.equals(other.hsXServicioInternoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXServicioInterno[ hsXServicioInternoPK=" + hsXServicioInternoPK + " ]";
    }
    
}
