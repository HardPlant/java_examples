package com.seongwon.cipher;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.SecureRandom;

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


        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        
        byte[] decipher = cipher.doFinal(cipherText);
        System.out.println(new String(decipher, "UTF-8").trim());
    }
}