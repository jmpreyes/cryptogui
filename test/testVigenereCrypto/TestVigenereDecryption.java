package testVigenereCrypto;

import crypto.Crypto;
import crypto.Vigenere;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to check if Vigenère encryption is valid.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 * @see crypto.Vigenere
 */
public class TestVigenereDecryption {
    @Test
    public void TestVigenereDecryption() {
        Crypto v = new Vigenere();
        String ctext = "QET -- ACTVCT OHN XABTGE WVLUS AC YAFN!";
        String keyword = "JAVA";
        v.setCiphertext(ctext);
        v.setKey(keyword);
        v.decrypt();
        String actualPlaintext = v.getPlaintext();
        String expectedPlaintext = "HEY -- ATTACK THE CASTLE WALLS AT DAWN!";
        
        System.out.println("@Test TestVigenereDecryption()");
        assertEquals(actualPlaintext, expectedPlaintext);
    }
}
