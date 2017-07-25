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
@Table(name = "TIPO_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProyecto.findAll", query = "SELECT t FROM TipoProyecto t")})
public class TipoProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIPO_PROYECTO")
    private Integer codTipoProyecto;
    @Size(max = 50)
    @Column(name = "NBR_TIPO_PROYECTO")
    private String nbrTipoProyecto;
    @OneToMany(mappedBy = "codTipoProyecto")
    private List<Proyecto> proyectoList;

    public TipoProyecto() {
    }

    public TipoProyecto(Integer codTipoProyecto) {
        this.codTipoProyecto = codTipoProyecto;
    }

    public Integer getCodTipoProyecto() {
        return codTipoProyecto;
    }

    public void setCodTipoProyecto(Integer codTipoProyecto) {
        this.codTipoProyecto = codTipoProyecto;
    }

    public String getNbrTipoProyecto() {
        return nbrTipoProyecto;
    }

    public void setNbrTipoProyecto(String nbrTipoProyecto) {
        this.nbrTipoProyecto = nbrTipoProyecto;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoProyecto != null ? codTipoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProyecto)) {
            return false;
        }
        TipoProyecto other = (TipoProyecto) object;
        if ((this.codTipoProyecto == null && other.codTipoProyecto != null) || (this.codTipoProyecto != null && !this.codTipoProyecto.equals(other.codTipoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.TipoProyecto[ codTipoProyecto=" + codTipoProyecto + " ]";
    }
    
}
