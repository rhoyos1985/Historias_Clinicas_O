/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.interfaces;

import com.ricsoft.beans.EpsBeans;
import java.util.List;

/**
 *
 * @author Monterroza
 */
public interface EpsInterface {
    
    /**
     *
     * @param epsbeans
     * @return
     * @throws Exception
     */
    public boolean InsertarEps(EpsBeans epsbeans)throws Exception;
    public List<EpsBeans> CosultarTodosEps(EpsBeans epsbeans)throws Exception;
    public EpsBeans ConsultarPerfilId(List<EpsBeans> lsteps, int ideps)throws Exception;
    public boolean ActualizarEps(EpsBeans epsbeans)throws Exception;
    public boolean EliminarEps(int ideps)throws Exception;
}
