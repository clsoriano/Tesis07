/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "PERFIL_X_OPCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilXOpcion.findAll", query = "SELECT p FROM PerfilXOpcion p")})
public class PerfilXOpcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilXOpcionPK perfilXOpcionPK;
    @Column(name = "ESTADO")
    private Character estado;
    @JoinColumn(name = "COD_OPCION", referencedColumnName = "COD_OPCION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Opcion opcion;
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    public PerfilXOpcion() {
    }

    public PerfilXOpcion(PerfilXOpcionPK perfilXOpcionPK) {
        this.perfilXOpcionPK = perfilXOpcionPK;
    }

    public PerfilXOpcion(String codPerfil, int codOpcion) {
        this.perfilXOpcionPK = new PerfilXOpcionPK(codPerfil, codOpcion);
    }

    public PerfilXOpcionPK getPerfilXOpcionPK() {
        return perfilXOpcionPK;
    }

    public void setPerfilXOpcionPK(PerfilXOpcionPK perfilXOpcionPK) {
        this.perfilXOpcionPK = perfilXOpcionPK;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilXOpcionPK != null ? perfilXOpcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilXOpcion)) {
            return false;
        }
        PerfilXOpcion other = (PerfilXOpcion) object;
        if ((this.perfilXOpcionPK == null && other.perfilXOpcionPK != null) || (this.perfilXOpcionPK != null && !this.perfilXOpcionPK.equals(other.perfilXOpcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.PerfilXOpcion[ perfilXOpcionPK=" + perfilXOpcionPK + " ]";
    }
    
}
