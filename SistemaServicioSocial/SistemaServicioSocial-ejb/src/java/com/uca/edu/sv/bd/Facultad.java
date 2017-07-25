/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "FACULTAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultad.findAll", query = "SELECT f FROM Facultad f")})
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "COD_FACULTAD")
    private String codFacultad;
    @Size(max = 50)
    @Column(name = "NBR_FACULTAD")
    private String nbrFacultad;
    @Size(max = 5)
    @Column(name = "SIGLAS")
    private String siglas;
    @OneToMany(mappedBy = "codFacultad")
    private List<Carrera> carreraList;
    @JoinColumn(name = "COD_DECANO", referencedColumnName = "COD_EMPLEADO")
    @ManyToOne
    private Empleado codDecano;

    public Facultad() {
    }

    public Facultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getNbrFacultad() {
        return nbrFacultad;
    }

    public void setNbrFacultad(String nbrFacultad) {
        this.nbrFacultad = nbrFacultad;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @XmlTransient
    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
    }

    public Empleado getCodDecano() {
        return codDecano;
    }

    public void setCodDecano(Empleado codDecano) {
        this.codDecano = codDecano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFacultad != null ? codFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.codFacultad == null && other.codFacultad != null) || (this.codFacultad != null && !this.codFacultad.equals(other.codFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Facultad[ codFacultad=" + codFacultad + " ]";
    }
    
}
