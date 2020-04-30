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
})

public class TestSuite {}
