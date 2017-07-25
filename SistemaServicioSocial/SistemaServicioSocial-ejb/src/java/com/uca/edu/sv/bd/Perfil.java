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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_PERFIL")
    private String codPerfil;
    @Size(max = 50)
    @Column(name = "NBR_PERFIL")
    private String nbrPerfil;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "PERFIL_X_USUARIO", joinColumns = {
        @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL")}, inverseJoinColumns = {
        @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilXOpcion> perfilXOpcionList;

    public Perfil() {
    }

    public Perfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNbrPerfil() {
        return nbrPerfil;
    }

    public void setNbrPerfil(String nbrPerfil) {
        this.nbrPerfil = nbrPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Perfil[ codPerfil=" + codPerfil + " ]";
    }
    
}
