package com.gigigo.encryptation;


import com.gigigo.encryptation.utils.BytesUtils;
import java.io.UnsupportedEncodingException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class SHA256Algorithm {

    public static byte[] calculateSHA256(byte[] stringInByteArray, byte[] keyInByteArray) {

        try {
            Mac sha256Hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(keyInByteArray, "HmacSHA256");
            sha256Hmac.init(secretKey);

            return sha256Hmac.doFinal(stringInByteArray);
        }
        catch (Exception e){
            return null;
        }
    }

    public static boolean checkAreEquals(byte[] stringInByteArray, byte[] keyInByteArray, byte[] valueToCheckInByteArray) {
        byte[] sha256 = calculateSHA256(stringInByteArray, keyInByteArray);
        return BytesUtils.checkAreEquals(sha256, valueToCheckInByteArray);
    }
}
