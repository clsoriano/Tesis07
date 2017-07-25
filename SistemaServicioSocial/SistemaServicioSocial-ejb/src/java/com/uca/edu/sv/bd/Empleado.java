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
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "COD_EMPLEADO")
    private String codEmpleado;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 30)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESPROFESOR")
    private boolean esprofesor;
    @OneToMany(mappedBy = "codJefe")
    private List<DepartamentoAcademico> departamentoAcademicoList;
    @OneToMany(mappedBy = "codResponsable")
    private List<Unidad> unidadList;
    @OneToMany(mappedBy = "codDecano")
    private List<Facultad> facultadList;
    @OneToMany(mappedBy = "codProfesor")
    private List<MateriaSeccion> materiaSeccionList;

    public Empleado() {
    }

    public Empleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Empleado(String codEmpleado, boolean esprofesor) {
        this.codEmpleado = codEmpleado;
        this.esprofesor = esprofesor;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean getEsprofesor() {
        return esprofesor;
    }

    public void setEsprofesor(boolean esprofesor) {
        this.esprofesor = esprofesor;
    }

    @XmlTransient
    public List<DepartamentoAcademico> getDepartamentoAcademicoList() {
        return departamentoAcademicoList;
    }

    public void setDepartamentoAcademicoList(List<DepartamentoAcademico> departamentoAcademicoList) {
        this.departamentoAcademicoList = departamentoAcademicoList;
    }

    @XmlTransient
    public List<Unidad> getUnidadList() {
        return unidadList;
    }

    public void setUnidadList(List<Unidad> unidadList) {
        this.unidadList = unidadList;
    }

    @XmlTransient
    public List<Facultad> getFacultadList() {
        return facultadList;
    }

    public void setFacultadList(List<Facultad> facultadList) {
        this.facultadList = facultadList;
    }

    @XmlTransient
    public List<MateriaSeccion> getMateriaSeccionList() {
        return materiaSeccionList;
    }

    public void setMateriaSeccionList(List<MateriaSeccion> materiaSeccionList) {
        this.materiaSeccionList = materiaSeccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpleado != null ? codEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codEmpleado == null && other.codEmpleado != null) || (this.codEmpleado != null && !this.codEmpleado.equals(other.codEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Empleado[ codEmpleado=" + codEmpleado + " ]";
    }
    
}
