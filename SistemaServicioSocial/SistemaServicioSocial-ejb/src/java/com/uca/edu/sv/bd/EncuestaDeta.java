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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "ENCUESTA_DETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EncuestaDeta.findAll", query = "SELECT e FROM EncuestaDeta e")})
public class EncuestaDeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EncuestaDetaPK encuestaDetaPK;
    @Size(max = 100)
    @Column(name = "TEXTO_RESPUESTA")
    private String textoRespuesta;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encuesta encuesta;
    @JoinColumns({
        @JoinColumn(name = "ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_SUBPREGUNTA", referencedColumnName = "ID_SUBPREGUNTA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public EncuestaDeta() {
    }

    public EncuestaDeta(EncuestaDetaPK encuestaDetaPK) {
        this.encuestaDetaPK = encuestaDetaPK;
    }

    public EncuestaDeta(String carne, short idPregunta, short idSubpregunta, short numSeleccion) {
        this.encuestaDetaPK = new EncuestaDetaPK(carne, idPregunta, idSubpregunta, numSeleccion);
    }

    public EncuestaDetaPK getEncuestaDetaPK() {
        return encuestaDetaPK;
    }

    public void setEncuestaDetaPK(EncuestaDetaPK encuestaDetaPK) {
        this.encuestaDetaPK = encuestaDetaPK;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encuestaDetaPK != null ? encuestaDetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncuestaDeta)) {
            return false;
        }
        EncuestaDeta other = (EncuestaDeta) object;
        if ((this.encuestaDetaPK == null && other.encuestaDetaPK != null) || (this.encuestaDetaPK != null && !this.encuestaDetaPK.equals(other.encuestaDetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.EncuestaDeta[ encuestaDetaPK=" + encuestaDetaPK + " ]";
    }
    
}
