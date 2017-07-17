/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.beans;
import com.ricsoft.userclass.EncryptionDecryption;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author RCHRDHYSBQR
 */
public class UsuarioBeans {
    private int intid;
    private String stnombres;
    private String stapellidos;
    private String stnick;
    private String stpasswordencrypt;
    private String stpassworddecrypt;
    private String strptpassword;
    private String sttelefono;
    private String stemail ;
    private String stobservacionesusuario;
    private String stUsuarioModificacion;
    private Date dtFechaCreacion;
    private Date dtFechaModificacion;

    public UsuarioBeans() {
    }

    public UsuarioBeans(int intid, String stnombres, String stapellidos, String stnick, String stpasswordencrypt, String stpassworddecrypt, String strptpassword, String sttelefono, String stemail, String stobservacionesusuario, String stUsuarioModificacion, Date dtFechaCreacion, Date dtFechaModificacion) {
        this.intid = intid;
        this.stnombres = stnombres;
        this.stapellidos = stapellidos;
        this.stnick = stnick;
        this.stpasswordencrypt = stpasswordencrypt;
        this.stpassworddecrypt = stpassworddecrypt;
        this.strptpassword = strptpassword;
        this.sttelefono = sttelefono;
        this.stemail = stemail;
        this.stobservacionesusuario = stobservacionesusuario;
        this.stUsuarioModificacion = stUsuarioModificacion;
        this.dtFechaCreacion = dtFechaCreacion;
        this.dtFechaModificacion = dtFechaModificacion;
    }
    
    
    
    public int getIntid() {
        return intid;
    }

    public void setIntid(int intid) {
        this.intid = intid;
    }
    
    
    public String getStnombres() {
        return stnombres;
    }

    public void setStnombres(String stnombres) {
        this.stnombres = stnombres;
    }

    public String getStapellidos() {
        return stapellidos;
    }

    public void setStapellidos(String stapellidos) {
        this.stapellidos = stapellidos;
    }

    public String getStnick() {
        return stnick;
    }

    public void setStnick(String stnick) {
        this.stnick = stnick;
    }

    public String getStpasswordencrypt() {
      try
      {
        
        stpasswordencrypt = stpassworddecrypt;
        
        //Se genera la llave temporal.
        SecretKey desKey       = KeyGenerator.getInstance("DES").generateKey();
        EncryptionDecryption encryptiondecryption = new EncryptionDecryption(desKey, desKey.getAlgorithm());
        stpasswordencrypt = encryptiondecryption.DesEncryption(stpasswordencrypt);
        
        return stpasswordencrypt;
      
      }catch(NoSuchAlgorithmException noex)
      {
          return stpasswordencrypt;
      }
      catch(Exception ex)
      {
          return stpasswordencrypt;
      }
    }

    public void setStpasswordencrypt(String stpasswordencrypt) {
        this.stpasswordencrypt = stpasswordencrypt;
    }

    public String getStpassworddecrypt() {
        return stpassworddecrypt;
    }

    public void setStpassworddecrypt(String stpassworddecrypt) {
        this.stpassworddecrypt = stpassworddecrypt;
    }

    public String getStrptpassword() {
        return strptpassword;
    }

    public void setStrptpassword(String strptpassword) {
        this.strptpassword = strptpassword;
    }

    public String getSttelefono() {
        return sttelefono;
    }

    public void setSttelefono(String sttelefono) {
        this.sttelefono = sttelefono;
    }

    public String getStemail() {
        return stemail;
    }

    public void setStemail(String stemail) {
        this.stemail = stemail;
    }

    public String getStobservacionesusuario() {
        return stobservacionesusuario;
    }

    public void setStobservacionesusuario(String stobservacionesusuario) {
        this.stobservacionesusuario = stobservacionesusuario;
    }

    public String getStUsuarioModificacion() {
        return stUsuarioModificacion;
    }

    public void setStUsuarioModificacion(String stUsuarioModificacion) {
        this.stUsuarioModificacion = stUsuarioModificacion;
    }

    public Date getDtFechaCreacion() {
        return dtFechaCreacion;
    }

    public void setDtFechaCreacion(Date dtFechaCreacion) {
        this.dtFechaCreacion = dtFechaCreacion;
    }

    public Date getDtFechaModificacion() {
        return dtFechaModificacion;
    }

    public void setDtFechaModificacion(Date dtFechaModificacion) {
        this.dtFechaModificacion = dtFechaModificacion;
    }
    
    
}