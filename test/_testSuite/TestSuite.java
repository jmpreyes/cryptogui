package _testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suit for all cipher unit tests.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
    testCaesarCrypto.TestCaesarEncryption.class,
    testCaesarCrypto.TestCaesarDecryption.class,
    testPortaCrypto.TestPortaEncryption.class,
    testPortaCrypto.TestPortaDecryption.class,
    testVigenereCrypto.TestVigenereEncryption.class,
    testVigenereCrypto.TestVigenereDecryption.class
})

public class TestSuite {}
