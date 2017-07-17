/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.daos;
import com.ricsoft.beans.UsuarioBeans;
import com.ricsoft.conection.ConectionMysql;
import com.ricsoft.interfaces.UsuarioInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author RCHRDHYSBQR
 */
public class UsuarioDao implements UsuarioInterface{

    @Override
    public boolean InsertarUsuario(UsuarioBeans usuariobeans) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioBeans> CosultarUsuarios(UsuarioBeans perfilesbeans) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioBeans ConsultarUsuarioId(List<UsuarioBeans> lstperfiles, int idperfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ActualizarUsuario(UsuarioBeans usuariobeans) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarUsuario(int idperfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
