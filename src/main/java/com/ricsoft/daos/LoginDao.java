/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;
import com.ricsoft.beans.LoginBeans;
import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.interfaces.LoginInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author RCHRDHYSBQR
 */
public class LoginDao implements LoginInterface{

    @Override
    public boolean Login(LoginBeans loginbeans) throws Exception {
        Connection conMysql = ConectionMysql.GetPoolConnection();  //Se obtiene la conexión con la base de datos
        
        loginbeans.setStpasswordencrypter(loginbeans.getStpassword());
        String stpasswordencrypter = loginbeans.getStpasswordencrypter();
        
        CallableStatement spConsultarUsuario = conMysql.prepareCall("{call spHC_Usuarios_ConsultarUnico(?,?)}");

        spConsultarUsuario.setString(1, loginbeans.getStnombreusuario());
        spConsultarUsuario.setString(2, stpasswordencrypter);

        boolean resultado = spConsultarUsuario.execute(); // ejecutar el SP

        if (resultado != false) {
            ResultSet rs = spConsultarUsuario.getResultSet();
            rs.next();

            if (rs.getRow() == 0) {
                resultado = false;
            }
            else
            {
                String stnombre = rs.getString("Nombres") + " " + rs.getString("Apellidos");
                loginbeans.setStnombreusuario(stnombre);
            }
        }

        conMysql.close();
        conMysql = null;
        ConectionMysql.Desconectar();

        return resultado;
    }
    
}
