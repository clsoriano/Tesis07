/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "GRUPO_INSTITUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoInstitucion.findAll", query = "SELECT g FROM GrupoInstitucion g")})
public class GrupoInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_GRUPO_INSTITUCION")
    private Integer codGrupoInstitucion;
    @Size(max = 50)
    @Column(name = "NBR_GRUPO_INSTITUCION")
    private String nbrGrupoInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codGrupoInstitucion")
    private List<TipoInstitucion> tipoInstitucionList;

    public GrupoInstitucion() {
    }

    public GrupoInstitucion(Integer codGrupoInstitucion) {
        this.codGrupoInstitucion = codGrupoInstitucion;
    }

    public Integer getCodGrupoInstitucion() {
        return codGrupoInstitucion;
    }

    public void setCodGrupoInstitucion(Integer codGrupoInstitucion) {
        this.codGrupoInstitucion = codGrupoInstitucion;
    }

    public String getNbrGrupoInstitucion() {
        return nbrGrupoInstitucion;
    }

    public void setNbrGrupoInstitucion(String nbrGrupoInstitucion) {
        this.nbrGrupoInstitucion = nbrGrupoInstitucion;
    }

    @XmlTransient
    public List<TipoInstitucion> getTipoInstitucionList() {
        return tipoInstitucionList;
    }

    public void setTipoInstitucionList(List<TipoInstitucion> tipoInstitucionList) {
        this.tipoInstitucionList = tipoInstitucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGrupoInstitucion != null ? codGrupoInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoInstitucion)) {
            return false;
        }
        GrupoInstitucion other = (GrupoInstitucion) object;
        if ((this.codGrupoInstitucion == null && other.codGrupoInstitucion != null) || (this.codGrupoInstitucion != null && !this.codGrupoInstitucion.equals(other.codGrupoInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.GrupoInstitucion[ codGrupoInstitucion=" + codGrupoInstitucion + " ]";
    }
    
}
