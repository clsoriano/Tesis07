/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;
    @Size(max = 20)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 15)
    @Column(name = "APELLIDO_CASADA")
    private String apellidoCasada;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "ESTADO_CIVIL")
    private Character estadoCivil;
    @Size(max = 80)
    @Column(name = "DIRECCION_CASA")
    private String direccionCasa;
    @Size(max = 8)
    @Column(name = "TELEFONO_CASA")
    private String telefonoCasa;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Size(max = 50)
    @Column(name = "LUGAR_TRABAJO")
    private String lugarTrabajo;
    @Size(max = 8)
    @Column(name = "TELEFONO_TRABAJO")
    private String telefonoTrabajo;
    @Column(name = "EXT_TRABAJO")
    private Integer extTrabajo;
    @Size(max = 8)
    @Column(name = "FAX_TRABAJO")
    private String faxTrabajo;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO_TRA")
    private String correoElectronicoTra;
    @Size(max = 30)
    @Column(name = "OCUPACION")
    private String ocupacion;
    @Column(name = "NUM_HIJOS")
    private Short numHijos;
    @Column(name = "FECHA_COLA_ESPERA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaColaEspera;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UM_GENERAL")
    private BigDecimal umGeneral;
    @Column(name = "UM_CARRERA")
    private BigDecimal umCarrera;
    @Column(name = "CUM_CARRERA")
    private BigDecimal cumCarrera;
    @Column(name = "CUM_GENERAL")
    private BigDecimal cumGeneral;
    @Column(name = "ESTADO_ALUMNO")
    private Character estadoAlumno;
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
    @JoinColumn(name = "COD_CARRERA", referencedColumnName = "COD_CARRERA")
    @ManyToOne
    private Carrera codCarrera;
    @JoinColumns({
        @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO")
        , @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO")})
    @ManyToOne
    private Municipio municipio;
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS")
    @ManyToOne
    private Pais codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<SolicitudParticipacion> solicitudParticipacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HsXServicioInterno> hsXServicioInternoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Constancia> constanciaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Encuesta encuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HsXInstructoria> hsXInstructoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HsXEquivalencia> hsXEquivalenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Semestre> semestreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HsXProyecto> hsXProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Expediente> expedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HsXPracticaDocente> hsXPracticaDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<HistoriaCarrera> historiaCarreraList;

    public Alumno() {
    }

    public Alumno(String carne) {
        this.carne = carne;
    }

    public Alumno(String carne, String modificadoPor, Date fechaModificacion) {
        this.carne = carne;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccionCasa() {
        return direccionCasa;
    }

    public void setDireccionCasa(String direccionCasa) {
        this.direccionCasa = direccionCasa;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public Integer getExtTrabajo() {
        return extTrabajo;
    }

    public void setExtTrabajo(Integer extTrabajo) {
        this.extTrabajo = extTrabajo;
    }

    public String getFaxTrabajo() {
        return faxTrabajo;
    }

    public void setFaxTrabajo(String faxTrabajo) {
        this.faxTrabajo = faxTrabajo;
    }

    public String getCorreoElectronicoTra() {
        return correoElectronicoTra;
    }

    public void setCorreoElectronicoTra(String correoElectronicoTra) {
        this.correoElectronicoTra = correoElectronicoTra;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Short getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(Short numHijos) {
        this.numHijos = numHijos;
    }

    public Date getFechaColaEspera() {
        return fechaColaEspera;
    }

    public void setFechaColaEspera(Date fechaColaEspera) {
        this.fechaColaEspera = fechaColaEspera;
    }

    public BigDecimal getUmGeneral() {
        return umGeneral;
    }

    public void setUmGeneral(BigDecimal umGeneral) {
        this.umGeneral = umGeneral;
    }

    public BigDecimal getUmCarrera() {
        return umCarrera;
    }

    public void setUmCarrera(BigDecimal umCarrera) {
        this.umCarrera = umCarrera;
    }

    public BigDecimal getCumCarrera() {
        return cumCarrera;
    }

    public void setCumCarrera(BigDecimal cumCarrera) {
        this.cumCarrera = cumCarrera;
    }

    public BigDecimal getCumGeneral() {
        return cumGeneral;
    }

    public void setCumGeneral(BigDecimal cumGeneral) {
        this.cumGeneral = cumGeneral;
    }

    public Character getEstadoAlumno() {
        return estadoAlumno;
    }

    public void setEstadoAlumno(Character estadoAlumno) {
        this.estadoAlumno = estadoAlumno;
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

    public Carrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public List<SolicitudParticipacion> getSolicitudParticipacionList() {
        return solicitudParticipacionList;
    }

    public void setSolicitudParticipacionList(List<SolicitudParticipacion> solicitudParticipacionList) {
        this.solicitudParticipacionList = solicitudParticipacionList;
    }

    @XmlTransient
    public List<HsXServicioInterno> getHsXServicioInternoList() {
        return hsXServicioInternoList;
    }

    public void setHsXServicioInternoList(List<HsXServicioInterno> hsXServicioInternoList) {
        this.hsXServicioInternoList = hsXServicioInternoList;
    }

    @XmlTransient
    public List<Constancia> getConstanciaList() {
        return constanciaList;
    }

    public void setConstanciaList(List<Constancia> constanciaList) {
        this.constanciaList = constanciaList;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    @XmlTransient
    public List<HsXInstructoria> getHsXInstructoriaList() {
        return hsXInstructoriaList;
    }

    public void setHsXInstructoriaList(List<HsXInstructoria> hsXInstructoriaList) {
        this.hsXInstructoriaList = hsXInstructoriaList;
    }

    @XmlTransient
    public List<HsXEquivalencia> getHsXEquivalenciaList() {
        return hsXEquivalenciaList;
    }

    public void setHsXEquivalenciaList(List<HsXEquivalencia> hsXEquivalenciaList) {
        this.hsXEquivalenciaList = hsXEquivalenciaList;
    }

    @XmlTransient
    public List<Semestre> getSemestreList() {
        return semestreList;
    }

    public void setSemestreList(List<Semestre> semestreList) {
        this.semestreList = semestreList;
    }

    @XmlTransient
    public List<HsXProyecto> getHsXProyectoList() {
        return hsXProyectoList;
    }

    public void setHsXProyectoList(List<HsXProyecto> hsXProyectoList) {
        this.hsXProyectoList = hsXProyectoList;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    @XmlTransient
    public List<HsXPracticaDocente> getHsXPracticaDocenteList() {
        return hsXPracticaDocenteList;
    }

    public void setHsXPracticaDocenteList(List<HsXPracticaDocente> hsXPracticaDocenteList) {
        this.hsXPracticaDocenteList = hsXPracticaDocenteList;
    }

    @XmlTransient
    public List<HistoriaCarrera> getHistoriaCarreraList() {
        return historiaCarreraList;
    }

    public void setHistoriaCarreraList(List<HistoriaCarrera> historiaCarreraList) {
        this.historiaCarreraList = historiaCarreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carne != null ? carne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Alumno[ carne=" + carne + " ]";
    }
    
}
