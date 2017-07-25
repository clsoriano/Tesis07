/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TIPO_INSTITUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInstitucion.findAll", query = "SELECT t FROM TipoInstitucion t")})
public class TipoInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORR_TIPO_INSTITUCION")
    private Integer corrTipoInstitucion;
    @Size(max = 30)
    @Column(name = "NBR_TIPO_INSTITUCION")
    private String nbrTipoInstitucion;
    @JoinColumn(name = "COD_GRUPO_INSTITUCION", referencedColumnName = "COD_GRUPO_INSTITUCION")
    @ManyToOne(optional = false)
    private GrupoInstitucion codGrupoInstitucion;
    @OneToMany(mappedBy = "corrTipoInstitucion")
    private List<Institucion> institucionList;

    public TipoInstitucion() {
    }

    public TipoInstitucion(Integer corrTipoInstitucion) {
        this.corrTipoInstitucion = corrTipoInstitucion;
    }

    public Integer getCorrTipoInstitucion() {
        return corrTipoInstitucion;
    }

    public void setCorrTipoInstitucion(Integer corrTipoInstitucion) {
        this.corrTipoInstitucion = corrTipoInstitucion;
    }

    public String getNbrTipoInstitucion() {
        return nbrTipoInstitucion;
    }

    public void setNbrTipoInstitucion(String nbrTipoInstitucion) {
        this.nbrTipoInstitucion = nbrTipoInstitucion;
    }

    public GrupoInstitucion getCodGrupoInstitucion() {
        return codGrupoInstitucion;
    }

    public void setCodGrupoInstitucion(GrupoInstitucion codGrupoInstitucion) {
        this.codGrupoInstitucion = codGrupoInstitucion;
    }

    @XmlTransient
    public List<Institucion> getInstitucionList() {
        return institucionList;
    }

    public void setInstitucionList(List<Institucion> institucionList) {
        this.institucionList = institucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corrTipoInstitucion != null ? corrTipoInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstitucion)) {
            return false;
        }
        TipoInstitucion other = (TipoInstitucion) object;
        if ((this.corrTipoInstitucion == null && other.corrTipoInstitucion != null) || (this.corrTipoInstitucion != null && !this.corrTipoInstitucion.equals(other.corrTipoInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.TipoInstitucion[ corrTipoInstitucion=" + corrTipoInstitucion + " ]";
    }
    
}
