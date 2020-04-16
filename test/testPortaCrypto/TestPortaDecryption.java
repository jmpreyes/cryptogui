/**
 * testPortaCrypto contains the unit tests for Porta cipher operations.
 */
package testPortaCrypto;

import crypto.Porta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to validate Porta cipher decryption.
 * 
 * @author Joseph R.
 * @since April 14, 2020
 * @see crypto.Porta
 */
public class TestPortaDecryption {
    Porta p = new Porta();
    String cipherText = "GYKEXZEVTSTTSIAJZEMY";
    String key = "THEQUICKFOXJUMPSOVERTHELAZYDOG";
    String plainText = p.decrypt(cipherText, key);
    String expectedPlainText = "PIZZAISDELICIOUSFOOD";
    
    @Test
    public void TestPortaDecryption() {
        System.out.println("@Test TestPortaDecryption()");
        assertEquals(plainText, expectedPlainText);
    }
}
