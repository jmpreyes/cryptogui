/**
 * testCaesarCrypto contains the unit tests for Caesar cipher operations.
 */
package testCaesarCrypto;

import crypto.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to ensure Caesar decryption works well.
 * 
 * @author Joseph R.
 * @since April 5, 2020
 * @see Caesar
 */
public class TestCaesarDecryption {
    Caesar c = new Caesar();
    String cipherText = "Nz obnf jt Kpf";
    int key = 1;
    String plainText = c.decrypt(cipherText, String.valueOf(key));
    String expectedPlainText = "My name is Joe";
    
    @Test
    public void TestCaesarDecryption() {
        System.out.println("@Test TestCaesarDecryption()");
        assertEquals(plainText, expectedPlainText.toUpperCase());
    }
}
