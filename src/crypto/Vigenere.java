/**
 * package crypto contains the implementation of various cryptographic
 * techniques. Also contains the Strategy design pattern code.
 */
package crypto;

/**
 * This class simply defines the Vigenère cipher, a polyalphabetic cryptographic 
 * technique.
 * 
 * @author Joseph R.
 * @since April 8, 2020
 * @see crypto.CryptoStrat
 */
public class Vigenere implements CryptoStrat {
    /**
     * Ensure the key has the same length or same number of characters as 
     * the text for encryption or decryption. Essentially, the length of the 
     * text must be equal to the length of the key.
     * 
     * @param text the plaintext or the ciphertext
     * @param key the word needed for encryption or decryption
     * @return key which repeats until it matches text length
     */
    public String createValidKey(String text, String key) {
        int textLength = text.length();
        for (int i = 0; ; i++) {
            if (textLength == i)
                i = 0;
            if (key.length() == text.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }
    
    /**
     * Returns the encrypted message. Convert [A - Z] as respective 
     * integers [0 - 25] and then perform the encryption operation:
     * 
     * CT(i) = (PT(i) + K(i)) % 26
     * 
     * @param plainText the message to be encrypted
     * @param key the string for encryption
     * @return the encrypted ciphertext
     */
    private String encrypt(String plainText, String key) {
        String cipherText = new String();
        cipherText = cipherText.toUpperCase();
                
        for (int i = 0; i < plainText.length(); i++) {
            int numVal = (plainText.charAt(i) + key.charAt(i)) % 26;
            numVal += 'A';
            cipherText += (char)numVal;
        }
        
        return cipherText;
    }
    
    /**
     * Returns the decrypted message. Similar to the encryption process, but 
     * the decryption operation is:
     * 
     * PT(i) = (CT(i) - K(i) + 26) % 26
     * 
     * @param cipherText the message to be decrypted
     * @param key the string for decryption
     * @return the original plaintext
     */
    private String decrypt(String cipherText, String key) {
        String plainText = new String();
        plainText = plainText.toUpperCase();
        
        for (int i = 0; i < cipherText.length() && i < key.length(); i++) {
            int vals = (cipherText.charAt(i) - key.charAt(i) + 26) % 26;
            vals = vals + 'A';
            plainText = plainText + (char)vals;
        }
        
        return plainText;
    }
    /**
     * Perform Vigenère encryption.
     */
    @Override
    public String performEncryption(String plainText, String key) {
        return encrypt(plainText, key);
    }

    /**
     * Perform Vigenère decryption.
     */
    @Override
    public String performDecryption(String cipherText, String key) {
        return decrypt(cipherText, key);
    }
}
