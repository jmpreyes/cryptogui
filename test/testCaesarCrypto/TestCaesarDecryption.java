package testCaesarCrypto;

import crypto.Caesar;
import crypto.Crypto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to ensure Crypto decryption works well.
 * 
 * @author Joseph R.
 * @since April 5, 2020
 * @see crypto.Caesar
 */
public class TestCaesarDecryption {
    @Test
    public void TestCaesarDecryption() {
        Crypto c = new Caesar();
        String ctext = "Nz obnf jt Kpf!";
        c.setCiphertext(ctext);
        c.setKey("1");
        c.decrypt();
        String actualPlaintext = c.getPlaintext();
        String expectedPlaintext = "My name is Joe!";
        
        System.out.println("@Test TestCaesarDecryption()");
        assertEquals(actualPlaintext, expectedPlaintext.toUpperCase());
    }
}
