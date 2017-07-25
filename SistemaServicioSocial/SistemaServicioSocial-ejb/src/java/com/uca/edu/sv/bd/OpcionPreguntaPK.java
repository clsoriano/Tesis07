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
public class OpcionPreguntaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PREGUNTA")
    private short idPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUBPREGUNTA")
    private short idSubpregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_SELECCION")
    private short numSeleccion;

    public OpcionPreguntaPK() {
    }

    public OpcionPreguntaPK(short idPregunta, short idSubpregunta, short numSeleccion) {
        this.idPregunta = idPregunta;
        this.idSubpregunta = idSubpregunta;
        this.numSeleccion = numSeleccion;
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

    public short getNumSeleccion() {
        return numSeleccion;
    }

    public void setNumSeleccion(short numSeleccion) {
        this.numSeleccion = numSeleccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPregunta;
        hash += (int) idSubpregunta;
        hash += (int) numSeleccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPreguntaPK)) {
            return false;
        }
        OpcionPreguntaPK other = (OpcionPreguntaPK) object;
        if (this.idPregunta != other.idPregunta) {
            return false;
        }
        if (this.idSubpregunta != other.idSubpregunta) {
            return false;
        }
        if (this.numSeleccion != other.numSeleccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.OpcionPreguntaPK[ idPregunta=" + idPregunta + ", idSubpregunta=" + idSubpregunta + ", numSeleccion=" + numSeleccion + " ]";
    }
    
}
