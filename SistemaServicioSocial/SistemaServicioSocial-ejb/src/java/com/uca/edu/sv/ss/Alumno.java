/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "ALUMNO", schema = "SS")
public class Alumno implements Serializable {

    @Id
    @Column(name = "CARNE")
    private String carne;
    @Column(name = "COD_DEPARTAMENTO")
    private String codDepartamento;
    @Column(name = "COD_MUNICIPIO")
    private String codMunicipio;
    @Column(name = "COD_PAIS")
    private String codPais;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDO_CASADA")
    private String apellidoCasada;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
    @Column(name = "DIRECCION_CASA")
    private String direccionCasa;
    @Column(name = "TELEFONO_CASA")
    private String telefonoCasa;
    @Column(name = "CORREO_ELETRONICO")
    private String correoElectronico;
    @Column(name = "LUGAR_TRABAJO")
    private String lugarTrabajo;
    @Column(name = "TELEFONO_TRABAJO")
    private String telefonoTrabajo;
    @Column(name = "EXT_TRABAJO")
    private BigDecimal extTrabajo;
    @Column(name = "FAX_TRABAJO")
    private String faxTrabajo;
    @Column(name = "CORREO_ELETRONICO_TRA")
    private String correoElectronicoTra;
    @Column(name = "OCUPACION")
    private String ocupacion;
    @Column(name = "NUM_HIJOS")
    private String numHijos;
    @Column(name = "FECHA_COLA_ESPERA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaColaEspera;
    @Column(name = "UM_GENERAL")
    private BigDecimal umGeneral;
    @Column(name = "UM_CARRERA")
    private BigDecimal umCarrera;
    @Column(name = "CUM_CARRERA")
    private BigDecimal cumCarrera;
    @Column(name = "CUM_GENERAL")
    private BigDecimal cumGeneral;
    @Column(name = "COD_CARRERA")
    private String codCarrera;
    @Column(name = "ESTADO_ALUMNO")
    private String estadoAlumno;
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
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

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
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

    public BigDecimal getExtTrabajo() {
        return extTrabajo;
    }

    public void setExtTrabajo(BigDecimal extTrabajo) {
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

    public String getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(String numHijos) {
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

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getEstadoAlumno() {
        return estadoAlumno;
    }

    public void setEstadoAlumno(String estadoAlumno) {
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

}
