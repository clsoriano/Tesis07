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
public class PreguntaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PREGUNTA")
    private short idPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBPREGUNTA")
    private short idSubpregunta;

    public PreguntaPK() {
    }

    public PreguntaPK(short idPregunta, short idSubpregunta) {
        this.idPregunta = idPregunta;
        this.idSubpregunta = idSubpregunta;
    }

    public short getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(short idPregunta) {
        this.idPregunta = idPregunta;
    }

    public short getIdSubpregunta() {
        return idSubpregunta;
    }

    public void setIdSubpregunta(short idSubpregunta) {
        this.idSubpregunta = idSubpregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPregunta;
        hash += (int) idSubpregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntaPK)) {
            return false;
        }
        PreguntaPK other = (PreguntaPK) object;
        if (this.idPregunta != other.idPregunta) {
            return false;
        }
        if (this.idSubpregunta != other.idSubpregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.PreguntaPK[ idPregunta=" + idPregunta + ", idSubpregunta=" + idSubpregunta + " ]";
    }
    
}
