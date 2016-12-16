package com.gigigo.encryptation;

import com.gigigo.encryptation.utils.BytesUtils;

public class Encrypter {

    public static String encrypt(byte[] key, byte[] iv, byte[] dataToEncrypt) {
        try {
            byte[] encryptedBytesAes256Data = AES256Algorithm.encrypt(key, iv, dataToEncrypt);

            byte[] concatedIvWithAes256Data = BytesUtils.concatByteArrays(iv, encryptedBytesAes256Data);

            byte[] sha256ByteData = SHA256Algorithm.calculateSHA256(concatedIvWithAes256Data, key);

            byte[] dataToSend = BytesUtils.concatByteArrays(
                    BytesUtils.concatByteArrays(sha256ByteData, iv),
                    encryptedBytesAes256Data);

            return Base64Encoder.encode(dataToSend);
        } catch (Exception e) {
            return null;
        }
    }

    public static String decrypt(String encryptedText, byte[] key) {
        byte[] decodeByteArray = Base64Encoder.decodeToByteArray(encryptedText);

        byte[] hMacByteArray = BytesUtils.obtainByteArray(decodeByteArray, 0, 32);
        byte[] ivByteArray = BytesUtils.obtainByteArray(decodeByteArray, 32, 16);
        byte[] aes256ByteArray = BytesUtils.obtainByteArray(decodeByteArray, 48, decodeByteArray.length - 48);

        byte[] concatedIvWithAes256Data = BytesUtils.concatByteArrays(ivByteArray, aes256ByteArray);
        boolean areEquals = SHA256Algorithm.checkAreEquals(concatedIvWithAes256Data, key, hMacByteArray);

        if (areEquals) {
            try {
                byte[] decrypt = AES256Algorithm.decrypt(ivByteArray, key, aes256ByteArray);
                
                String decodedString = new String(decrypt, "UTF-8");

                return decodedString;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } else {
            return null;
        }
    }
}
