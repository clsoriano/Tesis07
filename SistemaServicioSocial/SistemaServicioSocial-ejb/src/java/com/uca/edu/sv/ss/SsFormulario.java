/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "SS_FORMULARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsFormulario.findAll", query = "SELECT s FROM SsFormulario s")})
public class SsFormulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(sequenceName = "SEQ_SS_FORMULARIO", name = "SEQ_SS_FORMULARIO", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SS_FORMULARIO")
    @Column(name = "COD_FORMULARIO")
    private Long codFormulario;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "COD_INSTITUCION")
    private Long codInstitucion;
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 100)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.DATE)
    private Date fechaAdicion;
    @Size(max = 100)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "codFormulario")
    private List<SsCampoFormulario> ssCampoFormularioList;

    public SsFormulario() {
    }

    public SsFormulario(Long codFormulario) {
        this.codFormulario = codFormulario;
    }

    public Long getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(Long codFormulario) {
        this.codFormulario = codFormulario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(Long codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdicionadoPor() {
        return adicionadoPor;
    }

    public void setAdicionadoPor(String adicionadoPor) {
        this.adicionadoPor = adicionadoPor;
    }

    public Date getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(Date fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
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
    public List<SsCampoFormulario> getSsCampoFormularioList() {
        return ssCampoFormularioList;
    }

    public void setSsCampoFormularioList(List<SsCampoFormulario> ssCampoFormularioList) {
        this.ssCampoFormularioList = ssCampoFormularioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulario != null ? codFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsFormulario)) {
            return false;
        }
        SsFormulario other = (SsFormulario) object;
        if ((this.codFormulario == null && other.codFormulario != null) || (this.codFormulario != null && !this.codFormulario.equals(other.codFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.ss.SsFormulario[ codFormulario=" + codFormulario + " ]";
    }

}
