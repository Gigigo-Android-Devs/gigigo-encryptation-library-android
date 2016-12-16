package com.gigigo.encryptation;

import com.gigigo.encryptation.utils.BytesUtils;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Md5AlgorithmTest {

  @Parameterized.Parameters public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {"1111", "b59c67bf196a4758191e42f76670ceba"},
        {"2222", "934b535800b1cba8f96a5d72f72f1611"},
        {"3333", "2be9bd7a3434f7038ca27d1918de58bd"},
        {"4444", "dbc4d84bfcfe2284ba11beffb853a8c4"},
        {"5555", "6074c6aa3488f3c2dddff2a7ca821aab"},
        {"6666", "e9510081ac30ffa83f10b68cde1cac07"},
        {"7777", "d79c8788088c2193f0244d8f1f36d2db"},
        {"8888", "cf79ae6addba60ad018347359bd144d2"},
        {"9999", "fa246d0262c3925617b0c72bb20eeb1d"}
    });
  }

  @Parameterized.Parameter
  public String value;

  @Parameterized.Parameter(value = 1)
  public String md5Value;

  @Test public void shouldCalculateMd5Value() throws Exception {
    String expedtedValue = Md5Algorithm.calculateMD5(value.getBytes());

    assertEquals(expedtedValue, md5Value);
  }
}