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
@Table(name = "PERFIL")
public class Perfil implements Serializable {

    @Id
    @Column(name = "COD_PERFIL")
    private String codPerfil;
    @Column(name = "NBR_PERFIL")
    private String nbrPerfil;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNbrPerfil() {
        return nbrPerfil;
    }

    public void setNbrPerfil(String nbrPerfil) {
        this.nbrPerfil = nbrPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
