/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.managedBean;

import com.uca.edu.sv.bd.GrupoInstitucion;
import com.uca.edu.sv.bd.TipoInstitucion;
import com.uca.edu.sv.controller.Controller;
import com.uca.edu.sv.facade.GrupoInstitucionFacade;
import com.uca.edu.sv.facade.TipoInstitucionFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author jcsoriano
 */
@Controller
public class GrupoTipoInstitucionController implements Serializable {

    private static final Logger LOG = Logger.getLogger(GrupoTipoInstitucionController.class.getName());

    @Inject
    private GrupoInstitucionFacade grupoInstitucionFacade;
    @Inject
    private TipoInstitucionFacade tipoInstitucionFacade;
    private GrupoInstitucion grupoInstitucion;
    private TipoInstitucion tipoInstitucion;
    private List<GrupoInstitucion> grupoInstitucionList;
    private List<TipoInstitucion> tipoInstitucionList;
    private boolean isEditGrupo;
    private boolean isEditTipo;

    @PostConstruct
    public void _init() {
        grupoInstitucion = new GrupoInstitucion();
        tipoInstitucion = new TipoInstitucion();
    }

    public GrupoInstitucion getGrupoInstitucion() {
        return grupoInstitucion;
    }

    public void setGrupoInstitucion(GrupoInstitucion grupoInstitucion) {
        this.grupoInstitucion = grupoInstitucion;
    }

    public TipoInstitucion getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public boolean isIsEditGrupo() {
        return isEditGrupo;
    }

    public void setIsEditGrupo(boolean isEditGrupo) {
        this.isEditGrupo = isEditGrupo;
    }

    public boolean isIsEditTipo() {
        return isEditTipo;
    }

    public void setIsEditTipo(boolean isEditTipo) {
        this.isEditTipo = isEditTipo;
    }

    public void setSelectedGrupoInstitucion(GrupoInstitucion grupoInstitucion) {
        isEditGrupo = true;
        //buscar los tipos de institucion por grupo
        this.grupoInstitucion = grupoInstitucion;
    }

    public void newGrupoInstitucion() {
        grupoInstitucion = new GrupoInstitucion();
    }

    public void saveGrupoInstitucion() {
        try {
            if (!isEditGrupo) {
                grupoInstitucionFacade.create(grupoInstitucion);
            } else {
                grupoInstitucionFacade.edit(grupoInstitucion);
            }
        } catch (Exception ex) {
            LOG.log(Level.INFO, "Ocurrio un error almacenando grupo", ex);
        }
    }

    public void removeGrupoInstitucion() {
        try {
            grupoInstitucionFacade.remove(grupoInstitucion);
        } catch (Exception ex) {
            LOG.log(Level.INFO, "Ocurrio un error eliminando grupo", ex);
        }
    }

    public void setSelectedTipoInstitucion(TipoInstitucion tipoInstitucion) {
        isEditTipo = true;
        this.tipoInstitucion = tipoInstitucion;
    }

    public void newTipoInstitucion() {
        tipoInstitucion = new TipoInstitucion();
    }

    public void saveTipoInstitucion() {
        try {
            if (!isEditTipo) {
                tipoInstitucionFacade.create(tipoInstitucion);
            } else {
                tipoInstitucionFacade.edit(tipoInstitucion);
            }
        } catch (Exception ex) {
            LOG.log(Level.INFO, "Ocurrio un error almacenando tipo", ex);
        }
    }

    public void removeTipoInstitucion() {
        try {
            tipoInstitucionFacade.remove(tipoInstitucion);
        } catch (Exception ex) {
            LOG.log(Level.INFO, "Ocurrio un error eliminando tipo", ex);
        }
    }

    public List<GrupoInstitucion> getGrupoInstitucionList() {
        return grupoInstitucionFacade.findAll();
    }

    public void setGrupoInstitucionList(List<GrupoInstitucion> grupoInstitucionList) {
        this.grupoInstitucionList = grupoInstitucionList;
    }

    public List<TipoInstitucion> getTipoInstitucionList() {
        return grupoInstitucion.getTipoInstitucionList();
    }

    public void setTipoInstitucionList(List<TipoInstitucion> tipoInstitucionList) {
        this.tipoInstitucionList = tipoInstitucionList;
    }

}
