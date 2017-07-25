/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "HS_X_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsXProyecto.findAll", query = "SELECT h FROM HsXProyecto h")})
public class HsXProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsXProyectoPK hsXProyectoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_ASIGNADAS")
    private int horasAsignadas;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ESTADO")
    private Character estado;
    @Lob
    @Column(name = "OBSERVACIONES")
    private String observaciones;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "INFORME")
    private boolean informe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAN_DE_TRABAJO")
    private boolean planDeTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INFORME_FINAL")
    private boolean informeFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CARTA_DE_FINALIZACION")
    private boolean cartaDeFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACTO_CON_REALIDAD")
    private boolean contactoConRealidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VOLUNTARIADO")
    private boolean voluntariado;
    @Size(max = 2)
    @Column(name = "COD_DEPARTAMENTO")
    private String codDepartamento;
    @Size(max = 2)
    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hsXProyecto")
    private List<SeguimientoAlumno> seguimientoAlumnoList;
    @JoinColumn(name = "CARNE", referencedColumnName = "CARNE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;
    @JoinColumns({
        @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
        , @JoinColumn(name = "CORR_PROYECTO", referencedColumnName = "CORR_PROYECTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public HsXProyecto() {
    }

    public HsXProyecto(HsXProyectoPK hsXProyectoPK) {
        this.hsXProyectoPK = hsXProyectoPK;
    }

    public HsXProyecto(HsXProyectoPK hsXProyectoPK, int horasAsignadas, String modificadoPor, Date fechaModificacion, boolean informe, boolean planDeTrabajo, boolean informeFinal, boolean cartaDeFinalizacion, boolean contactoConRealidad, boolean voluntariado) {
        this.hsXProyectoPK = hsXProyectoPK;
        this.horasAsignadas = horasAsignadas;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
        this.informe = informe;
        this.planDeTrabajo = planDeTrabajo;
        this.informeFinal = informeFinal;
        this.cartaDeFinalizacion = cartaDeFinalizacion;
        this.contactoConRealidad = contactoConRealidad;
        this.voluntariado = voluntariado;
    }

    public HsXProyecto(int codInstitucion, int corrProyecto, String carne) {
        this.hsXProyectoPK = new HsXProyectoPK(codInstitucion, corrProyecto, carne);
    }

    public HsXProyectoPK getHsXProyectoPK() {
        return hsXProyectoPK;
    }

    public void setHsXProyectoPK(HsXProyectoPK hsXProyectoPK) {
        this.hsXProyectoPK = hsXProyectoPK;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public boolean getInforme() {
        return informe;
    }

    public void setInforme(boolean informe) {
        this.informe = informe;
    }

    public boolean getPlanDeTrabajo() {
        return planDeTrabajo;
    }

    public void setPlanDeTrabajo(boolean planDeTrabajo) {
        this.planDeTrabajo = planDeTrabajo;
    }

    public boolean getInformeFinal() {
        return informeFinal;
    }

    public void setInformeFinal(boolean informeFinal) {
        this.informeFinal = informeFinal;
    }

    public boolean getCartaDeFinalizacion() {
        return cartaDeFinalizacion;
    }

    public void setCartaDeFinalizacion(boolean cartaDeFinalizacion) {
        this.cartaDeFinalizacion = cartaDeFinalizacion;
    }

    public boolean getContactoConRealidad() {
        return contactoConRealidad;
    }

    public void setContactoConRealidad(boolean contactoConRealidad) {
        this.contactoConRealidad = contactoConRealidad;
    }

    public boolean getVoluntariado() {
        return voluntariado;
    }

    public void setVoluntariado(boolean voluntariado) {
        this.voluntariado = voluntariado;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    @XmlTransient
    public List<SeguimientoAlumno> getSeguimientoAlumnoList() {
        return seguimientoAlumnoList;
    }

    public void setSeguimientoAlumnoList(List<SeguimientoAlumno> seguimientoAlumnoList) {
        this.seguimientoAlumnoList = seguimientoAlumnoList;
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
        hash += (hsXProyectoPK != null ? hsXProyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXProyecto)) {
            return false;
        }
        HsXProyecto other = (HsXProyecto) object;
        if ((this.hsXProyectoPK == null && other.hsXProyectoPK != null) || (this.hsXProyectoPK != null && !this.hsXProyectoPK.equals(other.hsXProyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXProyecto[ hsXProyectoPK=" + hsXProyectoPK + " ]";
    }
    
}
