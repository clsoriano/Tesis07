/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "PLAN_CARRERA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanCarrera.findAll", query = "SELECT p FROM PlanCarrera p")})
public class PlanCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanCarreraPK planCarreraPK;
    @Column(name = "TOTAL_UV")
    private Integer totalUv;
    @JoinColumn(name = "COD_CARRERA", referencedColumnName = "COD_CARRERA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;

    public PlanCarrera() {
    }

    public PlanCarrera(PlanCarreraPK planCarreraPK) {
        this.planCarreraPK = planCarreraPK;
    }

    public PlanCarrera(String codCarrera, String planCarrera) {
        this.planCarreraPK = new PlanCarreraPK(codCarrera, planCarrera);
    }

    public PlanCarreraPK getPlanCarreraPK() {
        return planCarreraPK;
    }

    public void setPlanCarreraPK(PlanCarreraPK planCarreraPK) {
        this.planCarreraPK = planCarreraPK;
    }

    public Integer getTotalUv() {
        return totalUv;
    }

    public void setTotalUv(Integer totalUv) {
        this.totalUv = totalUv;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planCarreraPK != null ? planCarreraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCarrera)) {
            return false;
        }
        PlanCarrera other = (PlanCarrera) object;
        if ((this.planCarreraPK == null && other.planCarreraPK != null) || (this.planCarreraPK != null && !this.planCarreraPK.equals(other.planCarreraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.PlanCarrera[ planCarreraPK=" + planCarreraPK + " ]";
    }
    
}
