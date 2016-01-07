package com.claridy.khub.admin.core.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
    private static byte[] iv = "0123456789012345".getBytes();
    private static String keyfiller = "                ";

    private static String getHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append((bytes[i] >= 0x0 && bytes[i] < 0x10) ? "0" : "");
            sb.append(Integer.toHexString(0x00ff & bytes[i]));
        }

        return sb.toString().toUpperCase();
    }

    public static String encrypt(String data, String key) {
        key = key.toUpperCase();
        if (key.length() < 16) {
            key = key + keyfiller.substring(0, 16 - key.length());
        }

        String encrypttext = "";
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

            AlgorithmParameterSpec algParamSpec = new IvParameterSpec(iv);

            Cipher encrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");

            encrypter.init(Cipher.ENCRYPT_MODE, skeySpec, algParamSpec);

            byte[] encryptedText = encrypter.doFinal(data.getBytes());
            encrypttext = getHexString(encryptedText);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return encrypttext;
    }

    public static String decrypt(String data, String key) {
        key = key.toUpperCase();
        if (key.length() < 16) {
            key = key + keyfiller.substring(0, 16 - key.length());
        }

        String decrypttext = "";

        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

        try {
            AlgorithmParameterSpec algParamSpec = new IvParameterSpec(iv);

            Cipher decrypter = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decrypter.init(Cipher.DECRYPT_MODE, skeySpec, algParamSpec);

            byte[] buf = new byte[data.length() / 2];

            for (int i = 0, j = 0; i < data.length(); i += 2) {

                String hex = data.substring(i, i + 2);

                buf[j++] = (byte) Integer.parseInt(hex, 16);

            }

            byte[] decryptedText = decrypter.doFinal(buf);
            decrypttext = new String(decryptedText);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return decrypttext;
    }

    public static String getEncryptString(String data) {
        String encryptKey = "postman";
        return Crypto.encrypt(data, encryptKey);
    }

    public static String getDecryptString(String data) {
        String encryptKey = "postman";
        if (data == null || data.length() < 16) {
            return data;
        }
        return Crypto.decrypt(data, encryptKey);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getEncryptString("postman"));
        System.out.println(getDecryptString("FDC4E55E9AD2A67493B91FD3354E9212"));
        System.out.println(getDecryptString("F6EAF9C3E43FB3413CF65853B6EE9794"));
    }
}
