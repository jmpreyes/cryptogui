package crypto;

/**
 * Abstract class for each cryptographic technique. Concrete class define each 
 * technique's encryption and decryption operations and other specifics.
 * 
 * @author Joseph R.
 * @since April 30, 2020
 */
public abstract class Crypto {
    protected final char[] METACHARS = {'<', '>', '(', ')', '[', ']', '{', '}', 
                                       '\\', '^', '-', '=', '$', '!', '|', '?', 
                                        '*', '+', '.', ',', '\'', '\"'};
    
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
