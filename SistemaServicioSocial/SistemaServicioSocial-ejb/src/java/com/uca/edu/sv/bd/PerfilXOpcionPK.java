/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jcsoriano
 */
@Embeddable
public class PerfilXOpcionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_PERFIL")
    private String codPerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_OPCION")
    private int codOpcion;

    public PerfilXOpcionPK() {
    }

    public PerfilXOpcionPK(String codPerfil, int codOpcion) {
        this.codPerfil = codPerfil;
        this.codOpcion = codOpcion;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public int getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(int codOpcion) {
        this.codOpcion = codOpcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        hash += (int) codOpcion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilXOpcionPK)) {
            return false;
        }
        PerfilXOpcionPK other = (PerfilXOpcionPK) object;
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        if (this.codOpcion != other.codOpcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.PerfilXOpcionPK[ codPerfil=" + codPerfil + ", codOpcion=" + codOpcion + " ]";
    }
    
}
