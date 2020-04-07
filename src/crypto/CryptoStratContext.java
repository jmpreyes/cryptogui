/**
 * package crypto contains the implementation of various cryptographic 
 * techniques. Also contains the Strategy design pattern code.
 */
package crypto;

/**
 * Strategy design pattern: decide which object of a certain technique to use 
 * at runtime. The methods are overridden and respectively defined in 
 * the specific classes.
 * 
 * @author Joseph R.
 * @since April 3, 2020
 * @see crypto.CryptoStrat
 */
public class CryptoStratContext {
    private CryptoStrat cs;
    
    /**
     * Ensures the same instance of <code>CryptoStrat</code> is used and 
     * referenced correctly.
     * 
     * @param cs instance of <code>CryptoStrat</code>
     */
    public CryptoStratContext(CryptoStrat cs) {
        this.cs = cs;
    }
    
    /**
     * Performs the encryption operation of a cryptographic technique given 
     * a text and a key value.
     * 
     * @param plainText the message to be encrypted
     * @param key the value for character shift or substitution
     * @return the encrypted text (ciphertext)
     */
    public String executeEncryption(String plainText, String key) {
        return cs.performEncryption(plainText, key);
    }
    
    /**
     * Performs the decryption operation of a cryptographic technique given 
     * a text and a key value.
     * 
     * @param cipherText the message to be decrypted
     * @param key the value to shift or substitute message back to original text 
     * @return the decrypted text (plaintext)
     */
    public String executeDecryption(String cipherText, String key) {
        return cs.performDecryption(cipherText, key);
    }
}
