/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import java.io.Serializable;
import com.ricsoft.beans.PerfilesBeans;
import com.ricsoft.daos.PerfilesDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author RCHRDHYSBQR
 */
public class PerfilesManagedBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private PerfilesBeans perfilesbeans;
    private List<PerfilesBeans> lstperfiles;
    private PerfilesDao perfilesDao;
    
    /**
     * Creates a new instance of PerfilesManagedBean
     */
    public PerfilesManagedBean() {
        perfilesbeans = new PerfilesBeans();
    }

    public PerfilesBeans getPerfilesbeans() {
        return perfilesbeans;
    }

    public void setPerfilesbeans(PerfilesBeans perfilesbeans) {
        this.perfilesbeans = perfilesbeans;
    }

    public List<PerfilesBeans> getLstperfiles() {
        try
        {
            perfilesDao = new PerfilesDao();
            lstperfiles = perfilesDao.CosultarPerfiles(perfilesbeans);
            return lstperfiles;
        }
        catch(Exception ex)
        {}
        
        return lstperfiles;
    }

    public void PrepararInsertar(ActionEvent e)
    {
        perfilesbeans = new PerfilesBeans();
        RequestContext.getCurrentInstance().update("formagregarperfil:pnlinsertarperfil");
        RequestContext.getCurrentInstance().execute("PF('dlginsertarperfil').show()");
    }
    
    public void InsertarPerfil(ActionEvent e)
    {
        try
        {
            perfilesDao = new PerfilesDao();
            boolean  resultado = perfilesDao.InsertarPerfil(perfilesbeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: El registro fue realizado correctamente", ""));
                RequestContext.getCurrentInstance().update("formagregarperfil:gwlinsertaperfil");
                RequestContext.getCurrentInstance().update("formtableperfil:dtlperfiles");
                RequestContext.getCurrentInstance().execute("PF('dlginsertarperfil').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible guardar el registro.",""));
                RequestContext.getCurrentInstance().update("formagregarperfil:msgsdlgperfiles");
            }
        }
        catch(Exception ex)
        {
            String algo = ex.toString();
            String a = algo;
        }
    }
    
    public void PrepararActualizar(int idperfil)
    {
        try
        {
            perfilesDao = new PerfilesDao();
            perfilesbeans = perfilesDao.ConsultarPerfilId(lstperfiles, idperfil);
            RequestContext.getCurrentInstance().update("formmodificarperfil:pnlmodificarperfil");
            RequestContext.getCurrentInstance().execute("PF('wdvmodificarperfil').show()");
        }
        catch(Exception ex)
        {
        }
    }
    
    public void ActualizarPerfil(ActionEvent e)
    {
        try
        {
            perfilesDao = new PerfilesDao();
            boolean  resultado = perfilesDao.ActualizarPerfil(perfilesbeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: Perfil Actualizado", ""));
                RequestContext.getCurrentInstance().update("formmodificarperfil:gwlmodificarperfil");
                RequestContext.getCurrentInstance().update("formtableperfil:dtlperfiles");
                RequestContext.getCurrentInstance().execute("PF('wdvmodificarperfil').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible actualizar el registro.",""));
                RequestContext.getCurrentInstance().update("formmodificarperfil:msgsdlmodificargperfiles");
            }
        }
        catch(Exception ex)
        {
            
        }
    }
    
    public void EliminarPerfil(int idperfil)
    {
        try
        {
            perfilesDao = new PerfilesDao();
            boolean  resultado = perfilesDao.EliminarPerfil(idperfil);
            
            if(resultado != false)
            {
                RequestContext.getCurrentInstance().update("formtableperfil:dtlperfiles");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: Perfil eliminado", ""));
            }
            else
            {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error: El perfil no fue eliminado", ""));
            }
        }
        catch(Exception ex)
        {
        }
    }
}