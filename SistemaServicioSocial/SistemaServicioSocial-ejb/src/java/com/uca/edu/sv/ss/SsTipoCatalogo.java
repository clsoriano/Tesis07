/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SS_TIPO_CATALOGO", schema = "SS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsTipoCatalogo.findAll", query = "SELECT s FROM SsTipoCatalogo s")})
public class SsTipoCatalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CATALOGO")
    @SequenceGenerator(sequenceName = "SEQ_SS_TIPO_CATALOGO", name = "SEQ_SS_TIPO_CATALOGO", initialValue = 1, allocationSize = 1, schema = "SS")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SS_TIPO_CATALOGO")
    private BigDecimal codCatalogo;
    @Size(max = 100)
    @Column(name = "COD_TIPO")
    private String codTipo;
    @Size(max = 200)
    @Column(name = "VALOR")
    private String valor;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "ADICIONADO_POR")
    private String adicionadoPor;
    @Column(name = "FECHA_ADICION")
    @Temporal(TemporalType.DATE)
    private Date fechaAdicion;
    @Size(max = 100)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "codCatalogo")
    private List<SsSubCatalogo> ssSubCatalogoList;

    public SsTipoCatalogo() {
    }

    public SsTipoCatalogo(BigDecimal codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    public BigDecimal getCodCatalogo() {
        return codCatalogo;
    }

    public void setCodCatalogo(BigDecimal codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    public String getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(String codTipo) {
        this.codTipo = codTipo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<SsSubCatalogo> getSsSubCatalogoList() {
        return ssSubCatalogoList;
    }

    public void setSsSubCatalogoList(List<SsSubCatalogo> ssSubCatalogoList) {
        this.ssSubCatalogoList = ssSubCatalogoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCatalogo != null ? codCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsTipoCatalogo)) {
            return false;
        }
        SsTipoCatalogo other = (SsTipoCatalogo) object;
        if ((this.codCatalogo == null && other.codCatalogo != null) || (this.codCatalogo != null && !this.codCatalogo.equals(other.codCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.ss.SsTipoCatalogo[ codCatalogo=" + codCatalogo + " ]";
    }

}
