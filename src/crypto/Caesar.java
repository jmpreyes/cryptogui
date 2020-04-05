package crypto;

/**
 * This class defines the Caesar cryptographic technique.
 * It implements the CryptoStrat interface -- defines the two methods for 
 * respective encryption and decryption given the text and key.
 * 
 * @author Joseph
 * @version 1.0
 * @since January 13, 2020
 * @see CryptoStrat
 */
public class Caesar implements CryptoStrat {
    @Override
    public String performEncryption(String plaintext, int key) {
        return encrypt(plaintext, key);
    }
    
    @Override
    public String performDecryption(String ciphertext, int key) {
        return decrypt(ciphertext, key);
    }
    
    private String encrypt(String plainText, int key) {
        String cipherText = new String();
        plainText = plainText.toUpperCase();
        
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                int oldAlphaPos = ch - 'A';
                int newAlphaPos = (oldAlphaPos + key) % 26;
                cipherText += (char)(newAlphaPos + 'A');
            }
        }
        
        return cipherText;
    }
    
    private String decrypt(String cipherText, int key) {
        String plainText = new String();
        
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            int oldAlphaPos = ch - 'A';
            int newAlphaPos = oldAlphaPos - key;
            
            if (newAlphaPos < 0)
                newAlphaPos += 26;
            
            plainText += (char)(newAlphaPos + 'A');
        }
        
        return plainText;
    }
}
