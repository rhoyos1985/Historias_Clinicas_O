/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;

import com.ricsoft.beans.PerfilesBeans;
import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.interfaces.PerfilesInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author RCHRDHYSBQR
 */
public class PerfilesDao implements  PerfilesInterface{

    @Override
    public boolean InsertarPerfil(PerfilesBeans perfilesbeans) throws Exception {
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
            
        String stnombre = perfilesbeans.getStNombre();
        String stdescripcion = perfilesbeans.getStDescripcion();
        String stusuariomodificacion = perfilesbeans.getStUsuarioModificacion();

        CallableStatement spInsertarPerfiles = conMysql.prepareCall("{call spHC_Perfiles_Insertar(?,?,?)}");

        spInsertarPerfiles.setString(1, stnombre);
        spInsertarPerfiles.setString(2, stdescripcion);
        spInsertarPerfiles.setString(3, stusuariomodificacion);

        boolean resultado = spInsertarPerfiles.execute(); // ejecutar el SP
        
        if (resultado != false)
        {  
           
            ResultSet rs = spInsertarPerfiles.getResultSet();
            rs.next();
                
            int intError = rs.getInt("Numero_Error");
            String st = rs.getString("Descripcion_Error");
            
            if(intError != 0)
            {
                resultado = false;
            }
        }
        
        conMysql.close();
        conMysql=null;
        ConectionMysql.Desconectar();
        
        return resultado;
    }

    @Override
    public List<PerfilesBeans> CosultarPerfiles(PerfilesBeans perfilesbeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        List<PerfilesBeans> listaperfiles = new ArrayList();
        
        CallableStatement paListarPerfiles = conMysql.prepareCall("{call spHC_Perfiles_ConsultarTodos()}");
            
        boolean resultado = paListarPerfiles.execute(); // ejecutar el SP
        
        if (resultado != false) {

            ResultSet rs = paListarPerfiles.getResultSet();
            
            
            while (rs.next()) {
                
                int intId = rs.getInt("ID");
                String StNombre = rs.getString("Nombre");
                String StDescripcion = rs.getString("Descripcion");
                String StEstado = rs.getString("Estado");
                Date DtFechaCreacion = rs.getDate("FechaCreacion");
                Date DtFechaModificacion = rs.getDate("FechaModificacion");
                
                perfilesbeans = new PerfilesBeans(intId, StNombre, StDescripcion, StEstado, StDescripcion, DtFechaCreacion, DtFechaModificacion, null);
                listaperfiles.add(perfilesbeans);
            }
        }

        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();
        
        return listaperfiles;
    }

    @Override
    public PerfilesBeans ConsultarPerfilId(List<PerfilesBeans> lstperfiles, int idperfil) throws Exception {
        
        PerfilesBeans perfilesBeans = new PerfilesBeans();
        
        for(int i=0 ; i < lstperfiles.size() ; i++)
        {
            if(lstperfiles.get(i).getInId() == idperfil)
            {
               perfilesBeans = lstperfiles.get(i);
            }
        }
        return perfilesBeans;
    }

    @Override
    public boolean ActualizarPerfil(PerfilesBeans perfilesbeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paActualizarPerfiles = conMysql.prepareCall("{call spHC_Perfiles_Actualizar(?,?,?,?,?)}");
        
        paActualizarPerfiles.setInt(1, perfilesbeans.getInId());
        paActualizarPerfiles.setString(2, perfilesbeans.getStNombre());
        paActualizarPerfiles.setString(3, perfilesbeans.getStDescripcion());
        paActualizarPerfiles.setString(4, "A");
        paActualizarPerfiles.setInt(5, 0);
        
        boolean resultado = paActualizarPerfiles.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paActualizarPerfiles.getResultSet();
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
    public boolean EliminarPerfil(int idperfil) throws Exception {
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paEliminarPerfil = conMysql.prepareCall("{call spHC_Perfiles_Eliminar(?,?,?)}");
        
        paEliminarPerfil.setInt(1, idperfil);
        paEliminarPerfil.setString(2, "B");
        paEliminarPerfil.setInt(3, 0);
        
        boolean resultado = paEliminarPerfil.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paEliminarPerfil.getResultSet();
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
