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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoPK proyectoPK;
    @Size(max = 100)
    @Column(name = "NBR_PROYECTO")
    private String nbrProyecto;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 7)
    @Column(name = "COD_COORDINADOR")
    private String codCoordinador;
    @Size(max = 80)
    @Column(name = "NBR_RESPONSABLE")
    private String nbrResponsable;
    @Size(max = 8)
    @Column(name = "TELEFONO_RESPONSABLE")
    private String telefonoResponsable;
    @Column(name = "EXT_RESPONSABLE")
    private Integer extResponsable;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO_RESP")
    private String correoElectronicoResp;
    @Column(name = "NUM_ALUMNOS_SOLICITADOS")
    private Integer numAlumnosSolicitados;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Character estado;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUBLICAR")
    private boolean publicar;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<SolicitudParticipacion> solicitudParticipacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<HsXProyecto> hsXProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<SeguimientoProyecto> seguimientoProyectoList;
    @JoinColumn(name = "COD_INSTITUCION", referencedColumnName = "COD_INSTITUCION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Institucion institucion;
    @JoinColumns({
        @JoinColumn(name = "COD_DEPARTAMENTO", referencedColumnName = "COD_DEPARTAMENTO")
        , @JoinColumn(name = "COD_MUNICIPIO", referencedColumnName = "COD_MUNICIPIO")})
    @ManyToOne
    private Municipio municipio;
    @JoinColumn(name = "AREA", referencedColumnName = "COD_SERVICIO")
    @ManyToOne
    private Servicios area;
    @JoinColumn(name = "COD_TIPO_PROYECTO", referencedColumnName = "COD_TIPO_PROYECTO")
    @ManyToOne
    private TipoProyecto codTipoProyecto;

    public Proyecto() {
    }

    public Proyecto(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public Proyecto(ProyectoPK proyectoPK, boolean publicar, String modificadoPor, Date fechaModificacion) {
        this.proyectoPK = proyectoPK;
        this.publicar = publicar;
        this.modificadoPor = modificadoPor;
        this.fechaModificacion = fechaModificacion;
    }

    public Proyecto(int codInstitucion, int corrProyecto) {
        this.proyectoPK = new ProyectoPK(codInstitucion, corrProyecto);
    }

    public ProyectoPK getProyectoPK() {
        return proyectoPK;
    }

    public void setProyectoPK(ProyectoPK proyectoPK) {
        this.proyectoPK = proyectoPK;
    }

    public String getNbrProyecto() {
        return nbrProyecto;
    }

    public void setNbrProyecto(String nbrProyecto) {
        this.nbrProyecto = nbrProyecto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(String codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

    public String getNbrResponsable() {
        return nbrResponsable;
    }

    public void setNbrResponsable(String nbrResponsable) {
        this.nbrResponsable = nbrResponsable;
    }

    public String getTelefonoResponsable() {
        return telefonoResponsable;
    }

    public void setTelefonoResponsable(String telefonoResponsable) {
        this.telefonoResponsable = telefonoResponsable;
    }

    public Integer getExtResponsable() {
        return extResponsable;
    }

    public void setExtResponsable(Integer extResponsable) {
        this.extResponsable = extResponsable;
    }

    public String getCorreoElectronicoResp() {
        return correoElectronicoResp;
    }

    public void setCorreoElectronicoResp(String correoElectronicoResp) {
        this.correoElectronicoResp = correoElectronicoResp;
    }

    public Integer getNumAlumnosSolicitados() {
        return numAlumnosSolicitados;
    }

    public void setNumAlumnosSolicitados(Integer numAlumnosSolicitados) {
        this.numAlumnosSolicitados = numAlumnosSolicitados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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

    public boolean getPublicar() {
        return publicar;
    }

    public void setPublicar(boolean publicar) {
        this.publicar = publicar;
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
    public List<SolicitudParticipacion> getSolicitudParticipacionList() {
        return solicitudParticipacionList;
    }

    public void setSolicitudParticipacionList(List<SolicitudParticipacion> solicitudParticipacionList) {
        this.solicitudParticipacionList = solicitudParticipacionList;
    }

    @XmlTransient
    public List<HsXProyecto> getHsXProyectoList() {
        return hsXProyectoList;
    }

    public void setHsXProyectoList(List<HsXProyecto> hsXProyectoList) {
        this.hsXProyectoList = hsXProyectoList;
    }

    @XmlTransient
    public List<SeguimientoProyecto> getSeguimientoProyectoList() {
        return seguimientoProyectoList;
    }

    public void setSeguimientoProyectoList(List<SeguimientoProyecto> seguimientoProyectoList) {
        this.seguimientoProyectoList = seguimientoProyectoList;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Servicios getArea() {
        return area;
    }

    public void setArea(Servicios area) {
        this.area = area;
    }

    public TipoProyecto getCodTipoProyecto() {
        return codTipoProyecto;
    }

    public void setCodTipoProyecto(TipoProyecto codTipoProyecto) {
        this.codTipoProyecto = codTipoProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoPK != null ? proyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoPK == null && other.proyectoPK != null) || (this.proyectoPK != null && !this.proyectoPK.equals(other.proyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Proyecto[ proyectoPK=" + proyectoPK + " ]";
    }
    
}
