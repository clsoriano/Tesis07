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
public class HsXServicioInternoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_UNIDAD")
    private String codUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORR_SERVICIO")
    private int corrServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;

    public HsXServicioInternoPK() {
    }

    public HsXServicioInternoPK(String codUnidad, int corrServicio, String carne) {
        this.codUnidad = codUnidad;
        this.corrServicio = corrServicio;
        this.carne = carne;
    }

    public String getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(String codUnidad) {
        this.codUnidad = codUnidad;
    }

    public int getCorrServicio() {
        return corrServicio;
    }

    public void setCorrServicio(int corrServicio) {
        this.corrServicio = corrServicio;
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
        hash += (codUnidad != null ? codUnidad.hashCode() : 0);
        hash += (int) corrServicio;
        hash += (carne != null ? carne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXServicioInternoPK)) {
            return false;
        }
        HsXServicioInternoPK other = (HsXServicioInternoPK) object;
        if ((this.codUnidad == null && other.codUnidad != null) || (this.codUnidad != null && !this.codUnidad.equals(other.codUnidad))) {
            return false;
        }
        if (this.corrServicio != other.corrServicio) {
            return false;
        }
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXServicioInternoPK[ codUnidad=" + codUnidad + ", corrServicio=" + corrServicio + ", carne=" + carne + " ]";
    }
    
}
