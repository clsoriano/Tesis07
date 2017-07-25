/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "ACCION_AUDITORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccionAuditoria.findAll", query = "SELECT a FROM AccionAuditoria a")})
public class AccionAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ACCION")
    private Integer codAccion;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public AccionAuditoria() {
    }

    public AccionAuditoria(Integer codAccion) {
        this.codAccion = codAccion;
    }

    public Integer getCodAccion() {
        return codAccion;
    }

    public void setCodAccion(Integer codAccion) {
        this.codAccion = codAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAccion != null ? codAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccionAuditoria)) {
            return false;
        }
        AccionAuditoria other = (AccionAuditoria) object;
        if ((this.codAccion == null && other.codAccion != null) || (this.codAccion != null && !this.codAccion.equals(other.codAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.AccionAuditoria[ codAccion=" + codAccion + " ]";
    }
    
}
