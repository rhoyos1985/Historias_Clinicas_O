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
public class EpsBeans implements Serializable{
    
    private int intID;
    private String stCodigoEps;
    private String stNombreEps;
    private String stDireccionEps;
    private String stBarrioEps;
    private String stCiudadEps;
    private String stPaisEps;
    private String stNITEps;
    private String stTelefono1;
    private String stTelefono2;
    private String stFaxEps;
    private String stCelularEps;
    private String stCorreoEps;
    private String stContactoEps;
    private String stPaginaWebEps;
    private String stObservacionesEps;
    private String stEstado;
    Date stFechaCreacion;
    Date stFechaModificacion;
    
    
    public EpsBeans() {
    }

    public EpsBeans(int intID, String stCodigoEps, String stNombreEps, String stDireccionEps, String stBarrioEps, String stCiudadEps, String stPaisEps, String stNITEps, String stTelefono1, String stTelefono2, String stFaxEps, String stCelularEps, String stCorreoEps, String stContactoEps, String stPaginaWebEps, String stObservacionesEps, String stEstado, Date stFechaCreacion, Date stFechaModificacion) {
        this.intID = intID;
        this.stCodigoEps = stCodigoEps;
        this.stNombreEps = stNombreEps;
        this.stDireccionEps = stDireccionEps;
        this.stBarrioEps = stBarrioEps;
        this.stCiudadEps = stCiudadEps;
        this.stPaisEps = stPaisEps;
        this.stNITEps = stNITEps;
        this.stTelefono1 = stTelefono1;
        this.stTelefono2 = stTelefono2;
        this.stFaxEps = stFaxEps;
        this.stCelularEps = stCelularEps;
        this.stCorreoEps = stCorreoEps;
        this.stContactoEps = stContactoEps;
        this.stPaginaWebEps = stPaginaWebEps;
        this.stObservacionesEps = stObservacionesEps;
        this.stEstado = stEstado;
        this.stFechaCreacion = stFechaCreacion;
        this.stFechaModificacion = stFechaModificacion;
    }

    public int getIntID() {
        return intID;
    }

    public void setIntID(int intID) {
        this.intID = intID;
    }

    public String getStCodigoEps() {
        return stCodigoEps;
    }

    public void setStCodigoEps(String stCodigoEps) {
        this.stCodigoEps = stCodigoEps;
    }

    public String getStNombreEps() {
        return stNombreEps;
    }

    public void setStNombreEps(String stNombreEps) {
        this.stNombreEps = stNombreEps;
    }

    public String getStDireccionEps() {
        return stDireccionEps;
    }

    public void setStDireccionEps(String stDireccionEps) {
        this.stDireccionEps = stDireccionEps;
    }

    public String getStBarrioEps() {
        return stBarrioEps;
    }

    public void setStBarrioEps(String stBarrioEps) {
        this.stBarrioEps = stBarrioEps;
    }

    public String getStCiudadEps() {
        return stCiudadEps;
    }

    public void setStCiudadEps(String stCiudadEps) {
        this.stCiudadEps = stCiudadEps;
    }

    public String getStPaisEps() {
        return stPaisEps;
    }

    public void setStPaisEps(String stPaisEps) {
        this.stPaisEps = stPaisEps;
    }

    public String getStNITEps() {
        return stNITEps;
    }

    public void setStNITEps(String stNITEps) {
        this.stNITEps = stNITEps;
    }

    public String getStTelefono1() {
        return stTelefono1;
    }

    public void setStTelefono1(String stTelefono1) {
        this.stTelefono1 = stTelefono1;
    }

    public String getStTelefono2() {
        return stTelefono2;
    }

    public void setStTelefono2(String stTelefono2) {
        this.stTelefono2 = stTelefono2;
    }

    public String getStFaxEps() {
        return stFaxEps;
    }

    public void setStFaxEps(String stFaxEps) {
        this.stFaxEps = stFaxEps;
    }

    public String getStCelularEps() {
        return stCelularEps;
    }

    public void setStCelularEps(String stCelularEps) {
        this.stCelularEps = stCelularEps;
    }

    public String getStCorreoEps() {
        return stCorreoEps;
    }

    public void setStCorreoEps(String stCorreoEps) {
        this.stCorreoEps = stCorreoEps;
    }

    public String getStContactoEps() {
        return stContactoEps;
    }

    public void setStContactoEps(String stContactoEps) {
        this.stContactoEps = stContactoEps;
    }

    public String getStPaginaWebEps() {
        return stPaginaWebEps;
    }

    public void setStPaginaWebEps(String stPaginaWebEps) {
        this.stPaginaWebEps = stPaginaWebEps;
    }

    public String getStObservacionesEps() {
        return stObservacionesEps;
    }

    public void setStObservacionesEps(String stObservacionesEps) {
        this.stObservacionesEps = stObservacionesEps;
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
