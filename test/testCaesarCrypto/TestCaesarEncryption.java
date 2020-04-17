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
    String plainText = "My name is Joe^";
    int key = 1;
    String cipherText = c.encrypt(plainText, key);
    String expectedCipherText = "Nz obnf jt Kpf^";
    
    @Test
    public void TestCaesarEncryption() {
        System.out.println("@Test TestCaesarEncryption()");
        assertEquals(cipherText, expectedCipherText.toUpperCase());
    }
}
