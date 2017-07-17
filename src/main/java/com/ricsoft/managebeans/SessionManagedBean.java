/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author RCHRDHYSBQR
 */
@ManagedBean
@SessionScoped
public class SessionManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String stusuario = "";
    private final HttpServletRequest httpServletRequest;
    private final FacesContext faceContext;
    
    /**
     * Creates a new instance of SessionManagedBean
     */
    public SessionManagedBean() {
        
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            stusuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
        }
        
    }

    public String getStusuario() {
        return stusuario;
    }

    public void setStusuario(String stusuario) {
        this.stusuario = stusuario;
    }
    
}
