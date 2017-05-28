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
@Table(name = "OPCION")
public class Opcion implements Serializable {

    @Id
    @Column(name = "COD_OPCION")
    private BigDecimal codOpcion;
    @Column(name = "NBR_OPCION")
    private String nbrOpcion;
    @Column(name = "URL")
    private String url;
    @Column(name = "COD_COLUMNAN_PADRE")
    private BigDecimal codColumnaPadre;
    @Column(name = "CZ_ORDER")
    private BigDecimal zOrder;
    @Column(name = "COD_OPCION_PADRE")
    private BigDecimal codOpcionPadre;

    public BigDecimal getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(BigDecimal codOpcion) {
        this.codOpcion = codOpcion;
    }

    public String getNbrOpcion() {
        return nbrOpcion;
    }

    public void setNbrOpcion(String nbrOpcion) {
        this.nbrOpcion = nbrOpcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getCodColumnaPadre() {
        return codColumnaPadre;
    }

    public void setCodColumnaPadre(BigDecimal codColumnaPadre) {
        this.codColumnaPadre = codColumnaPadre;
    }

    public BigDecimal getzOrder() {
        return zOrder;
    }

    public void setzOrder(BigDecimal zOrder) {
        this.zOrder = zOrder;
    }

    public BigDecimal getCodOpcionPadre() {
        return codOpcionPadre;
    }

    public void setCodOpcionPadre(BigDecimal codOpcionPadre) {
        this.codOpcionPadre = codOpcionPadre;
    }

}
