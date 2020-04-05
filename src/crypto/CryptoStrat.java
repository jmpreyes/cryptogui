/**
 * package crypto contains the implementation of various cryptanalysis 
 * techniques. Also contains the Strategy design pattern code.
 */
package crypto;

/**
 * Strategy design pattern: interface which includes (for now) encryption and 
 * decryption methods. Each method involves a text (<code>String</code>) and a 
 * key value for the shift (<code>int</code>). These methods are defined by 
 * classes which implement it.
 * 
 * @author Joseph R.
 * @since April 3, 2020
 * @see crypto.CryptoStratContext
 */
public interface CryptoStrat {
    /**
     * Performs the encryption operation.
     * 
     * @param plaintext the original text given for encoding
     * @param key the integer value needed for the character shift
     * @return encrypted ciphertext
     */
    public String performEncryption(String plaintext, int key);
    
    /**
     * Performs the decryption operation.
     * 
     * @param ciphertext the text which needs to be decoded
     * @param key the integer value needed for decryption of the text
     * @return decrypted plaintext
     */
    public String performDecryption(String ciphertext, int key);
}
