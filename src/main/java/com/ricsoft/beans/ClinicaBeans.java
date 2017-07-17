/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricsoft.beans;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Monterroza
 */
public class ClinicaBeans implements Serializable{
    private int intID;
    private String stCodigo;
    private String stNombre;
    private String stDescripcion;
    private String stEstado;
    private Date stFechaCreacion;
    private Date stFechaModificacion;

    public ClinicaBeans() {
    }

    public ClinicaBeans(int intID, String stCodigo, String stNombre, String stDescripcion, String stEstado, Date stFechaCreacion, Date stFechaModificacion) {
        this.intID = intID;
        this.stCodigo = stCodigo;
        this.stNombre = stNombre;
        this.stDescripcion = stDescripcion;
        this.stEstado = stEstado;
        this.stFechaCreacion = stFechaCreacion;
        this.stFechaModificacion = stFechaModificacion;
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int stID) {
        this.intID = stID;
    }

    public String getStCodigo() {
        return stCodigo;
    }

    public void setStCodigo(String stCodigo) {
        this.stCodigo = stCodigo;
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

    public Date getStFechaCreacion() {
        return stFechaCreacion;
    }

    public void setStFechaCreacion(Date stFechaCreacion) {
        this.stFechaCreacion = stFechaCreacion;
    }

    public Date getStFechaModificacion() {
        return stFechaModificacion;
    }

    public void setStFechaModificacion(Date stFechaModificacion) {
        this.stFechaModificacion = stFechaModificacion;
    }



}
