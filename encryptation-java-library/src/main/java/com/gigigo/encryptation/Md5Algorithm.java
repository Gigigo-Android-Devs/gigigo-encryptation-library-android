package com.gigigo.encryptation;

public class Md5Algorithm {

  /**
   * Calculate MD5
   * @param stringInByteArrayToMd5 String in byte array (getBytes())
   * @return The MD5 value calculated
   */
    public static String calculateMD5(byte[] stringInByteArrayToMd5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(stringInByteArrayToMd5);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
