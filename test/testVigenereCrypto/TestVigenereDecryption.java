package testVigenereCrypto;

import crypto.Vigenere;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to check if Vigenère decryption works well.
 * 
 * @author Joseph R.
 * @since April 8, 2020
 * @see crypto.Vigenere
 */
public class TestVigenereDecryption {
    Vigenere v = new Vigenere();
    String cipherText = "HHPWSFUSXXHHSELEUWTHE";
    String key = v.createValidKey(cipherText, "ADELE");
    String plainText = v.decrypt(cipherText, key);
    String expectedPlainText = "HELLOFROMTHEOTHERSIDE";
    
    @Test
    public void TestVigenereDecryption() {
        System.out.println("@Test TestVigenereDecryption()");
        assertEquals(plainText, expectedPlainText.toUpperCase());
    }
}
