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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Size(max = 32)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 80)
    @Column(name = "NBR_USUARIO")
    private String nbrUsuario;
    @Column(name = "ASOCIADO_A")
    private Character asociadoA;
    @Size(max = 4)
    @Column(name = "COD_ENTIDAD_ASOCIADA")
    private String codEntidadAsociada;
    @Column(name = "ESTADO")
    private Character estado;
    @Column(name = "FECHA_EXPIRACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpiracion;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Perfil> perfilList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Materia> materiaList;

    public Usuario() {
    }

    public Usuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNbrUsuario() {
        return nbrUsuario;
    }

    public void setNbrUsuario(String nbrUsuario) {
        this.nbrUsuario = nbrUsuario;
    }

    public Character getAsociadoA() {
        return asociadoA;
    }

    public void setAsociadoA(Character asociadoA) {
        this.asociadoA = asociadoA;
    }

    public String getCodEntidadAsociada() {
        return codEntidadAsociada;
    }

    public void setCodEntidadAsociada(String codEntidadAsociada) {
        this.codEntidadAsociada = codEntidadAsociada;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @XmlTransient
    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.edu.sv.bd.Usuario[ codUsuario=" + codUsuario + " ]";
    }

}
