package com.gigigo.encryptation;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256Algorithm {

  public static byte[] encrypt(byte[] keyBytes, byte[] ivBytes, byte[] dataToEncrypt) {

    try {
      AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
      SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES_256");
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
      cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);

      return cipher.doFinal(dataToEncrypt);
    } catch (Exception e) {
      return null;
    }
  }

  public static byte[] decrypt(byte[] keyBytes, byte[] ivBytes, byte[] dataToDecrypt) {
    try {
      AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
      SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES_256");

      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
      cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);

      return cipher.doFinal(dataToDecrypt);
    } catch (Exception e) {
      return null;
    }
  }
}
