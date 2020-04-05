/**
 * package crypto contains the implementation of various cryptanalysis 
 * techniques. Also contains the Strategy design pattern code.
 */
package crypto;

/**
 * Strategy design pattern: decide which object of a certain technique to use 
 * at runtime.
 * 
 * @author Joseph R.
 * @since April 3, 2020
 * @see crypto.CryptoStrat
 */
public class CryptoStratContext {
    private CryptoStrat cs;
    
    public CryptoStratContext(CryptoStrat cs) {
        this.cs = cs;
    }
    
    public String executeEncryption(String plaintext, int key) {
        return cs.performEncryption(plaintext, key);
    }
    
    public String executeDecryption(String ciphertext, int key) {
        return cs.performDecryption(ciphertext, key);
    }
}
