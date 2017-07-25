/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "HS_X_INSTRUCTORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsXInstructoria.findAll", query = "SELECT h FROM HsXInstructoria h")})
public class HsXInstructoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsXInstructoriaPK hsXInstructoriaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_ASIGNADAS")
    private int horasAsignadas;
    @Lob
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "ESTADO")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumns({
        @JoinColumn(name = "COD_MATERIA", referencedColumnName = "COD_MATERIA", insertable = false, updatable = false)
        , @JoinColumn(name = "COD_CICLO", referencedColumnName = "COD_CICLO", insertable = false, updatable = false)
        , @JoinColumn(name = "SECCION", referencedColumnName = "SECCION", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private MateriaSeccion materiaSeccion;

    public HsXInstructoria() {
    }

    public HsXInstructoria(HsXInstructoriaPK hsXInstructoriaPK) {
        this.hsXInstructoriaPK = hsXInstructoriaPK;
    }

    public HsXInstructoria(HsXInstructoriaPK hsXInstructoriaPK, int horasAsignadas, String modificadoPor, Date fechaModificacion) {
        this.hsXInstructoriaPK = hsXInstructoriaPK;
        this.horasAsignadas = horasAsignadas;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public HsXInstructoria(String codMateria, String codCiclo, String seccion, String carne) {
        this.hsXInstructoriaPK = new HsXInstructoriaPK(codMateria, codCiclo, seccion, carne);
    }

    public HsXInstructoriaPK getHsXInstructoriaPK() {
        return hsXInstructoriaPK;
    }

    public void setHsXInstructoriaPK(HsXInstructoriaPK hsXInstructoriaPK) {
        this.hsXInstructoriaPK = hsXInstructoriaPK;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public MateriaSeccion getMateriaSeccion() {
        return materiaSeccion;
    }

    public void setMateriaSeccion(MateriaSeccion materiaSeccion) {
        this.materiaSeccion = materiaSeccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsXInstructoriaPK != null ? hsXInstructoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXInstructoria)) {
            return false;
        }
        HsXInstructoria other = (HsXInstructoria) object;
        if ((this.hsXInstructoriaPK == null && other.hsXInstructoriaPK != null) || (this.hsXInstructoriaPK != null && !this.hsXInstructoriaPK.equals(other.hsXInstructoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXInstructoria[ hsXInstructoriaPK=" + hsXInstructoriaPK + " ]";
    }
    
}
