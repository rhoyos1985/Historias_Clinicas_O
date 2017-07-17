/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Descripción: Clase encargada de administrar la conexión
 * @author Richard Adolfo Hoyos Baquero
 * @version 1.0
 */
public class ConectionMysql {
    static Connection conexion;
    
    public static Connection GetPoolConnection()
    {
       conexion=null;

        try
        {
            Context ic = new InitialContext();
            DataSource ds;
            ds = (DataSource)ic.lookup("jdbc/hc_datasources");
            conexion = ds.getConnection();
        }
        catch(SQLException ex)
        {
            conexion=null;
        }
        catch(Exception ex)
        {
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
    public static void Desconectar()
    {
        conexion = null;
    }

}
