/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;

import com.ricsoft.beans.ClinicaBeans;
import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.interfaces.ClinicaInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Monterroza
 */
public class ClinicaDao implements ClinicaInterface{
    
    @Override
    public boolean InsertarClinica(ClinicaBeans clinicabeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos

        String stcodigo = clinicabeans.getStCodigo();
        String stnombre = clinicabeans.getStNombre();
        String stdescripcion = clinicabeans.getStDescripcion();
        

        CallableStatement spInsertarClinica = conMysql.prepareCall("{call spHC_Clinica_Insertar(?,?,?,?)}");

        spInsertarClinica.setString(1, stcodigo);
        spInsertarClinica.setString(2, stnombre);            
        spInsertarClinica.setString(3, stdescripcion);
        spInsertarClinica.setString(4, "0");

        boolean resultado = spInsertarClinica.execute(); // ejecutar el SP

        return resultado;
    }

    @Override
    public boolean ActualizarClinica(ClinicaBeans clinicabeans) throws Exception {
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paActualizarClinicas = conMysql.prepareCall("{call spHC_Clinica_Actualizar(?,?,?,?,?)}");
        
        paActualizarClinicas.setString(1, clinicabeans.getStCodigo());
        paActualizarClinicas.setString(2, clinicabeans.getStNombre());
        paActualizarClinicas.setString(3, clinicabeans.getStDescripcion());
        paActualizarClinicas.setString(4, "A");
        paActualizarClinicas.setInt(5, 0);
        
        boolean resultado = paActualizarClinicas.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paActualizarClinicas.getResultSet();
            rs.next();
                
            int intError = rs.getInt("Numero_Error");
            String st = rs.getString("Descripcion_Error");
            
            if(intError != 0)
            {
                resultado = false;
            }
        }
        
        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();
        
        return resultado;
    }

    
    @Override
    public List<ClinicaBeans> CosultarClinicas(ClinicaBeans clinicabeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        List<ClinicaBeans> listaclinicas = new ArrayList();
        
        CallableStatement paListarClinicas = conMysql.prepareCall("{call spHC_Clinica_ConsultarTodos()}");
            
        boolean resultado = paListarClinicas.execute(); // ejecutar el SP
        
        if (resultado != false) {

            ResultSet rs = paListarClinicas.getResultSet();
            
            
            while (rs.next()) {
                
                int intId = rs.getInt("IDClinica");
                String StCodigo = rs.getString("CodigoClinica");
                String StNombre = rs.getString("Clinica");
                String StDescripcion = rs.getString("DescripcionClinica");
                String StEstado = rs.getString("EstadoClinica");
                Date DtFechaCreacion = rs.getDate("FechaCreacionClinica");
                Date DtFechaModificacion = rs.getDate("FechaModificClinica");
                
                clinicabeans = new ClinicaBeans(intId, StCodigo, StNombre, StDescripcion, StEstado, DtFechaCreacion, DtFechaModificacion);
                listaclinicas.add(clinicabeans);
            }
        }

        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();
        
        return listaclinicas;
    }

    @Override
    public ClinicaBeans ConsultarClinicaId(List<ClinicaBeans> lstclinica, int idclinica) throws Exception {
        
        ClinicaBeans clinicabeans = new ClinicaBeans();
        
        for(int i=0 ; i < lstclinica.size() ; i++)
        {
            if(lstclinica.get(i).getIntID() == idclinica)
            {
               clinicabeans = lstclinica.get(i);
            }
        }
        return clinicabeans;
    }

    @Override
    public boolean EliminarClinica(int idclinica) throws Exception {
         Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paEliminarClinica = conMysql.prepareCall("{call spHC_Clinica_Eliminar(?,?,?)}");
        
        paEliminarClinica.setInt(1, idclinica);
        paEliminarClinica.setString(2, "B");
        paEliminarClinica.setInt(3, 0);
        
        boolean resultado = paEliminarClinica.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paEliminarClinica.getResultSet();
            rs.next();
            
            int intError = rs.getInt("Numero_Error");
            String st = rs.getString("Descripcion_Error");
            
            if(intError != 0)
            {
                resultado = false;
            }
        }
        
        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();
        
        return resultado;
    }
    
}
