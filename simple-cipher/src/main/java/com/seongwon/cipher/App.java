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
        SecretKey secretKey = SecretKeySpec(key, "AES");

        byte[] iv = new byte[12];
        secureRandom.nextBytes(iv);

        final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        String text = "Hello AES!";
        Charset charset = Charset.forName("utf-8");
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer buffer = encoder.encode(CharBuffer.wrap(text));
        byte[] plaintext = new byte[buffer.remaining()];
        byte[] cipherText = cipher.doFinal(plaintext);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4 
            + iv.length + cipherText.length);
        byteBuffer.putInt(iv.length);
        byteBuffer.put(iv);
        byteBuffer.put(cipherText);
        byte[] cipherMessage = byteBuffer.array();
        for(int i=0; i<cipherMessage.length; i++){
            System.out.println(Integer.toHexString(cipherMessage[i]));
        }
    }
}
