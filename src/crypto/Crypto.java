package crypto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Abstract class for each cryptographic technique. Concrete class define each 
 * technique's encryption and decryption operations and other specifics.
 * 
 * @author Joseph R.
 * @since April 30, 2020
 */
public abstract class Crypto {
    private String plaintext;               // the original message
    private String ciphertext;              // the encrypted message
    private String key;                     // the key needed for encryption/decryption
    private String fileName;                // name of file to read from
    private Map<String, String> codeBook;   // key-value pair for Zimmermann cipher
    private String[] encVals;               // array of encoded values for Zimmermann
    private String[] decWords;              // array of decoded words for Zimmermann
    
    /**
     * Define special characters.
     */
    public final String SPEC_CHARS = "[|,|.|\\,||\"||:|~|!|-|@|#|$|%|^|&|*|_|+|=|<|>|?|\\(|\\)|\\[|\\]|\\{|\\}|\\;|\\\']";
    
    /**
     * Determine if character in the text is a meta character. If so, 
     * ignore it and add it to the resulting text after encryption or 
     * decryption.
     * 
     * @param ch the character in the text
     * @return true if the character is a meta character; false otherwise
     */
    public boolean isAMetaChar(char ch) {
        for (int i = 0; i < SPEC_CHARS.length(); i++) {
            if (ch == SPEC_CHARS.charAt(i))
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
     * Sets the file name.
     * 
     * @param fileName the name of the file to read from 
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Sets the code book containing key-value pairs.
     * 
     * @param codeBook the map of key-value pairs
     */
    public void setCodeBook(Map<String, String> codeBook) {
        this.codeBook = codeBook;
    }

    /**
     * Sets the array of encrypted values.
     * 
     * @param encVals the array of encrypted values
     */
    public void setEncValsArr(String[] encVals) {
        this.encVals = Arrays.copyOf(encVals, encVals.length);
    }
    
    /**
     * Sets the array of decrypted words.
     * 
     * @param decWords the array of decrypted words
     */
    public void setDecWordsArr(String[] decWords) {
        this.decWords = Arrays.copyOf(decWords, decWords.length);
    }
    
    /**
     * Returns the plaintext.
     * 
     * @return plaintext the original message
     */
    public String getPlaintext() {
        return this.plaintext;
    }
    
    /**
     * Returns the ciphertext.
     * 
     * @return ciphertext the encrypted message
     */
    public String getCiphertext() {
        return this.ciphertext;
    }
    
    /**
     * Returns the key.
     * 
     * @return key the key for shifting or substituting
     */
    public String getKey() {
        return this.key;
    }
    
    /**
     * Returns the file name.
     * 
     * @return fileName the name of file to read from
     */
    public String getFileName() {
        return this.fileName;
    }
    
    /**
     * Returns the map of key-value pairs.
     * 
     * @return codeBook the map of key-value pairs
     */
    public Map<String, String> getCodeBook() {
        return this.codeBook;
    }
    
    /**
     * Returns the array of encrypted values.
     * 
     * @return encValsArr the array of encrypted values
     */
    public String[] getEncValsArr() {
        return Arrays.copyOf(encVals, encVals.length);
    }
    
    /**
     * Returns the array of decrypted words.
     * 
     * @return decWordsArr the array of decrypted words
     */
    public String[] getDecWordsArr() {
        return Arrays.copyOf(decWords, decWords.length);
    }
    
    /**
     * Prints the array of encrypted values in columns of 5.
     * 
     * @return sb the string of encrypted codes
     */
    public String printCodes() {        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (String s : getEncValsArr()) {
            sb.append(s).append(" ");
            count++;
            
            if (count % 5 == 0)
                sb.append("\n");
        }
        
        return sb.toString();
    }
    
    /**
     * Prints the array of decrypted words in columns of 5.
     * 
     * @return sb the string of decrypted words
     */
    public String printWords() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (String s : getDecWordsArr()) {
            sb.append(s).append(" ");
            count++;
            
            if (count % 5 == 0)
                sb.append("\n");
        }
        
        return sb.toString();
    }
    
    /**
     * Override toString() method to show output to screen.
     * 
     * @return message output to screen
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
