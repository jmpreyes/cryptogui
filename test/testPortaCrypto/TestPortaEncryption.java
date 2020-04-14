/**
 * testPortaCrypto contains the unit tests for Porta cipher operations.
 */
package testPortaCrypto;

import crypto.Porta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to validate Porta cipher encryption.
 * 
 * @author Joseph R.
 * @since April 14, 2020
 * @see crypto.Porta
 */
public class TestPortaEncryption {
    Porta p = new Porta("THEQUICKFOXJUMPSOVERTHELAZYDOG");
    String plainText = "PIZZAISDELICIOUSFOOD";
    String cipherText = p.encrypt(plainText);
    String expectedCipherText = "GYKEXZEVTSTTSIAJZEMY";
    
    @Test
    public void TestPortaEncryption() {
        System.out.println("@Test TestPortaEncryption()");
        assertEquals(cipherText, expectedCipherText);
    }
}
