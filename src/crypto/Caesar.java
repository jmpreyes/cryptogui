/**
 * package crypto contains the implementation of various cryptographic styles.
 */
package crypto;

/**
 * This class defines the Caesar cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public class Caesar {
    // Array of all meta characters to ignore from the text
    private final char[] METACHARS = {'<', '>', '(', ')', '[', ']', '{', '}', 
                                     '\\', '^', '-', '=', '$', '!', '|', '?', 
                                     '*', '+', '.', ',', '\'', '\"'};
    
    /**
     * Perform encryption operation given the plaintext and the key value.
     * 
     * @param plainText the text message for encryption
     * @param key the value for character shift
     * @return an encrypted text (ciphertext)
     */
    public String encrypt(String plainText, int key) {
        String cipherText = new String();
        plainText = plainText.toUpperCase();
        
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch != ' ' && !isAMetaChar(ch)) {
                if (ch >= 'A' && ch <= 'Z') {
                    int oldAlphaPos = ch - 'A';
                    int newAlphaPos = (oldAlphaPos + key) % 26;
                    cipherText += (char)(newAlphaPos + 'A');
                }
            } else if (isAMetaChar(ch)) {
                cipherText += ch;
            } else {
                cipherText += ' ';
            }
        }
        
        return cipherText;
    }
    
    /**
     * Perform decryption operation given the ciphertext and the key value.
     * 
     * @param cipherText the text message for decryption
     * @param key the value for character shift
     * @return the decrypted, original message (plaintext)
     */
    public String decrypt(String cipherText, int key) {
        String plainText = new String();
        cipherText = cipherText.toUpperCase();
        
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (ch != ' ' && !isAMetaChar(ch)) {
                int oldAlphaPos = ch - 'A';
                int newAlphaPos = oldAlphaPos - key;
                if (newAlphaPos < 0)
                    newAlphaPos += 26;
                plainText += (char)(newAlphaPos + 'A');
            } else if (isAMetaChar(ch)) {
                plainText += ch;
            } else {
                plainText += ' ';
            }
        }
        
        return plainText;
    }
    
    /**
     * Determine if character in the text is a meta character. If so, 
     * ignore it and add it to the resulting text after encryption or 
     * decryption.
     * 
     * @param ch the character in the text
     * @return true if the character is a meta character; false otherwise
     */
    private boolean isAMetaChar(char ch) {
        for (int i = 0; i < METACHARS.length; i++) {
            if (ch == METACHARS[i])
                return true;
        }
        
        return false;
    }
}
