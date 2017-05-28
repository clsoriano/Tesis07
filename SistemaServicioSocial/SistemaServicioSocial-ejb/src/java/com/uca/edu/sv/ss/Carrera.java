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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "CARRERA")
public class Carrera implements Serializable {

    @Id
    @Column(name = "COD_CARRERA")
    private String codCarrera;
    @Column(name = "NBR_CARRERA")
    private String nbrCarrera;
    @Column(name = "COD_FACULTAD")
    private String codFacultad;
    @Column(name = "COD_TIPO_CARRERA")
    private BigDecimal codTipoCarrera;
    @Column(name = "COD_COORDINADOR")
    private String codCoordinador;

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNbrCarrera() {
        return nbrCarrera;
    }

    public void setNbrCarrera(String nbrCarrera) {
        this.nbrCarrera = nbrCarrera;
    }

    public String getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }

    public BigDecimal getCodTipoCarrera() {
        return codTipoCarrera;
    }

    public void setCodTipoCarrera(BigDecimal codTipoCarrera) {
        this.codTipoCarrera = codTipoCarrera;
    }

    public String getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(String codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

}
