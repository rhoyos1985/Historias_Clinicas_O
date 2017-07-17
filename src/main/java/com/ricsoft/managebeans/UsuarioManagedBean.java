/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.ricsoft.beans.UsuarioBeans;
import com.ricsoft.daos.UsuarioDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author RCHRDHYSBQR
 */
@ManagedBean
@SessionScoped
public class UsuarioManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private UsuarioBeans usuariobeans;
    private List<UsuarioBeans> lstusuarios;
    private UsuarioDao usuariodao;

    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
        usuariobeans = new UsuarioBeans();
    }

    public UsuarioBeans getUsuariobeans() {
        return usuariobeans;
    }

    public void setUsuariobeans(UsuarioBeans usuariobeans) {
        this.usuariobeans = usuariobeans;
    }

    public List<UsuarioBeans> getLstusuarios() {
        return lstusuarios;
    }
    
}
