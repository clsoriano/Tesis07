/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "NBR_USUARIO")
    private String nbrUsuario;
    @Column(name = "ASOCIADA_A")
    private String asociadoA;
    @Column(name = "COD_ENTIDAD_ASOCIADA")
    private String codEntidadAsociada;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_EXPIRACION")
    private String fechaExpiracion;

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNbrUsuario() {
        return nbrUsuario;
    }

    public void setNbrUsuario(String nbrUsuario) {
        this.nbrUsuario = nbrUsuario;
    }

    public String getAsociadoA() {
        return asociadoA;
    }

    public void setAsociadoA(String asociadoA) {
        this.asociadoA = asociadoA;
    }

    public String getCodEntidadAsociada() {
        return codEntidadAsociada;
    }

    public void setCodEntidadAsociada(String codEntidadAsociada) {
        this.codEntidadAsociada = codEntidadAsociada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

}
