package crypto;

/**
 * This class simply defines the Vigenère cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public class Vigenere extends Crypto {
    /**
     * Sets the plaintext value.
     * 
     * @param plaintext the original message
     */
    @Override
    public void setPlaintext(String plaintext) {
        super.plaintext = plaintext;
    }
    
    /**
     * Sets the ciphertext value.
     * 
     * @param ciphertext the encrypted message
     */
    @Override
    public void setCiphertext(String ciphertext) {
        super.ciphertext = ciphertext;
    }
    
    /**
     * Sets the key value for shift or substitution.
     * 
     * @param key the key for encryption or decryption
     */
    @Override
    public void setKey(String key) {
        super.key = key;
    }
    
    /**
     * Returns the plaintext.
     * 
     * @return plaintext
     */
    @Override
    public String getPlaintext() {
        return super.plaintext;
    }
    
    /**
     * Returns the ciphertext.
     * 
     * @return ciphertext
     */
    @Override
    public String getCiphertext() {
        return super.ciphertext;
    }
    
    /**
     * Returns the key.
     * 
     * @return key
     */
    @Override
    public String getKey() {
        return super.key;
    }
    
    /**
     * Performs cryptographic encryption operation defined by sub-class.
     */
    @Override
    public void encrypt() {
        String ptext = getPlaintext();
        String ctext = new String();
        setKey(createValidKey(ptext, getKey()));
        String encKey = getKey();
        ptext = ptext.toUpperCase();
        
        int numVal = 0;
        for (int i = 0; i < ptext.length(); i++) {
            char ch = ptext.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                numVal = (ch + encKey.charAt(i)) % 26;
                numVal += 'A';
                ctext += (char)(numVal);
            } else {
                numVal += 0;
                ctext += ch;
            }
        }
        
        setCiphertext(ctext);
    }

    /**
     * Performs cryptographic decryption operation defined by sub-class.
     */
    @Override
    public void decrypt() {
        String ctext = getCiphertext();
        String ptext = new String();
        setKey(createValidKey(ctext, getKey()));
        String decKey = getKey();
        ctext = ctext.toUpperCase();
        
        int numVal = 0;
        for (int i = 0; i < ctext.length() && i < decKey.length(); i++) {
            char ch = ctext.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                numVal = (ch - decKey.charAt(i) + 26) % 26;
                numVal += 'A';
                ptext += (char)(numVal);
            } else {
                numVal += 0;
                ptext += ch;
            }
        }
        
        setPlaintext(ptext);
    }
    
    /**
     * Ensure the key has the same length or same number of characters as 
     * the text for encryption or decryption. Essentially, the length of the 
     * text must be equal to the length of the key.
     * 
     * @param text the plaintext or the ciphertext
     * @param key the word needed for encryption or decryption
     * @return key which repeats until it matches text length
     */
    private String createValidKey(String text, String key) {
        key = key.toUpperCase();
        
        for (int i = 0; i < text.length(); i++) {
            if (i == text.length())
                i = 0;
            if (text.length() == key.length())
                break;
            key += (key.charAt(i));
        }
        
        return key;
    }
}
