package testPortaCrypto;

import misc.Porta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to validate Porta cipher encryption.
 * 
 * @author Joseph R.
 * @since April 14, 2020
 * @see misc.Porta
 */
public class TestPortaEncryption {
    Porta p = new Porta();
    String plainText = "PIZZAISDELICIOUSFOOD";
    String key = "THEQUICKFOXJUMPSOVERTHELAZYDOG";
    String cipherText = p.encrypt(plainText, key);
    String expectedCipherText = "GYKEXZEVTSTTSIAJZEMY";
    
    @Test
    public void TestPortaEncryption() {
        System.out.println("@Test TestPortaEncryption()");
        assertEquals(cipherText, expectedCipherText);
    }
}
