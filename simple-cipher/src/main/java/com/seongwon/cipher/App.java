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
        KeyPair keyPair = buildKeyPair();
        PublicKey pubkey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
    
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

        byte[] rsakey = getRSAEncryptedKey(privateKey, secretKey.getEncoded());
        System.out.println(rsakey.toString());

        byte[] deckey = getRSADecryptedKey(pubkey, rsakey);
        System.out.println(deckey.toString());
        System.out.println(secretKey.getEncoded().length);
        System.out.println(secretKey.getEncoded().toString());

    }
    

    public static byte[] getRSAEncryptedKey(PrivateKey privateKey ,byte[] key) throws Throwable{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(key);
    }

    public static byte[] getRSADecryptedKey(PublicKey pubKey ,byte[] key) throws Throwable{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);

        return cipher.doFinal(key);
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException{
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }
}