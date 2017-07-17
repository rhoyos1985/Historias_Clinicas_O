/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import com.ricsoft.beans.LoginBeans;
import com.ricsoft.daos.LoginDao;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RCHRDHYSBQR
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest httpServletRequest;
    private LoginBeans loginbean;
    private LoginDao logindao;
    
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
        loginbean = new LoginBeans();
        httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (httpServletRequest.getSession().getAttribute("sessionUsuario") != null) {
            logout(null);
        }
    }

    public LoginBeans getLoginbean() {
        return loginbean;
    }

    public void setLoginbean(LoginBeans loginbean) {
        this.loginbean = loginbean;
    }

     public void Login(ActionEvent e)
    {
        try
        {
            boolean resultado = false;
            FacesMessage fmMensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Inicio de Sesíon!", "Usuario o contraseña incorrecto. Por favor verifique.");
            String stusuario = "";
            logindao = new LoginDao();
            httpServletRequest=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            
            if(loginbean.getStnombreusuario().equalsIgnoreCase("usuariodemo") && loginbean.getStpassword().equalsIgnoreCase("demostracion"))
            {
                stusuario = loginbean.getStnombreusuario();
                fmMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", stusuario);
                resultado = true;
                loginbean.setBoollogueado(resultado);
            }
            else
            {
                resultado = logindao.Login(loginbean);

                if (resultado != false) {
                    stusuario = loginbean.getStnombreusuario();
                    fmMensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", stusuario);
                    loginbean.setBoollogueado(resultado);
                }
            }
            
            FacesContext.getCurrentInstance().addMessage(null, fmMensaje);
            
            if(resultado != false)
            {
                httpServletRequest.getSession().setAttribute("sessionUsuario", stusuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect("pages/seguridad.faces");
            }
            
        } catch (IOException IOex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, IOex.getMessage(), ""));
            
        } catch (Exception ex) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), ""));
        }
    }
    
    public void logout(ActionEvent e) {
        httpServletRequest=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

        try {
            String usuario = httpServletRequest.getSession().getAttribute("sessionUsuario").toString();
            
            FacesMessage fmMensaje=new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hasta pronto!", usuario);
            FacesContext.getCurrentInstance().addMessage(null, fmMensaje);
            
            httpServletRequest.getSession().removeAttribute("sessionUsuario");
            
            ((HttpSession) ctx.getSession(false)).invalidate();
            ctx.redirect(ctxPath); // Redirección de nuevo con el contexto de JSF,
            loginbean.setBoollogueado(false);
        } catch (IOException ex) {
            
        }
    }
}
