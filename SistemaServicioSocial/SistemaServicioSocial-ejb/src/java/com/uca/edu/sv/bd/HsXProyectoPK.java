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
public class HsXProyectoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_INSTITUCION")
    private int codInstitucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORR_PROYECTO")
    private int corrProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;

    public HsXProyectoPK() {
    }

    public HsXProyectoPK(int codInstitucion, int corrProyecto, String carne) {
        this.codInstitucion = codInstitucion;
        this.corrProyecto = corrProyecto;
        this.carne = carne;
    }

    public int getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(int codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public int getCorrProyecto() {
        return corrProyecto;
    }

    public void setCorrProyecto(int corrProyecto) {
        this.corrProyecto = corrProyecto;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codInstitucion;
        hash += (int) corrProyecto;
        hash += (carne != null ? carne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXProyectoPK)) {
            return false;
        }
        HsXProyectoPK other = (HsXProyectoPK) object;
        if (this.codInstitucion != other.codInstitucion) {
            return false;
        }
        if (this.corrProyecto != other.corrProyecto) {
            return false;
        }
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXProyectoPK[ codInstitucion=" + codInstitucion + ", corrProyecto=" + corrProyecto + ", carne=" + carne + " ]";
    }
    
}
