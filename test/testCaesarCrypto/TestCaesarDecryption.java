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
    String cipherText = "BCDEF";
    int key = 1;
    String plainText = c.performDecryption(cipherText, key);
    String expectedPlainText = "ABCDE";
    
    @Test
    public void TestCaesarDecryption() {
        System.out.println("@Test TestCaesarDecryption()");
        assertEquals(plainText, expectedPlainText);
    }
    
    /*
    // If key is 0, plain text and cipher text should be the same
    // No shifting happens
    @Test
    public void TestWhenKeyIsZero() {
        System.out.println("@Test TestWhenKeyIsZero()");
        assertEquals(plainText, expectedPlainText);
    }
    */
}
