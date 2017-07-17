/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.managebeans;

import com.ricsoft.beans.ClinicaBeans;
import com.ricsoft.daos.ClinicaDao;
import java.io.Serializable;
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
@ManagedBean(name="clinicamanagedbeans")
@SessionScoped
public class ClinicaManagedBeans implements Serializable{

    private static final long serialVersionUID = 1L;
    private ClinicaBeans clinicabeans;
    private List<ClinicaBeans> lstclinicas;
    private ClinicaDao clinicasDao;
    
    /**
     * Creates a new instance of ClinicaManagedBeans
     */
    public ClinicaManagedBeans() {
        ClinicaBeans clinicaBeans = new ClinicaBeans();
    }

    public ClinicaBeans getClinicabeans() {
        return clinicabeans;
    }

    public void setClinicabeans(ClinicaBeans clinicabeans) {
        this.clinicabeans = clinicabeans;
    }

    public List<ClinicaBeans> getLstclinicas() {
        try
        {
            clinicasDao = new ClinicaDao();
            lstclinicas = clinicasDao.CosultarClinicas(clinicabeans);
            return lstclinicas;
        }
        catch(Exception ex)
        {}
        
        return lstclinicas;
    }

    public void setLstclinicas(List<ClinicaBeans> lstclinicas) {
        this.lstclinicas = lstclinicas;
    }
    
     public void PrepararInsertar(ActionEvent e)
    {
        clinicabeans = new ClinicaBeans();
        RequestContext.getCurrentInstance().update("formagregarclinica:pnlinsertarclinica");
        RequestContext.getCurrentInstance().execute("PF('dlginsertarclinica').show()");
    }
       
    
    
    
    public void InsertarClinca(ActionEvent e) 
    {
        try
        {
            clinicasDao = new ClinicaDao();
            boolean  resultado = clinicasDao.InsertarClinica(clinicabeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: El registro fue realizado correctamente", ""));
                RequestContext.getCurrentInstance().update("formagregarclinica:gwlinsertaclinica");
                RequestContext.getCurrentInstance().update("formtableclinica:dtlclinicas");
                RequestContext.getCurrentInstance().execute("PF('dlginsertarclinica').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible guardar el registro.",""));
                RequestContext.getCurrentInstance().update("formagregarclinica:msgsdlgclinicas");
            }
        }
        catch(Exception ex)
        {
            String algo = ex.toString();
            String a = algo;
        }
    }
    
    
        public void PrepararActualizar(int idclinica)
    {
        try
        {
            clinicasDao = new ClinicaDao();
            clinicabeans = clinicasDao.ConsultarClinicaId(lstclinicas, idclinica);
            RequestContext.getCurrentInstance().update("formmodificarclinica:pnlmodificarclinicas");
            RequestContext.getCurrentInstance().execute("PF('wdvmodificarclinica').show()");
        }
        catch(Exception ex)
        {
        }
    }
        
        
    public void ActualizarClinica(ActionEvent e)
    {
        try
        {
            clinicasDao = new ClinicaDao();
            boolean  resultado = clinicasDao.ActualizarClinica(clinicabeans);
            
            if(resultado != false)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto: Clinica Actualizada", ""));
                RequestContext.getCurrentInstance().update("formmodificarclinica:gwlmodificarclinicas");
                RequestContext.getCurrentInstance().update("formtableclinica:dtlclinicas");
                RequestContext.getCurrentInstance().execute("PF('wdvmodificarclinica').hide()");
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: No fue posible actualizar el registro.",""));
                RequestContext.getCurrentInstance().update("formmodificarclinica:msgsdlmodificargclinicas");
            }
        }
        catch(Exception ex)
        {
            
        }
    } 
    
    
        public void EliminarClinica(int idclinica)
    {
        try
        {
            clinicasDao = new ClinicaDao();
            boolean  resultado = clinicasDao.EliminarClinica(idclinica);
            
            if(resultado != false)
            {
                RequestContext.getCurrentInstance().update("formtableclinica:dtlclinicas");
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
