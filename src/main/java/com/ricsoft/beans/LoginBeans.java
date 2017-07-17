/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.beans;

import com.ricsoft.userclass.EncryptionDecryption;
import java.io.Serializable;


/**
 *
 * @author RCHRDHYSBQR
 */
public class LoginBeans implements Serializable {
    private String stnombreusuario;
    private String stpassword;
    private String stpasswordencrypter;
    private String stpassworddecrypter;
    private boolean boollogueado;

    public String getStnombreusuario() {
        return stnombreusuario;
    }

    public void setStnombreusuario(String stnombreusuario) {
        this.stnombreusuario = stnombreusuario;
    }

    public String getStpassword() {
        return stpassword;
    }

    public void setStpassword(String stpassword) {
        this.stpassword = stpassword;
    }

    public String getStpasswordencrypter() {
        return stpasswordencrypter;
    }

    
    public void setStpasswordencrypter(String stpasswordencrypter) {
        try
        {
          EncryptionDecryption encryptiondecryption = new EncryptionDecryption();
          this.stpasswordencrypter = encryptiondecryption.DesEncryption( stpasswordencrypter);
        }
        catch(Exception ex)
        {

        }
    }

    public String getStpassworddecrypter() {
        return stpassworddecrypter;
    }

    public void setStpassworddecrypter(String stpassworddecrypter) {
        try {
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption();
            this.stpassworddecrypter = encryptiondecryption.DesDecryption(stpassworddecrypter);
        } catch (Exception ex) {

        }
    }

    public boolean isBoollogueado() {
        return boollogueado;
    }

    public void setBoollogueado(boolean boollogueado) {
        this.boollogueado = boollogueado;
    }
    
    
}
