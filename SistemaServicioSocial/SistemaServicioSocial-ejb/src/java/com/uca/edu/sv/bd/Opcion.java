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
@Table(name = "OPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_OPCION")
    private Integer codOpcion;
    @Size(max = 100)
    @Column(name = "NBR_OPCION")
    private String nbrOpcion;
    @Size(max = 255)
    @Column(name = "URL")
    private String url;
    @Column(name = "COD_COLUMNA_PADRE")
    private Integer codColumnaPadre;
    @Column(name = "Z_ORDER")
    private Integer zOrder;
    @Column(name = "COD_OPCION_PADRE")
    private Integer codOpcionPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
    private List<PerfilXOpcion> perfilXOpcionList;

    public Opcion() {
    }

    public Opcion(Integer codOpcion) {
        this.codOpcion = codOpcion;
    }

    public Integer getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(Integer codOpcion) {
        this.codOpcion = codOpcion;
    }

    public String getNbrOpcion() {
        return nbrOpcion;
    }

    public void setNbrOpcion(String nbrOpcion) {
        this.nbrOpcion = nbrOpcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCodColumnaPadre() {
        return codColumnaPadre;
    }

    public void setCodColumnaPadre(Integer codColumnaPadre) {
        this.codColumnaPadre = codColumnaPadre;
    }

    public Integer getZOrder() {
        return zOrder;
    }

    public void setZOrder(Integer zOrder) {
        this.zOrder = zOrder;
    }

    public Integer getCodOpcionPadre() {
        return codOpcionPadre;
    }

    public void setCodOpcionPadre(Integer codOpcionPadre) {
        this.codOpcionPadre = codOpcionPadre;
    }

    @XmlTransient
    public List<PerfilXOpcion> getPerfilXOpcionList() {
        return perfilXOpcionList;
    }

    public void setPerfilXOpcionList(List<PerfilXOpcion> perfilXOpcionList) {
        this.perfilXOpcionList = perfilXOpcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOpcion != null ? codOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.codOpcion == null && other.codOpcion != null) || (this.codOpcion != null && !this.codOpcion.equals(other.codOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Opcion[ codOpcion=" + codOpcion + " ]";
    }
    
}
