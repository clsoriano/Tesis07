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

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SS_MENU")
public class SsMenu implements Serializable {

    @Id
    @Column(name = "COD_MENU")
    @SequenceGenerator(sequenceName = "SEQ_SS_MENU", name = "SEQ_SS_MENU", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SS_MENU")
    private BigDecimal codMenu;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "URL")
    private String url;
    @Column(name = "FUNCION")
    private String funcion;
    @Column(name = "ORDEN")
    private BigDecimal orden;
    @Column(name = "COD_MENU_PADRE")
    private BigDecimal codMenuPadre;
    @Column(name = "ESTADO")
    private Character estado;

    public BigDecimal getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(BigDecimal codMenu) {
        this.codMenu = codMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getOrden() {
        return orden;
    }

    public void setOrden(BigDecimal orden) {
        this.orden = orden;
    }

    public BigDecimal getCodMenuPadre() {
        return codMenuPadre;
    }

    public void setCodMenuPadre(BigDecimal codMenuPadre) {
        this.codMenuPadre = codMenuPadre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
