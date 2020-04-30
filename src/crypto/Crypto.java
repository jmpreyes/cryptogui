package crypto;

/**
 * Abstract class for each cryptographic technique. Concrete class define each 
 * technique's encryption and decryption operations and other specifics.
 * 
 * @author Joseph R.
 * @since April 30, 2020
 */
public abstract class Crypto {
    /**
     * Define the original message.
     */
    protected String plaintext;
    
    /**
     * Define the encrypted message.
     */
    protected String ciphertext;
    
    /**
     * Define the key for encryption or decryption.
     */
    protected String key;

    /**
     * Sets the plaintext value.
     * 
     * @param plaintext the original message
     */
    public abstract void setPlaintext(String plaintext);
    
    /**
     * Sets the ciphertext value.
     * 
     * @param ciphertext the encrypted message
     */
    public abstract void setCiphertext(String ciphertext);
    
    /**
     * Sets the key value for shift or substitution.
     * 
     * @param key the key for encryption or decryption
     */
    public abstract void setKey(String key);
    
    /**
     * Returns the plaintext.
     * 
     * @return plaintext
     */
    public abstract String getPlaintext();
    
    /**
     * Returns the ciphertext.
     * 
     * @return ciphertext
     */
    public abstract String getCiphertext();
    
    /**
     * Returns the key.
     * 
     * @return key
     */
    public abstract String getKey();
    
    /**
     * Performs cryptographic encryption operation defined by sub-class.
     */
    public abstract void encrypt();
    
    /**
     * Performs cryptographic decryption operation defined by sub-class.
     */
    public abstract void decrypt();
}
