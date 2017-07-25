/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.ss;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "SS_PERFIL_X_ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsPerfilXAlumno.findAll", query = "SELECT s FROM SsPerfilXAlumno s")})
public class SsPerfilXAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SsPerfilXAlumnoPK ssPerfilXAlumnoPK;

    public SsPerfilXAlumno() {
    }

    public SsPerfilXAlumno(SsPerfilXAlumnoPK ssPerfilXAlumnoPK) {
        this.ssPerfilXAlumnoPK = ssPerfilXAlumnoPK;
    }

    public SsPerfilXAlumno(String codPerfil, String carne) {
        this.ssPerfilXAlumnoPK = new SsPerfilXAlumnoPK(codPerfil, carne);
    }

    public SsPerfilXAlumnoPK getSsPerfilXAlumnoPK() {
        return ssPerfilXAlumnoPK;
    }

    public void setSsPerfilXAlumnoPK(SsPerfilXAlumnoPK ssPerfilXAlumnoPK) {
        this.ssPerfilXAlumnoPK = ssPerfilXAlumnoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssPerfilXAlumnoPK != null ? ssPerfilXAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsPerfilXAlumno)) {
            return false;
        }
        SsPerfilXAlumno other = (SsPerfilXAlumno) object;
        if ((this.ssPerfilXAlumnoPK == null && other.ssPerfilXAlumnoPK != null) || (this.ssPerfilXAlumnoPK != null && !this.ssPerfilXAlumnoPK.equals(other.ssPerfilXAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.ss.SsPerfilXAlumno[ ssPerfilXAlumnoPK=" + ssPerfilXAlumnoPK + " ]";
    }
    
}
