package crypto;

/**
 * This class defines the Vigenère cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 * @see crypto.Crypto
 */
public class Vigenere extends Crypto {    
    /**
     * Performs Vigenère cipher encryption.
     */
    @Override
    public void encrypt() {
        String ptext = getPlaintext();
        setKey(createValidKey(ptext, getKey()));
        String encKey = getKey();
        ptext = ptext.toUpperCase();
        
        int numVal = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ptext.length(); i++) {
            char ch = ptext.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                numVal = (ch + encKey.charAt(i)) % 26;
                numVal += 'A';
                sb.append((char)(numVal));
            } else {
                numVal += 0;
                sb.append(ch);
            }
        }
        
        setCiphertext(sb.toString());
    }

    /**
     * Performs Vigenère cipher decryption.
     */
    @Override
    public void decrypt() {
        String ctext = getCiphertext();
        setKey(createValidKey(ctext, getKey()));
        String decKey = getKey();
        ctext = ctext.toUpperCase();
        
        int numVal = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ctext.length() && i < decKey.length(); i++) {
            char ch = ctext.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                numVal = (ch - decKey.charAt(i) + 26) % 26;
                numVal += 'A';
                sb.append((char)(numVal));
            } else {
                numVal += 0;
                sb.append(ch);
            }
        }
        
        setPlaintext(sb.toString());
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
