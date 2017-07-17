/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;

import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.userclass.ResulsettoDataStructure;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author RCHRDHYSBQR
 */
public class ExecuteStoreProcedure {
        
    private HashMap hmresult = new HashMap();
    private ResulsettoDataStructure resulsettodatastructure = new ResulsettoDataStructure();
    private ResultSet rs=null;

    public ResultSet getRs() {
        return rs;
    }
    
    public HashMap getHmresult() {
        return hmresult;
    }
    
    /**
     *  <summary>
        Método para realizar la ejecución de los procedimientos almacenados
        </summary>
     * @param stSP Recibe el nombre del sp
     * @param paravaluessp Es un HashMap el cual contiene el nombre del parametro y el valor
     * @return  <code> Se retorna un boolean </code> 
     */
    
    public  boolean EjecutarSP(String stSP, HashMap paravaluessp)
    {

        String stNombresp = stSP.trim();    
        String stCadenaejecutar = "";
        String stparametros = "";
        
        try
        {
            //Se obtiene la conexión con la base de datos
            Connection conMysql = ConectionMysql.GetPoolConnection();
            
            //Se cuenta la cantidad de parametros existentes para armar la cadena
            int intsizehasmap = paravaluessp.size();    

            for (int count=1; count <= intsizehasmap; count++)
            {
                stparametros = stparametros.concat("?,");
            }

            //Se arma la cadena de ejecucion
            stparametros = stparametros.substring(0,stparametros.length()-1);
            stCadenaejecutar = "{call " + stNombresp + "(" + stparametros + ")}";

            //Se crea le llamado al sp
            CallableStatement storedprocedure = conMysql.prepareCall(stCadenaejecutar);
            
            //Se agregan los parametros y el valor 
            Iterator it = paravaluessp.keySet().iterator();

            while (it.hasNext()) {

                String stclave = (String)it.next();
                String stvalor = (String)paravaluessp.get(stclave);

                storedprocedure.setString(stclave, stvalor);
            }

            boolean resultado = storedprocedure.execute(); // ejecutar el SP

            if(resultado!=false)
            {
                rs=storedprocedure.getResultSet();                  //ResultSet resultante de la ejecución del sp
                hmresult = resulsettodatastructure.resultSetToHashMap(rs);
            }

            return resultado;

        }
        catch (SQLException ex)
        {
  
        }
        catch (Exception ex)
        {
        }
        finally
        {
            ConectionMysql.Desconectar();
        }
        return false;
    }
    
    /**
     * <summary>
        Método para realizar la ejecución de los procedimientos almacenados
        </summary>
     * @param stSP
     * @return <code> Se retorna un boolean </code> 
     */
    public  boolean EjecutarSP(String stSP)
    {

        String stNombresp = stSP.trim();    
        String stCadenaejecutar = "";
        
        try
        {
            //Se obtiene la conexión con la base de datos
            Connection conMysql = ConectionMysql.GetPoolConnection();

            //Se arma la cadena de ejecucion
            stCadenaejecutar = "{call " + stNombresp + "()}";

            //Se crea le llamado al sp
            CallableStatement storedprocedure = conMysql.prepareCall(stCadenaejecutar);
            
            boolean resultado = storedprocedure.execute(); // ejecutar el SP

            if(resultado!=false)
            {
                rs=storedprocedure.getResultSet();                  //ResultSet resultante de la ejecución del sp
                hmresult = resulsettodatastructure.resultSetToHashMap(rs);
            }

            return resultado;

        }
        catch (SQLException ex)
        {
  
        }
        catch (Exception ex)
        {
        }
        finally
        {
            ConectionMysql.Desconectar();
        }
        return false;
    }
}
