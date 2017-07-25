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
public class EncuestaDetaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;
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

    public EncuestaDetaPK() {
    }

    public EncuestaDetaPK(String carne, short idPregunta, short idSubpregunta, short numSeleccion) {
        this.carne = carne;
        this.idPregunta = idPregunta;
        this.idSubpregunta = idSubpregunta;
        this.numSeleccion = numSeleccion;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
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
        hash += (carne != null ? carne.hashCode() : 0);
        hash += (int) idPregunta;
        hash += (int) idSubpregunta;
        hash += (int) numSeleccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaDetaPK)) {
            return false;
        }
        EncuestaDetaPK other = (EncuestaDetaPK) object;
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
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
        return "com.uca.edu.sv.bd.EncuestaDetaPK[ carne=" + carne + ", idPregunta=" + idPregunta + ", idSubpregunta=" + idSubpregunta + ", numSeleccion=" + numSeleccion + " ]";
    }
    
}