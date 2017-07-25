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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "UNIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_UNIDAD")
    private String codUnidad;
    @Size(max = 100)
    @Column(name = "NBR_UNIDAD")
    private String nbrUnidad;
    @Size(max = 8)
    @Column(name = "EXTENSION")
    private String extension;
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
    @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA")
    @ManyToOne
    private Area codArea;
    @JoinColumn(name = "COD_RESPONSABLE", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidad")
    private List<ServicioInterno> servicioInternoList;

    public Unidad() {
    }

    public Unidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public Unidad(String codUnidad, String modificadoPor, Date fechaModificacion) {
        this.codUnidad = codUnidad;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public String getNbrUnidad() {
        return nbrUnidad;
    }

    public void setNbrUnidad(String nbrUnidad) {
        this.nbrUnidad = nbrUnidad;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    public Area getCodArea() {
        return codArea;
    }

    public void setCodArea(Area codArea) {
        this.codArea = codArea;
    }

    public Empleado getCodResponsable() {
        return codResponsable;
    }

    public void setCodResponsable(Empleado codResponsable) {
        this.codResponsable = codResponsable;
    }

    @XmlTransient
    public List<ServicioInterno> getServicioInternoList() {
        return servicioInternoList;
    }

    public void setServicioInternoList(List<ServicioInterno> servicioInternoList) {
        this.servicioInternoList = servicioInternoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUnidad != null ? codUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.codUnidad == null && other.codUnidad != null) || (this.codUnidad != null && !this.codUnidad.equals(other.codUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Unidad[ codUnidad=" + codUnidad + " ]";
    }
    
}
