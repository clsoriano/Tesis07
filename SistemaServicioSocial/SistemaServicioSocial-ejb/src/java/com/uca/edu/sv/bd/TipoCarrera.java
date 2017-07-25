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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TIPO_CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCarrera.findAll", query = "SELECT t FROM TipoCarrera t")})
public class TipoCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_CARRERA")
    private Integer codTipoCarrera;
    @Size(max = 30)
    @Column(name = "NBR_TIPO_CARRERA")
    private String nbrTipoCarrera;
    @Column(name = "NUM_HORAS_REQUERIDAS")
    private Integer numHorasRequeridas;
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
    @OneToMany(mappedBy = "codTipoCarrera")
    private List<Carrera> carreraList;

    public TipoCarrera() {
    }

    public TipoCarrera(Integer codTipoCarrera) {
        this.codTipoCarrera = codTipoCarrera;
    }

    public TipoCarrera(Integer codTipoCarrera, String modificadoPor, Date fechaModificacion) {
        this.codTipoCarrera = codTipoCarrera;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCodTipoCarrera() {
        return codTipoCarrera;
    }

    public void setCodTipoCarrera(Integer codTipoCarrera) {
        this.codTipoCarrera = codTipoCarrera;
    }

    public String getNbrTipoCarrera() {
        return nbrTipoCarrera;
    }

    public void setNbrTipoCarrera(String nbrTipoCarrera) {
        this.nbrTipoCarrera = nbrTipoCarrera;
    }

    public Integer getNumHorasRequeridas() {
        return numHorasRequeridas;
    }

    public void setNumHorasRequeridas(Integer numHorasRequeridas) {
        this.numHorasRequeridas = numHorasRequeridas;
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

    @XmlTransient
    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoCarrera != null ? codTipoCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCarrera)) {
            return false;
        }
        TipoCarrera other = (TipoCarrera) object;
        if ((this.codTipoCarrera == null && other.codTipoCarrera != null) || (this.codTipoCarrera != null && !this.codTipoCarrera.equals(other.codTipoCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.TipoCarrera[ codTipoCarrera=" + codTipoCarrera + " ]";
    }
    
}
