package com.seongwon.cipher;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Throwable
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        int keyBitSize = 128;
        keyGenerator.init(keyBitSize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();

        byte[] iv = new byte[12];
        secureRandom.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] plainText = "abcabcaabc".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);

        for(int i=0; i<cipherText.length; i++){
            System.out.print(Integer.toHexString(cipherText[i]) + " ");
        }
        System.out.println();


        KeyPair keyPair = buildKeyPair();
        PublicKey pubkey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
    
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        byte[] decipher = cipher.doFinal(cipherText);
        System.out.println(new String(decipher, "UTF-8").trim());

        byte[] key = secretKey.getEncoded();
        
        String strKey = Base64.getEncoder().encodeToString(key);
        
        System.out.println(strKey.toString());
        
        String rsakey = getRSAEncryptedKey(pubkey, strKey);
        
        System.out.println("RSA KEY: "+rsakey);

        String deckey = getRSADecryptedKey(privateKey, rsakey);
        
        System.out.println("DEC KEY: "+deckey.toString());

        System.out.println(strKey.toString());
    }
    
    
    public static String getRSAEncryptedKey(PublicKey pubkey ,String key) throws Throwable{
        Cipher rsacipher = Cipher.getInstance("RSA");
        rsacipher.init(Cipher.ENCRYPT_MODE, pubkey);

        byte[] cipher = rsacipher.doFinal(key.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(cipher);
    }
    
    public static String getRSADecryptedKey(PrivateKey privkey ,String key) throws Throwable{
        byte[] bytes = Base64.getDecoder().decode(key);
        
        Cipher rsacipher = Cipher.getInstance("RSA");
        
        rsacipher.init(Cipher.DECRYPT_MODE, privkey);
        return new String(rsacipher.doFinal(bytes), "UTF-8");
    }

    public static KeyPair buildKeyPair() throws Exception{
        final int keySize = 1024;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }
}