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

/**
 *
 * @author jcsoriano
 */
@Embeddable
public class ProyectoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_INSTITUCION")
    private int codInstitucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORR_PROYECTO")
    private int corrProyecto;

    public ProyectoPK() {
    }

    public ProyectoPK(int codInstitucion, int corrProyecto) {
        this.codInstitucion = codInstitucion;
        this.corrProyecto = corrProyecto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codInstitucion;
        hash += (int) corrProyecto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoPK)) {
            return false;
        }
        ProyectoPK other = (ProyectoPK) object;
        if (this.codInstitucion != other.codInstitucion) {
            return false;
        }
        if (this.corrProyecto != other.corrProyecto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.ProyectoPK[ codInstitucion=" + codInstitucion + ", corrProyecto=" + corrProyecto + " ]";
    }
    
}
