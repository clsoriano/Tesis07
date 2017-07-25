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
@Table(name = "SOLICITUD_PARTICIPACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudParticipacion.findAll", query = "SELECT s FROM SolicitudParticipacion s")})
public class SolicitudParticipacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudParticipacionPK solicitudParticipacionPK;
    @Size(max = 8)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "TIEMPO")
    private Character tiempo;
    @Size(max = 8)
    @Column(name = "TELEFONO_TRAB")
    private String telefonoTrab;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumns({
        @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
        , @JoinColumn(name = "CORR_PROYECTO", referencedColumnName = "CORR_PROYECTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public SolicitudParticipacion() {
    }

    public SolicitudParticipacion(SolicitudParticipacionPK solicitudParticipacionPK) {
        this.solicitudParticipacionPK = solicitudParticipacionPK;
    }

    public SolicitudParticipacion(SolicitudParticipacionPK solicitudParticipacionPK, Date fechaSolicitud) {
        this.solicitudParticipacionPK = solicitudParticipacionPK;
        this.fechaSolicitud = fechaSolicitud;
    }

    public SolicitudParticipacion(int codInstitucion, int corrProyecto, String carne) {
        this.solicitudParticipacionPK = new SolicitudParticipacionPK(codInstitucion, corrProyecto, carne);
    }

    public SolicitudParticipacionPK getSolicitudParticipacionPK() {
        return solicitudParticipacionPK;
    }

    public void setSolicitudParticipacionPK(SolicitudParticipacionPK solicitudParticipacionPK) {
        this.solicitudParticipacionPK = solicitudParticipacionPK;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Character getTiempo() {
        return tiempo;
    }

    public void setTiempo(Character tiempo) {
        this.tiempo = tiempo;
    }

    public String getTelefonoTrab() {
        return telefonoTrab;
    }

    public void setTelefonoTrab(String telefonoTrab) {
        this.telefonoTrab = telefonoTrab;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudParticipacionPK != null ? solicitudParticipacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudParticipacion)) {
            return false;
        }
        SolicitudParticipacion other = (SolicitudParticipacion) object;
        if ((this.solicitudParticipacionPK == null && other.solicitudParticipacionPK != null) || (this.solicitudParticipacionPK != null && !this.solicitudParticipacionPK.equals(other.solicitudParticipacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.SolicitudParticipacion[ solicitudParticipacionPK=" + solicitudParticipacionPK + " ]";
    }
    
}
