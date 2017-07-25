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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "INSTITUCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i")})
public class Institucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_INSTITUCION")
    private Integer codInstitucion;
    @Size(max = 100)
    @Column(name = "NBR_INSTITUCION")
    private String nbrInstitucion;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 8)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 8)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 100)
    @Column(name = "NBR_CONTACTO")
    private String nbrContacto;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
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
    @Size(max = 10)
    @Column(name = "COD_INSTITUCION_RA")
    private String codInstitucionRa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    private List<HsXEquivalencia> hsXEquivalenciaList;
    @OneToMany(mappedBy = "institucion")
    private List<HsXPracticaDocente> hsXPracticaDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    private List<Proyecto> proyectoList;
    @JoinColumns({
        @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO")
        , @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO")})
    @ManyToOne
    private Municipio municipio;
    @JoinColumn(name = "COD_PAIS", referencedColumnName = "COD_PAIS")
    @ManyToOne
    private Pais codPais;
    @JoinColumn(name = "CORR_TIPO_INSTITUCION", referencedColumnName = "CORR_TIPO_INSTITUCION")
    @ManyToOne
    private TipoInstitucion corrTipoInstitucion;

    public Institucion() {
    }

    public Institucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public Institucion(Integer codInstitucion, String modificadoPor, Date fechaModificacion) {
        this.codInstitucion = codInstitucion;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(Integer codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    public String getNbrInstitucion() {
        return nbrInstitucion;
    }

    public void setNbrInstitucion(String nbrInstitucion) {
        this.nbrInstitucion = nbrInstitucion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNbrContacto() {
        return nbrContacto;
    }

    public void setNbrContacto(String nbrContacto) {
        this.nbrContacto = nbrContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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

    public String getCodInstitucionRa() {
        return codInstitucionRa;
    }

    public void setCodInstitucionRa(String codInstitucionRa) {
        this.codInstitucionRa = codInstitucionRa;
    }

    @XmlTransient
    public List<HsXEquivalencia> getHsXEquivalenciaList() {
        return hsXEquivalenciaList;
    }

    public void setHsXEquivalenciaList(List<HsXEquivalencia> hsXEquivalenciaList) {
        this.hsXEquivalenciaList = hsXEquivalenciaList;
    }

    @XmlTransient
    public List<HsXPracticaDocente> getHsXPracticaDocenteList() {
        return hsXPracticaDocenteList;
    }

    public void setHsXPracticaDocenteList(List<HsXPracticaDocente> hsXPracticaDocenteList) {
        this.hsXPracticaDocenteList = hsXPracticaDocenteList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Pais getCodPais() {
        return codPais;
    }

    public void setCodPais(Pais codPais) {
        this.codPais = codPais;
    }

    public TipoInstitucion getCorrTipoInstitucion() {
        return corrTipoInstitucion;
    }

    public void setCorrTipoInstitucion(TipoInstitucion corrTipoInstitucion) {
        this.corrTipoInstitucion = corrTipoInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstitucion != null ? codInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.codInstitucion == null && other.codInstitucion != null) || (this.codInstitucion != null && !this.codInstitucion.equals(other.codInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Institucion[ codInstitucion=" + codInstitucion + " ]";
    }
    
}
