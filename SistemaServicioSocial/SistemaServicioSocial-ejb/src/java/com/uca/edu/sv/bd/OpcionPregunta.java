/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "OPCION_PREGUNTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionPregunta.findAll", query = "SELECT o FROM OpcionPregunta o")})
public class OpcionPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionPreguntaPK opcionPreguntaPK;
    @Size(max = 50)
    @Column(name = "TEXTO_SELECCION")
    private String textoSeleccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_SELECCION")
    private Character tipoSeleccion;
    @Size(max = 40)
    @Column(name = "NOMBRE_PROPIEDAD")
    private String nombrePropiedad;
    @JoinColumns({
        @JoinColumn(name = "ID_PREGUNTA", referencedColumnName = "ID_PREGUNTA", insertable = false, updatable = false)
        , @JoinColumn(name = "ID_SUBPREGUNTA", referencedColumnName = "ID_SUBPREGUNTA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public OpcionPregunta() {
    }

    public OpcionPregunta(OpcionPreguntaPK opcionPreguntaPK) {
        this.opcionPreguntaPK = opcionPreguntaPK;
    }

    public OpcionPregunta(OpcionPreguntaPK opcionPreguntaPK, Character tipoSeleccion) {
        this.opcionPreguntaPK = opcionPreguntaPK;
        this.tipoSeleccion = tipoSeleccion;
    }

    public OpcionPregunta(short idPregunta, short idSubpregunta, short numSeleccion) {
        this.opcionPreguntaPK = new OpcionPreguntaPK(idPregunta, idSubpregunta, numSeleccion);
    }

    public OpcionPreguntaPK getOpcionPreguntaPK() {
        return opcionPreguntaPK;
    }

    public void setOpcionPreguntaPK(OpcionPreguntaPK opcionPreguntaPK) {
        this.opcionPreguntaPK = opcionPreguntaPK;
    }

    public String getTextoSeleccion() {
        return textoSeleccion;
    }

    public void setTextoSeleccion(String textoSeleccion) {
        this.textoSeleccion = textoSeleccion;
    }

    public Character getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(Character tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
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
        hash += (opcionPreguntaPK != null ? opcionPreguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPregunta)) {
            return false;
        }
        OpcionPregunta other = (OpcionPregunta) object;
        if ((this.opcionPreguntaPK == null && other.opcionPreguntaPK != null) || (this.opcionPreguntaPK != null && !this.opcionPreguntaPK.equals(other.opcionPreguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.OpcionPregunta[ opcionPreguntaPK=" + opcionPreguntaPK + " ]";
    }
    
}
