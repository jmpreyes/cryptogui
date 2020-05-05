package crypto;

/**
 * Abstract class for each cryptographic technique. Concrete class define each 
 * technique's encryption and decryption operations and other specifics.
 * 
 * @author Joseph R.
 * @since April 30, 2020
 */
public abstract class Crypto {
    private String plaintext;       // the original message
    private String ciphertext;      // the encrypted message
    private String key;             // the key needed for encryption/decryption
    
    /**
     * Define array of special characters.
     */
    protected final char[] METACHARS = {'<', '>', '(', ')', '[', ']', '{', '}', 
                                       '\\', '^', '-', '=', '$', '!', '|', '?', 
                                        '*', '+', '.', ',', '\'', '\"'};
    
    /**
     * Determine if character in the text is a meta character. If so, 
     * ignore it and add it to the resulting text after encryption or 
     * decryption.
     * 
     * @param ch the character in the text
     * @return true if the character is a meta character; false otherwise
     */
    protected boolean isAMetaChar(char ch) {
        for (int i = 0; i < METACHARS.length; i++) {
            if (ch == METACHARS[i])
                return true;
        }
        
        return false;
    }
    
    /**
     * Sets the plaintext value.
     * 
     * @param plaintext the original message
     */
    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }
    
    /**
     * Sets the ciphertext value.
     * 
     * @param ciphertext the encrypted message
     */
    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }
    
    /**
     * Sets the key value for shift or substitution.
     * 
     * @param key the key for encryption or decryption
     */
    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * Returns the plaintext.
     * 
     * @return plaintext
     */
    public String getPlaintext() {
        return this.plaintext;
    }
    
    /**
     * Returns the ciphertext.
     * 
     * @return ciphertext
     */
    public String getCiphertext() {
        return this.ciphertext;
    }
    
    /**
     * Returns the key.
     * 
     * @return key
     */
    public String getKey() {
        return this.key;
    }
    
    /**
     * Override toString() method to show output to screen.
     * 
     * @return message
     */
    @Override
    public String toString() {
        return "P = " + this.plaintext + 
             "\nK = " + this.key + 
             "\nC = " + this.ciphertext;
    }
    
    /**
     * Performs cryptographic encryption operation defined by sub-class.
     */
    public abstract void encrypt();
    
    /**
     * Performs cryptographic decryption operation defined by sub-class.
     */
    public abstract void decrypt();
}
