/**
 * testCaesarCrypto contains the unit tests for Caesar cipher operations.
 */
package testCaesarCrypto;

import crypto.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to check if Caesar encryption is valid.
 *
 * @author Joseph R.
 * @since April 5, 2020
 * @see crypto.Caesar
 */
public class TestCaesarEncryption {
    Caesar c = new Caesar();
    String plainText = "ABCDE";
    int key = 1;
    String cipherText = c.encrypt(plainText, String.valueOf(key));
    String expectedCipherText = "BCDEF";
    
    @Test
    public void TestCaesarEncryption() {
        System.out.println("@Test TestCaesarEncryption()");
        assertEquals(cipherText, expectedCipherText);
    }
}
