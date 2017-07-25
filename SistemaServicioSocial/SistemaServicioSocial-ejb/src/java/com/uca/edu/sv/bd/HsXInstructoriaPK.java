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
public class HsXInstructoriaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "COD_MATERIA")
    private String codMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_CICLO")
    private String codCiclo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "SECCION")
    private String seccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CARNE")
    private String carne;

    public HsXInstructoriaPK() {
    }

    public HsXInstructoriaPK(String codMateria, String codCiclo, String seccion, String carne) {
        this.codMateria = codMateria;
        this.codCiclo = codCiclo;
        this.seccion = seccion;
        this.carne = carne;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        hash += (codCiclo != null ? codCiclo.hashCode() : 0);
        hash += (seccion != null ? seccion.hashCode() : 0);
        hash += (carne != null ? carne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsXInstructoriaPK)) {
            return false;
        }
        HsXInstructoriaPK other = (HsXInstructoriaPK) object;
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        if ((this.codCiclo == null && other.codCiclo != null) || (this.codCiclo != null && !this.codCiclo.equals(other.codCiclo))) {
            return false;
        }
        if ((this.seccion == null && other.seccion != null) || (this.seccion != null && !this.seccion.equals(other.seccion))) {
            return false;
        }
        if ((this.carne == null && other.carne != null) || (this.carne != null && !this.carne.equals(other.carne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.HsXInstructoriaPK[ codMateria=" + codMateria + ", codCiclo=" + codCiclo + ", seccion=" + seccion + ", carne=" + carne + " ]";
    }
    
}
