/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.bd;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcsoriano
 */
@Entity
@Table(name = "CICLO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclo.findAll", query = "SELECT c FROM Ciclo c")})
public class Ciclo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_CICLO")
    private String codCiclo;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "ESTADO")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MODIFICADO_POR")
    private String modificadoPor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
    private List<Semestre> semestreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
    private List<Expediente> expedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
    private List<MateriaSeccion> materiaSeccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
    private List<HistoriaCarrera> historiaCarreraList;

    public Ciclo() {
    }

    public Ciclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public Ciclo(String codCiclo, String modificadoPor, Date fechaModificacion) {
        this.codCiclo = codCiclo;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public String getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(String codCiclo) {
        this.codCiclo = codCiclo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<Semestre> getSemestreList() {
        return semestreList;
    }

    public void setSemestreList(List<Semestre> semestreList) {
        this.semestreList = semestreList;
    }

    @XmlTransient
    public List<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(List<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }

    @XmlTransient
    public List<MateriaSeccion> getMateriaSeccionList() {
        return materiaSeccionList;
    }

    public void setMateriaSeccionList(List<MateriaSeccion> materiaSeccionList) {
        this.materiaSeccionList = materiaSeccionList;
    }

    @XmlTransient
    public List<HistoriaCarrera> getHistoriaCarreraList() {
        return historiaCarreraList;
    }

    public void setHistoriaCarreraList(List<HistoriaCarrera> historiaCarreraList) {
        this.historiaCarreraList = historiaCarreraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiclo != null ? codCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.codCiclo == null && other.codCiclo != null) || (this.codCiclo != null && !this.codCiclo.equals(other.codCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Ciclo[ codCiclo=" + codCiclo + " ]";
    }
    
}
