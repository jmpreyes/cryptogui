package crypto;

/**
 * This class simply defines the Vigenère cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public class Vigenere {
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
    public String encrypt(String plainText, String key) {
        String cipherText = new String();
        plainText = plainText.toUpperCase();
                
        for (int i = 0; i < plainText.length(); i++) {
            int numVal = (plainText.charAt(i) + key.charAt(i)) % 26;
            numVal += 'A';
            cipherText += (char)(numVal);
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
    public String decrypt(String cipherText, String key) {
        String plainText = new String();
        cipherText = cipherText.toUpperCase();
        
        for (int i = 0; i < cipherText.length() && i < key.length(); i++) {
            int numVal = (cipherText.charAt(i) - key.charAt(i) + 26) % 26;
            numVal += 'A';
            plainText += (char)(numVal);
        }
        
        return plainText;
    }
}
