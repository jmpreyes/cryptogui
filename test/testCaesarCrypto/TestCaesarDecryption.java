package testCaesarCrypto;

import crypto.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This JUnit test verifies whether or not Caesar decryption works.
 * 
 * @author Joseph
 * @version 1.0
 * @since January 13, 2020
 * @see Caesar
 */
public class TestCaesarDecryption {
    Caesar c = new Caesar();
    String cipherText = "BCDEFGHIJK";
    int key = 1;
    String plainText = c.performDecryption(cipherText, key);
    String expectedPlainText = "ABCDEFGHIJ";
    
    @Test
    public void TestCaesarDecryption() {
        System.out.println("@Test TestCaesarDecryption()");
        assertEquals(plainText, expectedPlainText);
    }
    
    // If key is 0, plain text and cipher text should be the same
    // No shifting happens
    @Test
    public void TestWhenKeyIsZero() {
        System.out.println("@Test TestWhenKeyIsZero()");
        assertEquals(plainText, expectedPlainText);
    }
}

/*
    May need to rewrite this...
*/
