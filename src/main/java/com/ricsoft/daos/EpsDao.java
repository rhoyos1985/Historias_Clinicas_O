/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;

import com.ricsoft.beans.EpsBeans;
import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.interfaces.EpsInterface;
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
public class EpsDao implements EpsInterface{

    @Override
    public List<EpsBeans> CosultarTodosEps(EpsBeans epsbeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        List<EpsBeans> listaEps= new ArrayList();        
        CallableStatement paListarEps = conMysql.prepareCall("{call spHC_Eps_ConsultarTodos()}");
        boolean resultado = paListarEps.execute(); // ejecutar el SP
        
        if (resultado != false) {

            ResultSet rs = paListarEps.getResultSet();            
            
            while (rs.next()) {
                
                int intId = rs.getInt("ID_Eps");
                String StCodigo = rs.getString("CodigoEps");
                String StNombre = rs.getString("NombreEps");
                String StDireccion = rs.getString("DireccionEps");
                String StBarrio = rs.getString("BarrioEps");
                String StCiudad = rs.getString("CiudadEps");
                String StPais = rs.getString("PaisEps");
                String StNit = rs.getString("NitEps");
                String StTelefono1 = rs.getString("Telefono1Eps");
                String StTelefono2 = rs.getString("Telefono2Eps");
                String StFax = rs.getString("FaxEps");
                String StCelular = rs.getString("CelularEps");
                String StCorreo = rs.getString("CorreoEps");
                String StContacto = rs.getString("PersonaContactoEps");
                String StPagWeb = rs.getString("PaginaWebEps");
                String StObservaciones = rs.getString("ObservacionesEps");
                String StEstado = rs.getString("EstadoEps");
                Date DtFechaCreacion = rs.getDate("FechaCreacionEps");
                Date DtFechaModificacion = rs.getDate("FechaModificacionEps");
                
                epsbeans = new EpsBeans(intId, StCodigo, StNombre, StDireccion, StBarrio, StCiudad, StPais, StNit, StTelefono1, StTelefono2, StFax, StCelular, StCorreo, StContacto, StPagWeb, StObservaciones, StEstado, DtFechaCreacion, DtFechaModificacion);
                listaEps.add(epsbeans);
            }
        }

        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();
        
        return listaEps;
    }

    @Override
    public boolean InsertarEps(EpsBeans epsbeans) throws Exception {
        
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        String stcodigo = epsbeans.getStCodigoEps();
        String stnombre = epsbeans.getStNombreEps();
        String stdireccion = epsbeans.getStDireccionEps();
        String stbarrio = epsbeans.getStBarrioEps();
        String stciudad = epsbeans.getStCiudadEps();
        String stpais = epsbeans.getStPaisEps();
        String stnit = epsbeans.getStNITEps();
        String sttelefono1 = epsbeans.getStTelefono1();
        String sttelefono2 = epsbeans.getStTelefono2();
        String stfax = epsbeans.getStFaxEps();
        String stcelular = epsbeans.getStCelularEps();
        String stcorreo = epsbeans.getStCorreoEps();
        String stcontacto = epsbeans.getStContactoEps();
        String stpagweb = epsbeans.getStPaginaWebEps();
        String stobservaciones = epsbeans.getStObservacionesEps();
        int stusuariomodifica = 0; 
        
        CallableStatement spInsertarEps = conMysql.prepareCall("{call spHC_Eps_Insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

        spInsertarEps.setString(1, stcodigo);
        spInsertarEps.setString(2, stnombre);            
        spInsertarEps.setString(3, stdireccion);
        spInsertarEps.setString(4, stbarrio);
        spInsertarEps.setString(5, stciudad);            
        spInsertarEps.setString(6, stpais);
        spInsertarEps.setString(7, stnit);
        spInsertarEps.setString(8, sttelefono1);            
        spInsertarEps.setString(9, sttelefono2);
        spInsertarEps.setString(10, stfax);
        spInsertarEps.setString(11, stcelular);            
        spInsertarEps.setString(12, stcorreo);
        spInsertarEps.setString(13, stcontacto);
        spInsertarEps.setString(14, stpagweb);            
        spInsertarEps.setString(15, stobservaciones);
        spInsertarEps.setString(16, "A");
        spInsertarEps.setInt(17, stusuariomodifica);


        boolean resultado = spInsertarEps.execute(); // ejecutar el SP

        return resultado;
    }

    @Override
    public boolean ActualizarEps(EpsBeans epsbeans) throws Exception {
         Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paActualizarEps = conMysql.prepareCall("{call spHC_Eps_Actualizar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        
        paActualizarEps.setString(1, epsbeans.getStCodigoEps());
        paActualizarEps.setString(2, epsbeans.getStNombreEps());
        paActualizarEps.setString(3, epsbeans.getStDireccionEps());
        paActualizarEps.setString(4, epsbeans.getStBarrioEps());
        paActualizarEps.setString(5, epsbeans.getStCiudadEps());
        paActualizarEps.setString(6, epsbeans.getStPaisEps());
        paActualizarEps.setString(7, epsbeans.getStNITEps());
        paActualizarEps.setString(8, epsbeans.getStTelefono1());
        paActualizarEps.setString(9, epsbeans.getStTelefono2());
        paActualizarEps.setString(10, epsbeans.getStFaxEps());
        paActualizarEps.setString(11, epsbeans.getStCelularEps());
        paActualizarEps.setString(12, epsbeans.getStCorreoEps());
        paActualizarEps.setString(13, epsbeans.getStContactoEps());
        paActualizarEps.setString(14, epsbeans.getStPaginaWebEps());
        paActualizarEps.setString(15, epsbeans.getStObservacionesEps());
        paActualizarEps.setString(16, "A");
        paActualizarEps.setInt(17, 0);
        
        boolean resultado = paActualizarEps.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paActualizarEps.getResultSet();
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
    public EpsBeans ConsultarPerfilId(List<EpsBeans> lsteps, int ideps) throws Exception {
        
        EpsBeans clinicabeans = new EpsBeans();
        
        for(int i=0 ; i < lsteps.size() ; i++)
        {
            if(lsteps.get(i).getIntID() == ideps)
            {
               clinicabeans = lsteps.get(i);
            }
        }
        return clinicabeans;
    }

    
    @Override
    public boolean EliminarEps(int ideps) throws Exception {
         Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        CallableStatement paEliminarEps = conMysql.prepareCall("{call spHC_Eps_Eliminar(?,?,?)}");
        
        paEliminarEps.setInt(1, ideps);
        paEliminarEps.setString(2, "B");
        paEliminarEps.setInt(3, 0);
        
        boolean resultado = paEliminarEps.execute(); // ejecutar el SP
        
        if (resultado != false)
        {
            ResultSet rs = paEliminarEps.getResultSet();
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
