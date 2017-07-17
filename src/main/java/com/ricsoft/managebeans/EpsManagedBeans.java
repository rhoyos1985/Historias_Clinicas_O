/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import com.ricsoft.beans.EpsBeans;
import com.ricsoft.daos.EpsDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Monterroza
 */
@ManagedBean(name="epsmanagedbeans")
@SessionScoped
public class EpsManagedBeans {
    
    private static final long serialVersionUID = 1L;
    private EpsBeans epsbeans;
    private List<EpsBeans> lsteps;
    private EpsDao epsDao;
    
    /**
     * Creates a new instance of EpsManagedBeans
     */   
    public EpsManagedBeans() {
        epsbeans=new EpsBeans();
    }

    public EpsBeans getEpsbeans() {
        return epsbeans;
    }

    public void setEpsbeans(EpsBeans epsbeans) {
        this.epsbeans = epsbeans;
    }

    public List<EpsBeans> getLsteps() {
        try
        {
            epsDao = new EpsDao();
            lsteps = epsDao.CosultarTodosEps(epsbeans);
            return lsteps;
        }
        catch(Exception ex)
        {}
        
        return lsteps;
    }

    public void setLsteps(List<EpsBeans> lsteps) {
        this.lsteps = lsteps;
    }

   
     public void PrepararInsertar(ActionEvent e)
    {
        epsbeans = new EpsBeans();
        RequestContext.getCurrentInstance().update("formagregareps:pnlinsertareps");
        RequestContext.getCurrentInstance().execute("PF('dlginsertareps').show()");
    }
          
    
    public void InsertarEps(ActionEvent e) 
    {
        try
        {
            epsDao = new EpsDao();
            boolean  resultado = epsDao.InsertarEps(epsbeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: El registro fue realizado correctamente", ""));
                RequestContext.getCurrentInstance().update("formagregareps:gwlinsertaeps");
                RequestContext.getCurrentInstance().update("formtableeps:dtlepss");
                RequestContext.getCurrentInstance().execute("PF('dlginsertareps').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible guardar el registro.",""));
                RequestContext.getCurrentInstance().update("formagregareps:msgsdlgepss");
            }
        }
        catch(Exception ex)
        {
            String algo = ex.toString();
            String a = algo;
        }
    }
    
    public void PrepararActualizar(int ideps)
    {
        try
        {
            epsDao = new EpsDao();
            epsbeans = epsDao.ConsultarPerfilId(lsteps, ideps);
            RequestContext.getCurrentInstance().update("formmodificareps:pnlmodificarepss");
            RequestContext.getCurrentInstance().update("formmodificareps:pnlmodificarepss2");
            RequestContext.getCurrentInstance().execute("PF('wdvmodificareps').show()");
        }
        catch(Exception ex)
        {
        }
    }
    
    
    public void ActualizarEps(ActionEvent e)
    {
        try
        {
            epsDao = new EpsDao();
            boolean  resultado = epsDao.ActualizarEps(epsbeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: Eps Actualizada", ""));
                RequestContext.getCurrentInstance().update("formmodificareps:gwlmodificarepss");
                RequestContext.getCurrentInstance().update("formtableeps:dtlepss");
                RequestContext.getCurrentInstance().execute("PF('wdvmodificareps').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible actualizar el registro.",""));
                RequestContext.getCurrentInstance().update("formmodificareps:msgsdlmodificargepss");
            }
        }
        catch(Exception ex)
        {
            
        }
    } 
    
    
    public void EliminarEps(int ideps)
    {
        try
        {
            epsDao = new EpsDao();
            boolean  resultado = epsDao.EliminarEps(ideps);
            
            if(resultado != false)
            {
                RequestContext.getCurrentInstance().update("formtableeps:dtlepss");
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
