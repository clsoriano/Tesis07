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
public class HsXPracticaDocentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORR_PRACTICA")
    private int corrPractica;

    public HsXPracticaDocentePK() {
    }

    public HsXPracticaDocentePK(String carne, int corrPractica) {
        this.carne = carne;
        this.corrPractica = corrPractica;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getCorrPractica() {
        return corrPractica;
    }

    public void setCorrPractica(int corrPractica) {
        this.corrPractica = corrPractica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carne != null ? carne.hashCode() : 0);
        hash += (int) corrPractica;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXPracticaDocentePK)) {
            return false;
        }
        HsXPracticaDocentePK other = (HsXPracticaDocentePK) object;
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        if (this.corrPractica != other.corrPractica) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXPracticaDocentePK[ carne=" + carne + ", corrPractica=" + corrPractica + " ]";
    }
    
}
