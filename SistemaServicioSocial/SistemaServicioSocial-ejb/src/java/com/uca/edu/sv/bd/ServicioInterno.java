/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SERVICIO_INTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioInterno.findAll", query = "SELECT s FROM ServicioInterno s")})
public class ServicioInterno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicioInternoPK servicioInternoPK;
    @Size(max = 100)
    @Column(name = "NBR_SERVICIO")
    private String nbrServicio;
    @Size(max = 80)
    @Column(name = "NBR_RESPONSABLE")
    private String nbrResponsable;
    @Column(name = "NUM_ALUMNOS_SOLICITADOS")
    private Integer numAlumnosSolicitados;
    @Column(name = "ESTADO")
    private Character estado;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
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
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUBLICAR")
    private boolean publicar;
    @Size(max = 50)
    @Column(name = "CONTACTO")
    private String contacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioInterno")
    private List<HsXServicioInterno> hsXServicioInternoList;
    @JoinColumn(name = "COD_UNIDAD", referencedColumnName = "COD_UNIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Unidad unidad;

    public ServicioInterno() {
    }

    public ServicioInterno(ServicioInternoPK servicioInternoPK) {
        this.servicioInternoPK = servicioInternoPK;
    }

    public ServicioInterno(ServicioInternoPK servicioInternoPK, String modificadoPor, Date fechaModificacion, boolean publicar) {
        this.servicioInternoPK = servicioInternoPK;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.publicar = publicar;
    }

    public ServicioInterno(String codUnidad, int corrServicio) {
        this.servicioInternoPK = new ServicioInternoPK(codUnidad, corrServicio);
    }

    public ServicioInternoPK getServicioInternoPK() {
        return servicioInternoPK;
    }

    public void setServicioInternoPK(ServicioInternoPK servicioInternoPK) {
        this.servicioInternoPK = servicioInternoPK;
    }

    public String getNbrServicio() {
        return nbrServicio;
    }

    public void setNbrServicio(String nbrServicio) {
        this.nbrServicio = nbrServicio;
    }

    public String getNbrResponsable() {
        return nbrResponsable;
    }

    public void setNbrResponsable(String nbrResponsable) {
        this.nbrResponsable = nbrResponsable;
    }

    public Integer getNumAlumnosSolicitados() {
        return numAlumnosSolicitados;
    }

    public void setNumAlumnosSolicitados(Integer numAlumnosSolicitados) {
        this.numAlumnosSolicitados = numAlumnosSolicitados;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicar) {
        this.publicar = publicar;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @XmlTransient
    public List<HsXServicioInterno> getHsXServicioInternoList() {
        return hsXServicioInternoList;
    }

    public void setHsXServicioInternoList(List<HsXServicioInterno> hsXServicioInternoList) {
        this.hsXServicioInternoList = hsXServicioInternoList;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioInternoPK != null ? servicioInternoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioInterno)) {
            return false;
        }
        ServicioInterno other = (ServicioInterno) object;
        if ((this.servicioInternoPK == null && other.servicioInternoPK != null) || (this.servicioInternoPK != null && !this.servicioInternoPK.equals(other.servicioInternoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.ServicioInterno[ servicioInternoPK=" + servicioInternoPK + " ]";
    }
    
}
