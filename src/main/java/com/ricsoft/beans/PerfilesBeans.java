/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RCHRDHYSBQR
 */
public class PerfilesBeans {
    
    // Variables de los Perfiles
    private int inId;
    
    
    private String stNombre;
    private String stDescripcion;
    private String stEstado;
    private String stUsuarioModificacion;
    private Date dtFechaCreacion;
    private Date dtFechaModificacion;
    private Map<String,String> mpPerfiles ;

    
    public PerfilesBeans(){
    }
    
    public PerfilesBeans(int inId, String stNombre, String stDescripcion, String stEstado, String stUsuarioModificacion, Date dtFechaCreacion, Date dtFechaModificacion, Map<String, String> mpPerfiles) {
        this.inId = inId;
        this.stNombre = stNombre;
        this.stDescripcion = stDescripcion;
        this.stEstado = stEstado;
        this.stUsuarioModificacion = stUsuarioModificacion;
        this.dtFechaCreacion = dtFechaCreacion;
        this.dtFechaModificacion = dtFechaModificacion;
        this.mpPerfiles = mpPerfiles;
    }
    

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public String getStNombre() {
        return stNombre;
    }

    public void setStNombre(String stNombre) {
        this.stNombre = stNombre;
    }

    public String getStDescripcion() {
        return stDescripcion;
    }

    public void setStDescripcion(String stDescripcion) {
        this.stDescripcion = stDescripcion;
    }

    public String getStEstado() {
        return stEstado;
    }

    public void setStEstado(String stEstado) {
        this.stEstado = stEstado;
    }
    
     public String getStUsuarioModificacion() {
        return stUsuarioModificacion;
    }

    public void setStUsuarioModificacion(String stUsuarioModificacion) {
        this.stUsuarioModificacion = stUsuarioModificacion;
    }
    
    public Date getDtFechaCreacion() {
        return dtFechaCreacion;
    }

    public void setDtFechaCreacion(Date dtFechaCreacion) {
        this.dtFechaCreacion = dtFechaCreacion;
    }

    public Date getDtFechaModificacion() {
        return dtFechaModificacion;
    }

    public void setDtFechaModificacion(Date dtFechaModificacion) {
        this.dtFechaModificacion = dtFechaModificacion;
    }

    public Map<String, String> getMpPerfiles() {
        return mpPerfiles;
    }

    public void setMpPerfiles(Map<String, String> mpPerfiles) {
        this.mpPerfiles = mpPerfiles;
    }
    
}
