package testCaesarCrypto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for Caesar cipher.
 * 
 * @author Joseph R.
 * @since April 5, 2020
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
    testCaesarCrypto.TestCaesarEncryption.class, 
    testCaesarCrypto.TestCaesarDecryption.class
})
public class CaesarTestSuite {}
