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
@Table(name = "HS_X_PRACTICA_DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsXPracticaDocente.findAll", query = "SELECT h FROM HsXPracticaDocente h")})
public class HsXPracticaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsXPracticaDocentePK hsXPracticaDocentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAS_ASIGNADAS")
    private int horasAsignadas;
    @Column(name = "FEC_INICIO1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio1;
    @Column(name = "FEC_FIN1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin1;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR1")
    private String codCoordinador1;
    @Column(name = "FEC_INICIO2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio2;
    @Column(name = "FEC_FIN2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin2;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR2")
    private String codCoordinador2;
    @Column(name = "FEC_INICIO3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio3;
    @Column(name = "FEC_FIN3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin3;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR3")
    private String codCoordinador3;
    @Column(name = "FEC_INICIO4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio4;
    @Column(name = "FEC_FIN4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin4;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR4")
    private String codCoordinador4;
    @Column(name = "FEC_INICIO5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInicio5;
    @Column(name = "FEC_FIN5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecFin5;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR5")
    private String codCoordinador5;
    @Column(name = "FECHA_EQUIVALENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEquivalencia;
    @Size(max = 7)
    @Column(name = "COD_JEFE_DEPTO")
    private String codJefeDepto;
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
        @JoinColumn(name = "COD_CENTRO_ESCOLAR1", referencedColumnName = "COD_INSTITUCION")
        , @JoinColumn(name = "COD_CENTRO_ESCOLAR2", referencedColumnName = "COD_INSTITUCION")
        , @JoinColumn(name = "COD_CENTRO_ESCOLAR3", referencedColumnName = "COD_INSTITUCION")
        , @JoinColumn(name = "COD_CENTRO_ESCOLAR4", referencedColumnName = "COD_INSTITUCION")
        , @JoinColumn(name = "COD_CENTRO_ESCOLAR5", referencedColumnName = "COD_INSTITUCION")})
    @ManyToOne
    private Institucion institucion;

    public HsXPracticaDocente() {
    }

    public HsXPracticaDocente(HsXPracticaDocentePK hsXPracticaDocentePK) {
        this.hsXPracticaDocentePK = hsXPracticaDocentePK;
    }

    public HsXPracticaDocente(HsXPracticaDocentePK hsXPracticaDocentePK, int horasAsignadas, String modificadoPor, Date fechaModificacion) {
        this.hsXPracticaDocentePK = hsXPracticaDocentePK;
        this.horasAsignadas = horasAsignadas;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public HsXPracticaDocente(String carne, int corrPractica) {
        this.hsXPracticaDocentePK = new HsXPracticaDocentePK(carne, corrPractica);
    }

    public HsXPracticaDocentePK getHsXPracticaDocentePK() {
        return hsXPracticaDocentePK;
    }

    public void setHsXPracticaDocentePK(HsXPracticaDocentePK hsXPracticaDocentePK) {
        this.hsXPracticaDocentePK = hsXPracticaDocentePK;
    }

    public int getHorasAsignadas() {
        return horasAsignadas;
    }

    public void setHorasAsignadas(int horasAsignadas) {
        this.horasAsignadas = horasAsignadas;
    }

    public Date getFecInicio1() {
        return fecInicio1;
    }

    public void setFecInicio1(Date fecInicio1) {
        this.fecInicio1 = fecInicio1;
    }

    public Date getFecFin1() {
        return fecFin1;
    }

    public void setFecFin1(Date fecFin1) {
        this.fecFin1 = fecFin1;
    }

    public String getCodCoordinador1() {
        return codCoordinador1;
    }

    public void setCodCoordinador1(String codCoordinador1) {
        this.codCoordinador1 = codCoordinador1;
    }

    public Date getFecInicio2() {
        return fecInicio2;
    }

    public void setFecInicio2(Date fecInicio2) {
        this.fecInicio2 = fecInicio2;
    }

    public Date getFecFin2() {
        return fecFin2;
    }

    public void setFecFin2(Date fecFin2) {
        this.fecFin2 = fecFin2;
    }

    public String getCodCoordinador2() {
        return codCoordinador2;
    }

    public void setCodCoordinador2(String codCoordinador2) {
        this.codCoordinador2 = codCoordinador2;
    }

    public Date getFecInicio3() {
        return fecInicio3;
    }

    public void setFecInicio3(Date fecInicio3) {
        this.fecInicio3 = fecInicio3;
    }

    public Date getFecFin3() {
        return fecFin3;
    }

    public void setFecFin3(Date fecFin3) {
        this.fecFin3 = fecFin3;
    }

    public String getCodCoordinador3() {
        return codCoordinador3;
    }

    public void setCodCoordinador3(String codCoordinador3) {
        this.codCoordinador3 = codCoordinador3;
    }

    public Date getFecInicio4() {
        return fecInicio4;
    }

    public void setFecInicio4(Date fecInicio4) {
        this.fecInicio4 = fecInicio4;
    }

    public Date getFecFin4() {
        return fecFin4;
    }

    public void setFecFin4(Date fecFin4) {
        this.fecFin4 = fecFin4;
    }

    public String getCodCoordinador4() {
        return codCoordinador4;
    }

    public void setCodCoordinador4(String codCoordinador4) {
        this.codCoordinador4 = codCoordinador4;
    }

    public Date getFecInicio5() {
        return fecInicio5;
    }

    public void setFecInicio5(Date fecInicio5) {
        this.fecInicio5 = fecInicio5;
    }

    public Date getFecFin5() {
        return fecFin5;
    }

    public void setFecFin5(Date fecFin5) {
        this.fecFin5 = fecFin5;
    }

    public String getCodCoordinador5() {
        return codCoordinador5;
    }

    public void setCodCoordinador5(String codCoordinador5) {
        this.codCoordinador5 = codCoordinador5;
    }

    public Date getFechaEquivalencia() {
        return fechaEquivalencia;
    }

    public void setFechaEquivalencia(Date fechaEquivalencia) {
        this.fechaEquivalencia = fechaEquivalencia;
    }

    public String getCodJefeDepto() {
        return codJefeDepto;
    }

    public void setCodJefeDepto(String codJefeDepto) {
        this.codJefeDepto = codJefeDepto;
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

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsXPracticaDocentePK != null ? hsXPracticaDocentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXPracticaDocente)) {
            return false;
        }
        HsXPracticaDocente other = (HsXPracticaDocente) object;
        if ((this.hsXPracticaDocentePK == null && other.hsXPracticaDocentePK != null) || (this.hsXPracticaDocentePK != null && !this.hsXPracticaDocentePK.equals(other.hsXPracticaDocentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXPracticaDocente[ hsXPracticaDocentePK=" + hsXPracticaDocentePK + " ]";
    }
    
}
