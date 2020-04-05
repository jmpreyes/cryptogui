package testCaesarCrypto;

import crypto.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This JUnit test case determines whether or not the 
 * Caesar encryption is valid.
 * 
 * Various test cases:
 * 1) Compare if encryption method returns the expected result
 * 2) Determine if the key is valid (key must be a non-zero integer)
 * 3) Determine if the text is non-null
 * 
 * @author Joseph
 * @version 1.0
 * @since January 13, 2020
 * @see Caesar
 */
public class TestCaesarEncryption {
    Caesar c = new Caesar();
    String plainText = "ABCDEFGHIJ";
    //String plainText = "";
    //int key = -1;
    int key = 1;
    String cipherText = c.performEncryption(plainText, key);
    String expectedCipherText = "BCDEFGHIJK";
    //String expectedCipherText = "ZABCDEFGHI";
    
    @Test
    public void TestCaesarEncryption() {
        System.out.println("@Test TestCaesarEncryption()");
        assertEquals(cipherText, expectedCipherText);
    }
    
    @Test
    public void TestEncryptionKeyIsNonZero() {
        System.out.println("@Test TestEncryptionKeyIsNonZero()");
        assertTrue(key != 0);
    }
    
    // NOTE: NON-EMPTY IS NOT THE SAME AS NON-NULL
    @Test
    public void TestPlainTextIsNotEmpty() {
        System.out.println("@Test TestPlainTextIsNotEmpty()");
        //assertNotNull(plainText);
        assertTrue(plainText.length() > 0);
    }
}
