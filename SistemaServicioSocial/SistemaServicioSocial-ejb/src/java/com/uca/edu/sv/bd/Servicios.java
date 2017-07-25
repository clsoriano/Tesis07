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
@Table(name = "SERVICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SERVICIO")
    private Integer codServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "NBR_SERVICIO")
    private String nbrServicio;
    @OneToMany(mappedBy = "area")
    private List<Proyecto> proyectoList;

    public Servicios() {
    }

    public Servicios(Integer codServicio) {
        this.codServicio = codServicio;
    }

    public Servicios(Integer codServicio, String nbrServicio) {
        this.codServicio = codServicio;
        this.nbrServicio = nbrServicio;
    }

    public Integer getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(Integer codServicio) {
        this.codServicio = codServicio;
    }

    public String getNbrServicio() {
        return nbrServicio;
    }

    public void setNbrServicio(String nbrServicio) {
        this.nbrServicio = nbrServicio;
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
        hash += (codServicio != null ? codServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.codServicio == null && other.codServicio != null) || (this.codServicio != null && !this.codServicio.equals(other.codServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Servicios[ codServicio=" + codServicio + " ]";
    }
    
}
