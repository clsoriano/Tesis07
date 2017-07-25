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
@Table(name = "SS_PERFIL_X_MENU")
public class SsPerfilXMenu implements Serializable {

    @Id
    @Column(name = "ID_CORRELATIVO")
    @SequenceGenerator(sequenceName = "SEQ_SS_PERFIL_X_MENU", name = "SEQ_SS_PERFIL_X_MENU", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SS_PERFIL_X_MENU")
    private BigDecimal idCorrelativo;
    @Id
    @Column(name = "COD_PERFIL")
    private String codPerfil;
    @Id
    @Column(name = "COD_MENU")
    private BigDecimal codMenu;
    @Column(name = "SUB_MENU")
    private BigDecimal subMenu;
    @Column(name = "ESTADO")
    private Character estado;

    public BigDecimal getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(BigDecimal idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }
    
    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public BigDecimal getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(BigDecimal codMenu) {
        this.codMenu = codMenu;
    }

    public BigDecimal getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(BigDecimal subMenu) {
        this.subMenu = subMenu;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
