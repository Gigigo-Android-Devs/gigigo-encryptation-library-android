package com.gigigo.encryptation;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sun.rmi.runtime.Log;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SHA256AlgorithmTest {

  @Parameterized.Parameters public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {"1111", "1234", "67, 11, -16, -100, 47, -23, -57, -93, 23, 49, -97, 20, -51, -37, -103, -9, -87, 12, -67, 57, 44, -51, -103, -81, 46, -52, -113, 101, -126, 48, 47, -63"},
        {"2222", "1234", "-80, 66, -50, 27, -54, 75, -14, 67, -83, -85, -43, -23, -59, 33, 37, -107, 65, 96, 63, -68, 24, -17, -3, -38, -63, 92, -120, 47, 100, -86, -83, -45"},
        {"3333", "1234", "95, 6, 44, 65, 46, -99, 18, -85, -84, -64, -52, -5, 42, -75, 102, -51, -42, 126, 73, -98, 54, 56, 125, 47, 44, -69, -103, 50, 14, -32, 5, 123"},
        {"4444", "1234", "-34, -9, -70, 81, -51, 52, -47, -12, 56, 106, 126, 92, 12, -55, -90, -90, -81, 57, -47, -66, 19, 69, -95, 91, 42, 47, -53, -121, -75, 12, -100, -4"},
        {"5555", "1234", "-100, 24, -109, 33, 92, 89, -103, -110, 92, 80, -91, -41, 1, 85, 46, 108, -45, -18, 113, -40, -116, 118, 0, 112, 83, 121, 122, 54, 54, 56, 82, 11"},
        {"6666", "1234", "-89, 89, -5, 43, 58, 32, -12, -86, -122, -84, 14, -91, -72, -11, -13, 78, 92, 38, 38, 61, 5, 126, -17, 90, 48, 96, 23, -19, 107, 69, -51, -101"},
        {"7777", "1234", "66, 115, -5, 64, 29, -107, 51, -57, 41, 112, -40, -24, -73, 54, 45, -87, -18, -62, -71, -70, -78, 74, -90, 10, 5, 68, -76, -25, 125, -109, 53, -99"},
        {"8888", "1234", "-26, -8, -107, -114, 34, 4, 59, 8, 12, -32, -70, -65, 45, -23, -25, 3, 40, 18, 43, -108, 4, -124, -106, -47, -78, -65, -128, 78, 46, -71, 26, 66"},
        {"9999", "1234", "-110, -74, -77, 30, 53, 31, 49, -21, -125, 27, -100, -69, 114, 60, -118, -67, -94, 76, -77, 35, -87, -16, -60, 41, -102, -121, 80, 81, 68, -116, -14, 81"},
    });
  }

  @Parameterized.Parameter
  public String valueToConvert;

  @Parameterized.Parameter(value = 1)
  public String iv;

  @Parameterized.Parameter(value = 2)
  public String valueToCheck;

  @Test public void shouldCheckValueAndSHA256ValueAreEquals() throws Exception {
    String[] byteString = valueToCheck.split(",");
    byte[] array = new byte[byteString.length];
    for (int i = 0; i < array.length; i++) {
      array[i] = Byte.valueOf(byteString[i].trim());
    }

    boolean areEquals = SHA256Algorithm.checkAreEquals(valueToConvert.getBytes(), iv.getBytes(),
        array);

    assertTrue(areEquals);
  }
}