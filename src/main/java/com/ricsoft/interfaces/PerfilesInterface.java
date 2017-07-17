/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.interfaces;

import com.ricsoft.beans.PerfilesBeans;
import java.util.List;


/**
 *
 * @author RCHRDHYSBQR
 */
public interface PerfilesInterface {
    
    /**
     *
     * @param perfilesbeans
     * @return
     * @throws Exception
     */
    public boolean InsertarPerfil(PerfilesBeans perfilesbeans)throws Exception;
    public List<PerfilesBeans> CosultarPerfiles(PerfilesBeans perfilesbeans)throws Exception;
    public PerfilesBeans ConsultarPerfilId(List<PerfilesBeans> lstperfiles, int idperfil)throws Exception;
    public boolean ActualizarPerfil(PerfilesBeans perfilesbeans)throws Exception;
    public boolean EliminarPerfil(int idperfil)throws Exception;
}
