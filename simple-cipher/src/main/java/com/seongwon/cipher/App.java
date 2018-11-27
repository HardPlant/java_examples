package com.seongwon.cipher;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.SecureRandom;

import javax.crypto.Cipher;
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
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);
        SecretKey secretKey = SecretKeySpec();

        byte[] iv = new byte[12];
        secureRandom.nextBytes(iv);

        final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] plainText = "abcabcaabc".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);

        for(int i=0; i<cipherMessage.length; i++){
            System.out.println(Integer.toHexString(cipherMessage[i]));
        }
    }
}
