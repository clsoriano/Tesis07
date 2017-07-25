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
public class SemestrePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_CICLO")
    private String codCiclo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_MATERIA")
    private String codMateria;

    public SemestrePK() {
    }

    public SemestrePK(String carne, String codCiclo, String codMateria) {
        this.carne = carne;
        this.codCiclo = codCiclo;
        this.codMateria = codMateria;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carne != null ? carne.hashCode() : 0);
        hash += (codCiclo != null ? codCiclo.hashCode() : 0);
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SemestrePK)) {
            return false;
        }
        SemestrePK other = (SemestrePK) object;
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        if ((this.codCiclo == null && other.codCiclo != null) || (this.codCiclo != null && !this.codCiclo.equals(other.codCiclo))) {
            return false;
        }
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.SemestrePK[ carne=" + carne + ", codCiclo=" + codCiclo + ", codMateria=" + codMateria + " ]";
    }
    
}
