/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "PREGUNTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreguntaPK preguntaPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TEXTO_PREGUNTA")
    private String textoPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_RESPUESTA_ESPERADA")
    private Character tipoRespuestaEsperada;
    @Column(name = "ID_PREGUNTA_RELACIONADA")
    private Short idPreguntaRelacionada;
    @Column(name = "ID_SUBPREGUNTA_RELACIONADA")
    private Short idSubpreguntaRelacionada;
    @Column(name = "NUM_SELECCION_RELACIONADA")
    private Short numSeleccionRelacionada;
    @Size(max = 40)
    @Column(name = "NOMBRE_PROPIEDAD")
    private String nombrePropiedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<OpcionPregunta> opcionPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<EncuestaDeta> encuestaDetaList;

    public Pregunta() {
    }

    public Pregunta(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public Pregunta(PreguntaPK preguntaPK, String textoPregunta, Character tipoRespuestaEsperada) {
        this.preguntaPK = preguntaPK;
        this.textoPregunta = textoPregunta;
        this.tipoRespuestaEsperada = tipoRespuestaEsperada;
    }

    public Pregunta(short idPregunta, short idSubpregunta) {
        this.preguntaPK = new PreguntaPK(idPregunta, idSubpregunta);
    }

    public PreguntaPK getPreguntaPK() {
        return preguntaPK;
    }

    public void setPreguntaPK(PreguntaPK preguntaPK) {
        this.preguntaPK = preguntaPK;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public Character getTipoRespuestaEsperada() {
        return tipoRespuestaEsperada;
    }

    public void setTipoRespuestaEsperada(Character tipoRespuestaEsperada) {
        this.tipoRespuestaEsperada = tipoRespuestaEsperada;
    }

    public Short getIdPreguntaRelacionada() {
        return idPreguntaRelacionada;
    }

    public void setIdPreguntaRelacionada(Short idPreguntaRelacionada) {
        this.idPreguntaRelacionada = idPreguntaRelacionada;
    }

    public Short getIdSubpreguntaRelacionada() {
        return idSubpreguntaRelacionada;
    }

    public void setIdSubpreguntaRelacionada(Short idSubpreguntaRelacionada) {
        this.idSubpreguntaRelacionada = idSubpreguntaRelacionada;
    }

    public Short getNumSeleccionRelacionada() {
        return numSeleccionRelacionada;
    }

    public void setNumSeleccionRelacionada(Short numSeleccionRelacionada) {
        this.numSeleccionRelacionada = numSeleccionRelacionada;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    @XmlTransient
    public List<OpcionPregunta> getOpcionPreguntaList() {
        return opcionPreguntaList;
    }

    public void setOpcionPreguntaList(List<OpcionPregunta> opcionPreguntaList) {
        this.opcionPreguntaList = opcionPreguntaList;
    }

    @XmlTransient
    public List<EncuestaDeta> getEncuestaDetaList() {
        return encuestaDetaList;
    }

    public void setEncuestaDetaList(List<EncuestaDeta> encuestaDetaList) {
        this.encuestaDetaList = encuestaDetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preguntaPK != null ? preguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaPK == null && other.preguntaPK != null) || (this.preguntaPK != null && !this.preguntaPK.equals(other.preguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Pregunta[ preguntaPK=" + preguntaPK + " ]";
    }
    
}
