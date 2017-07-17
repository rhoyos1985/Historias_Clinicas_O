/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.interfaces;

import com.ricsoft.beans.ClinicaBeans;
import java.util.List;

/**
 *
 * @author Monterroza
 */
public interface ClinicaInterface {
    
     /**
     *
     * @param clinicabeans
     * @return
     * @throws Exception
     */
    public boolean InsertarClinica(ClinicaBeans clinicabeans)throws Exception;
    public List<ClinicaBeans> CosultarClinicas(ClinicaBeans clinicabeans)throws Exception;
    public ClinicaBeans ConsultarClinicaId(List<ClinicaBeans> lstclinica, int idclinica)throws Exception;
    public boolean ActualizarClinica(ClinicaBeans clinicabeans)throws Exception;
    public boolean EliminarClinica(int idclinica)throws Exception;
}
