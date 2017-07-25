/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jcsoriano
 */
@Embeddable
public class PlanCarreraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_CARRERA")
    private String codCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PLAN_CARRERA")
    private String planCarrera;

    public PlanCarreraPK() {
    }

    public PlanCarreraPK(String codCarrera, String planCarrera) {
        this.codCarrera = codCarrera;
        this.planCarrera = planCarrera;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getPlanCarrera() {
        return planCarrera;
    }

    public void setPlanCarrera(String planCarrera) {
        this.planCarrera = planCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarrera != null ? codCarrera.hashCode() : 0);
        hash += (planCarrera != null ? planCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanCarreraPK)) {
            return false;
        }
        PlanCarreraPK other = (PlanCarreraPK) object;
        if ((this.codCarrera == null && other.codCarrera != null) || (this.codCarrera != null && !this.codCarrera.equals(other.codCarrera))) {
            return false;
        }
        if ((this.planCarrera == null && other.planCarrera != null) || (this.planCarrera != null && !this.planCarrera.equals(other.planCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.PlanCarreraPK[ codCarrera=" + codCarrera + ", planCarrera=" + planCarrera + " ]";
    }
    
}
