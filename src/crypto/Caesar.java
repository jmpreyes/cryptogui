package crypto;

/**
 * This class defines the Caesar cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public class Caesar extends Crypto {
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
     * Performs Caesar cipher encryption.
     */
    @Override
    public void encrypt() {
        String ptext = getPlaintext();
        String ctext = new String();
        int encKey = Integer.valueOf(getKey());
        ptext = ptext.toUpperCase();
        
        for (int i = 0; i < ptext.length(); i++) {
            char ch = ptext.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch >= 'A' && ch <= 'Z') {
                    int oldAlphaPos = ch - 'A';
                    int newAlphaPos = (oldAlphaPos + encKey) % 26;
                    ctext += (char)(newAlphaPos + 'A');
                }
            } else if (super.isAMetaChar(ch)) {
                ctext += ch;
            } else {
                ctext += ' ';
            }
        }
        
        setCiphertext(ctext);
    }

    /**
     * Performs Caesar cipher decryption.
     */
    @Override
    public void decrypt() {
        String ctext = getCiphertext();
        String ptext = new String();
        int decKey = Integer.valueOf(getKey());
        ctext = ctext.toUpperCase();
        
        for (int i = 0; i < ctext.length(); i++) {
            char ch = ctext.charAt(i);
            if (Character.isLetter(ch)) {
                int oldAlphaPos = ch - 'A';
                int newAlphaPos = oldAlphaPos - decKey;
                if (newAlphaPos < 0)
                    newAlphaPos += 26;
                ptext += (char)(newAlphaPos + 'A');
            } else if (super.isAMetaChar(ch)) {
                ptext += ch;
            } else {
                ptext += ' ';
            }
        }
        
        setPlaintext(ptext);
    }
}
