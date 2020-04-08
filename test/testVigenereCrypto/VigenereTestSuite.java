package testVigenereCrypto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for Vigenère cipher.
 * 
 * @author Joseph R.
 * @since April 8, 2020
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
    testVigenereCrypto.TestVigenereEncryption.class, 
    testVigenereCrypto.TestVigenereDecryption.class
})

public class VigenereTestSuite {}
