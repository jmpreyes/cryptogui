package testCaesarCrypto;

import crypto.Caesar;
import crypto.Crypto;
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
    @Test
    public void TestCaesarEncryption() {
        Crypto c = new Caesar();
        String ptext = "My name is Joe!";
        c.setPlaintext(ptext);
        c.setKey("1");
        c.encrypt();
        String actualCiphertext = c.getCiphertext();
        String expectedCiphertext = "Nz obnf jt Kpf!";
        
        System.out.println("@Test TestCaesarEncryption()");
        assertEquals(actualCiphertext, expectedCiphertext.toUpperCase());
    }
}
