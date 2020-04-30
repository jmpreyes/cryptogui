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
public class TestVigenereEncryption {
    @Test
    public void TestVigenereEncryption() {
        Crypto v = new Vigenere();
        String ptext = "HEY -- ATTACK THE CASTLE WALLS AT DAWN!";
        String keyword = "JAVA";
        v.setPlaintext(ptext);
        v.setKey(keyword);
        v.encrypt();
        String actualCiphertext = v.getCiphertext();
        String expectedCiphertext = "QET -- ACTVCT OHN XABTGE WVLUS AC YAFN!";
        
        System.out.println("@Test TestVigenereEncryption()");
        assertEquals(actualCiphertext, expectedCiphertext);
    }
}
