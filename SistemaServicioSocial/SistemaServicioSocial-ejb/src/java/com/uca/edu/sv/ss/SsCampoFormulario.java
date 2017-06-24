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
import javax.persistence.Id;
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
@Table(name = "SS_CAMPO_FORMULARIO", schema = "SS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsCampoFormulario.findAll", query = "SELECT s FROM SsCampoFormulario s")})
public class SsCampoFormulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAMPO")
    private Long codCampo;
    @Size(max = 200)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "AYUDA")
    private String ayuda;
    @Column(name = "COD_TIPO_CAMPO")
    private Long codTipoCampo;
    @Size(max = 1)
    @Column(name = "ES_CAMPO_REQUERIDO")
    private String esCampoRequerido;
    @Size(max = 200)
    @Column(name = "MASCARA")
    private String mascara;
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
    @JoinColumn(name = "COD_FORMULARIO", referencedColumnName = "COD_FORMULARIO")
    @ManyToOne
    private SsFormulario codFormulario;

    public SsCampoFormulario() {
    }

    public SsCampoFormulario(Long codCampo) {
        this.codCampo = codCampo;
    }

    public Long getCodCampo() {
        return codCampo;
    }

    public void setCodCampo(Long codCampo) {
        this.codCampo = codCampo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public Long getCodTipoCampo() {
        return codTipoCampo;
    }

    public void setCodTipoCampo(Long codTipoCampo) {
        this.codTipoCampo = codTipoCampo;
    }

    public String getEsCampoRequerido() {
        return esCampoRequerido;
    }

    public void setEsCampoRequerido(String esCampoRequerido) {
        this.esCampoRequerido = esCampoRequerido;
    }

    public String getMascara() {
        return mascara;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
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

    public SsFormulario getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(SsFormulario codFormulario) {
        this.codFormulario = codFormulario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCampo != null ? codCampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsCampoFormulario)) {
            return false;
        }
        SsCampoFormulario other = (SsCampoFormulario) object;
        if ((this.codCampo == null && other.codCampo != null) || (this.codCampo != null && !this.codCampo.equals(other.codCampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.ss.SsCampoFormulario[ codCampo=" + codCampo + " ]";
    }
    
}
