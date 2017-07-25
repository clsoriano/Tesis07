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
@Table(name = "CSS_SEQUENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CssSequencia.findAll", query = "SELECT c FROM CssSequencia c")})
public class CssSequencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NBR_SEQ")
    private String nbrSeq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_SEQ")
    private int valorSeq;

    public CssSequencia() {
    }

    public CssSequencia(String nbrSeq) {
        this.nbrSeq = nbrSeq;
    }

    public CssSequencia(String nbrSeq, int valorSeq) {
        this.nbrSeq = nbrSeq;
        this.valorSeq = valorSeq;
    }

    public String getNbrSeq() {
        return nbrSeq;
    }

    public void setNbrSeq(String nbrSeq) {
        this.nbrSeq = nbrSeq;
    }

    public int getValorSeq() {
        return valorSeq;
    }

    public void setValorSeq(int valorSeq) {
        this.valorSeq = valorSeq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nbrSeq != null ? nbrSeq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CssSequencia)) {
            return false;
        }
        CssSequencia other = (CssSequencia) object;
        if ((this.nbrSeq == null && other.nbrSeq != null) || (this.nbrSeq != null && !this.nbrSeq.equals(other.nbrSeq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.CssSequencia[ nbrSeq=" + nbrSeq + " ]";
    }
    
}
