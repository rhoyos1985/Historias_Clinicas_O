/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.userclass;

// Generador y Cipher
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

// Claves Especificas
import java.security.spec.KeySpec;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;

// Exepciones
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RCHRDHYSBQR
 */
public class EncryptionDecryption {
    
    private Cipher cphrencrytion;
    private Cipher cphrdecryption;
    private String stcadenadev = "";

    public EncryptionDecryption() {
    }
    
    
    /**
     * Constructor que permite crear el objeto. Responsable de la configuración e inicialización
     * de este objeto para encriptar y desencriptar con una instancia Cipher cuando se le
     * entrega una llave y un algoritmo
     * @param secretkey        Llave secreta.
     * @param stalgoritmo  Algoritmo de que inicializa la instancia para encriptar y desencriptar.
     */
    public EncryptionDecryption(SecretKey secretkey, String stalgoritmo) {
        try {
            
            cphrencrytion = Cipher.getInstance(stalgoritmo);
            cphrdecryption = Cipher.getInstance(stalgoritmo);
            
            cphrencrytion.init(Cipher.ENCRYPT_MODE, secretkey);
            cphrdecryption.init(Cipher.DECRYPT_MODE, secretkey);
            
        } catch (NoSuchPaddingException e) {
            //System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            //System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            //System.out.println("EXCEPTION: InvalidKeyException");
        }
    }
    
    /**
     * Constructor utilizado para inicializar la instancia del objeto con una frase clave.
     * @param passPhrase Frase clave
     */
    public EncryptionDecryption(String stfraseclave) {

        // 8-bytes Salt
        byte[] salt = {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03
        };
        
        int iterationCount = 19;

        try {

            KeySpec ksclave = new PBEKeySpec(stfraseclave.toCharArray(), salt, iterationCount);
            SecretKey secretkey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(ksclave);

            cphrencrytion = Cipher.getInstance(secretkey.getAlgorithm());
            cphrdecryption = Cipher.getInstance(secretkey.getAlgorithm());

            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            cphrencrytion.init(Cipher.ENCRYPT_MODE, secretkey, paramSpec);
            cphrdecryption.init(Cipher.DECRYPT_MODE, secretkey, paramSpec);

        } catch (InvalidAlgorithmParameterException e) {
            //System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        } catch (InvalidKeySpecException e) {
            //System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch (NoSuchPaddingException e) {
            //System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            //System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            //System.out.println("EXCEPTION: InvalidKeyException");
        }
    }
    /**
     * Recibe una cadena y devuelve una cadena encriptada
     * @param stcadena Cadena a Encriptar
     * @return <code>String</code> Cadena encriptada
     */
   private void Encryption(String stcadena) {
        try {
            
            byte[] utf8codigo = stcadena.getBytes("UTF8");              // Codifica la cadena con el codificación UTF8

            
            byte[] btencript = cphrdecryption.doFinal(utf8codigo);      // Se encripta

            stcadenadev = new sun.misc.BASE64Encoder().encode(btencript);      // se codifica en base 64 para obtener una cadena
            

        } catch (BadPaddingException | IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }


    /**
     * Recibe una cadena encriptada y devuelve la cadena sin encriptar
     * @param stcadena Cadena codificada
     * @return <code>String</code> Devuelve una cadena decodificada
     */
    private void Decryption(String stcadena) {

        try {

            byte[] btdecryption = new sun.misc.BASE64Decoder().decodeBuffer(stcadena); // Decodifica el codigo enviado
            byte[] utf8codigo = cphrdecryption.doFinal(btdecryption);                  // Decodificación

            stcadenadev = new String(utf8codigo, "UTF8");  // Se decodifica usando utf-8

        } catch (BadPaddingException | IllegalBlockSizeException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }
    
    public String DesEncryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("DES").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Encryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String DesDecryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("DES").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Decryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String BlowfishEncryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("Blowfish").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Encryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String BlowfishDecryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("Blowfish").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Decryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String DESedeEncryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("DESede").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Encryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String DESedeDecryption(String stcadena)
    {
        try {

            SecretKey secretkey = KeyGenerator.getInstance("DESede").generateKey();   //Se genera la clave
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(secretkey, secretkey.getAlgorithm());
            
            encryptiondecryption.Decryption(stcadena);
            
            String stdesEncrypted = stcadenadev;
            
            return stdesEncrypted;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionDecryption.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public String PhraseEncryption(String stclave, String stcadena)
    {
        try{
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(stclave);
            encryptiondecryption.Encryption(stcadena);
            String stdesEncrypted = stcadenadev;
        
            return stdesEncrypted;
        
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public String PhraseDecryption(String stclave, String stcadena)
    {
        try{
            
            EncryptionDecryption encryptiondecryption = new EncryptionDecryption(stclave);
            encryptiondecryption.Decryption(stcadena);
            String stdesEncrypted = stcadenadev;
        
            return stdesEncrypted;
        
        } catch (Exception e) {
        }
        
        return null;
    }
}

