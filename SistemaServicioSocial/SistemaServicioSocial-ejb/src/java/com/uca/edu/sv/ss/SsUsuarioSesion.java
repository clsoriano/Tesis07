/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SS_USUARIO_SESION")
@XmlRootElement
public class SsUsuarioSesion implements Serializable {

    @Id
    @Column(name = "ID_USUARIO_SESION")
    @SequenceGenerator(sequenceName = "SEQ_ID_USUARIO_SESION", name = "SEQ_ID_USUARIO_SESION", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_USUARIO_SESION")
    private BigDecimal idUsuarioSesion;
    @Column(name = "COD_USUARIO_CARNET")
    private String codUsuarioCarnet;
    @Column(name = "ES_CAMBIO_CLAVE")
    private String esCambioClave;
    @Column(name = "ES_PRIMER_INICIO_SESION")
    private String esPrimerInicioSesion;
    @Column(name = "ES_ALUMNO")
    private String esAlumno;
    @Column(name = "CORREO")
    private String correo;

    public BigDecimal getIdUsuarioSesion() {
        return idUsuarioSesion;
    }

    public void setIdUsuarioSesion(BigDecimal idUsuarioSesion) {
        this.idUsuarioSesion = idUsuarioSesion;
    }

    public String getCodUsuarioCarnet() {
        return codUsuarioCarnet;
    }

    public void setCodUsuarioCarnet(String codUsuarioCarnet) {
        this.codUsuarioCarnet = codUsuarioCarnet;
    }

    public String getEsCambioClave() {
        return esCambioClave;
    }

    public void setEsCambioClave(String esCambioClave) {
        this.esCambioClave = esCambioClave;
    }

    public String getEsPrimerInicioSesion() {
        return esPrimerInicioSesion;
    }

    public void setEsPrimerInicioSesion(String esPrimerInicioSesion) {
        this.esPrimerInicioSesion = esPrimerInicioSesion;
    }

    public String getEsAlumno() {
        return esAlumno;
    }

    public void setEsAlumno(String esAlumno) {
        this.esAlumno = esAlumno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
