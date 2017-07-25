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
public class HistoriaCarreraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "COD_CARRERA")
    private String codCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PLAN_CARRERA_INGRESO")
    private String planCarreraIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_CICLO_ING")
    private String codCicloIng;

    public HistoriaCarreraPK() {
    }

    public HistoriaCarreraPK(String carne, String codCarrera, String planCarreraIngreso, String codCicloIng) {
        this.carne = carne;
        this.codCarrera = codCarrera;
        this.planCarreraIngreso = planCarreraIngreso;
        this.codCicloIng = codCicloIng;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(String codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getPlanCarreraIngreso() {
        return planCarreraIngreso;
    }

    public void setPlanCarreraIngreso(String planCarreraIngreso) {
        this.planCarreraIngreso = planCarreraIngreso;
    }

    public String getCodCicloIng() {
        return codCicloIng;
    }

    public void setCodCicloIng(String codCicloIng) {
        this.codCicloIng = codCicloIng;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carne != null ? carne.hashCode() : 0);
        hash += (codCarrera != null ? codCarrera.hashCode() : 0);
        hash += (planCarreraIngreso != null ? planCarreraIngreso.hashCode() : 0);
        hash += (codCicloIng != null ? codCicloIng.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaCarreraPK)) {
            return false;
        }
        HistoriaCarreraPK other = (HistoriaCarreraPK) object;
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        if ((this.codCarrera == null && other.codCarrera != null) || (this.codCarrera != null && !this.codCarrera.equals(other.codCarrera))) {
            return false;
        }
        if ((this.planCarreraIngreso == null && other.planCarreraIngreso != null) || (this.planCarreraIngreso != null && !this.planCarreraIngreso.equals(other.planCarreraIngreso))) {
            return false;
        }
        if ((this.codCicloIng == null && other.codCicloIng != null) || (this.codCicloIng != null && !this.codCicloIng.equals(other.codCicloIng))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HistoriaCarreraPK[ carne=" + carne + ", codCarrera=" + codCarrera + ", planCarreraIngreso=" + planCarreraIngreso + ", codCicloIng=" + codCicloIng + " ]";
    }
    
}
