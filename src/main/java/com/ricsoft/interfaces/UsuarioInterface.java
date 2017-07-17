/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.interfaces;

import com.ricsoft.beans.UsuarioBeans;
import java.util.List;

/**
 *
 * @author RCHRDHYSBQR
 */
public interface UsuarioInterface {
    
    public boolean InsertarUsuario(UsuarioBeans usuariobeans)throws Exception;
    public List<UsuarioBeans> CosultarUsuarios(UsuarioBeans perfilesbeans)throws Exception;
    public UsuarioBeans ConsultarUsuarioId(List<UsuarioBeans> lstperfiles, int idperfil)throws Exception;
    public boolean ActualizarUsuario(UsuarioBeans usuariobeans)throws Exception;
    public boolean EliminarUsuario(int idperfil)throws Exception;
}
