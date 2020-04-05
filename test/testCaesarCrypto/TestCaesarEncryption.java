package testCaesarCrypto;

import crypto.Caesar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test to check if Caesar encryption is valid.
 *
 * @author Joseph R.
 * @since April 5, 2020
 * @see Caesar
 */
public class TestCaesarEncryption {
    Caesar c = new Caesar();
    String plainText = "ABCDE";
    int key = 1;
    String cipherText = c.performEncryption(plainText, key);
    String expectedCipherText = "BCDEF";
    
    @Test
    public void TestCaesarEncryption() {
        System.out.println("@Test TestCaesarEncryption()");
        assertEquals(cipherText, expectedCipherText);
    }
    
    /*
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
    */
}
