package testVigenereCrypto;

import crypto.Vigenere;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to check if Vigenère encryption works is valid.
 *
 * @author Joseph R.
 * @since April 7, 2020
 * @see crypto.Vigenere
 */
public class TestVigenereEncryption {
    Vigenere v = new Vigenere();
    String plainText = "Thequickbrownfoxjumpsoverthelazydog";
    String key = v.createValidKey(plainText, "Pizza");
    String cipherText = v.encrypt(plainText, key);
    String expectedCipherText = "Ipdpuxkjardemeomrtlphwudripdkaogcng";
    
    @Test
    public void TestVigenereEncryption() {
        System.out.println("@Test TestVigenereEncryption()");
        assertEquals(cipherText, expectedCipherText.toUpperCase());
    }
}
