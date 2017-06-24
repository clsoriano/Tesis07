/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "SS_SUB_CATALOGO", schema = "SS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsSubCatalogo.findAll", query = "SELECT s FROM SsSubCatalogo s")})
public class SsSubCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SUB_CATALOGO")
    @SequenceGenerator(sequenceName = "SEQ_SS_SUB_CATALOGO", name = "SEQ_SS_SUB_CATALOGO", initialValue = 1, allocationSize = 1, schema = "SS")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SS_SUB_CATALOGO")
    private Long codSubCatalogo;
    @JoinColumn(name = "COD_CATALOGO", referencedColumnName = "COD_CATALOGO")
    @ManyToOne
    private SsTipoCatalogo codCatalogo;
    @Size(max = 100)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
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

    public SsSubCatalogo() {
    }

    public SsSubCatalogo(Long codSubCatalogo) {
        this.codSubCatalogo = codSubCatalogo;
    }

    public Long getCodSubCatalogo() {
        return codSubCatalogo;
    }

    public void setCodSubCatalogo(Long codSubCatalogo) {
        this.codSubCatalogo = codSubCatalogo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public SsTipoCatalogo getCodCatalogo() {
        return codCatalogo;
    }

    public void setCodCatalogo(SsTipoCatalogo codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubCatalogo != null ? codSubCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsSubCatalogo)) {
            return false;
        }
        SsSubCatalogo other = (SsSubCatalogo) object;
        if ((this.codSubCatalogo == null && other.codSubCatalogo != null) || (this.codSubCatalogo != null && !this.codSubCatalogo.equals(other.codSubCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.ss.SsSubCatalogo[ codSubCatalogo=" + codSubCatalogo + " ]";
    }

}
