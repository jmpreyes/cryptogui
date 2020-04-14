/**
 * package crypto contains the implementation of various cryptographic styles.
 */
package crypto;

/**
 * This class defines the Porta cipher.
 * 
 * !!! Rough implementation. Need to rewrite this !!!
 * 
 * @author Joseph R.
 * @since April 14, 2020
 */
public class Porta {
    private static final int MINIMUM_KEY_LENGTH = 10;
    private char[] key;
    
    /*
        Ignore the first row and the first two columns since they're placeholders in the 2D array
        KEY: at row[0], begin reading from column[2]
        PLAIN TEXT -> CIPHER TEXT: 
            determine key character from row[0] starting at column[2]
            begin reading from row[1] for i-th character of plaintext
            at row[i], read from column[2] match the i-th character of the key
            intersection of the two characters on the table is the encrypted character
        CIPHER TEXT -> PLAIN TEXT:
            determine key character from column [0] starting at row [1]
            begin reading from column [2] for i-th character of ciphertext
            at column[i], read from row[1] to match the i-th character of the key
            intersection of the two characters on the table is the decrypted character
    */
    private final char[][] TABULA_RECTA = {
        {' ',' ','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
        {'A','B','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
    	{'C','D','O','P','Q','R','S','T','U','V','W','X','Y','Z','N','M','A','B','C','D','E','F','G','H','I','J','K','L'},
    	{'E','F','P','Q','R','S','T','U','V','W','X','Y','Z','N','O','L','M','A','B','C','D','E','F','G','H','I','J','K'},
        {'G','H','Q','R','S','T','U','V','W','X','Y','Z','N','O','P','K','L','M','A','B','C','D','E','F','G','H','I','J'},
    	{'I','J','R','S','T','U','V','W','X','Y','Z','N','O','P','Q','J','K','L','M','A','B','C','D','E','F','G','H','I'},
    	{'K','L','S','T','U','V','W','X','Y','Z','N','O','P','Q','R','I','J','K','L','M','A','B','C','D','E','F','G','H'},
    	{'M','N','T','U','V','W','X','Y','Z','N','O','P','Q','R','S','H','I','J','K','L','M','A','B','C','D','E','F','G'},
    	{'O','P','U','V','W','X','Y','Z','N','O','P','Q','R','S','T','G','H','I','J','K','L','M','A','B','C','D','E','F'},
    	{'Q','R','V','W','X','Y','Z','N','O','P','Q','R','S','T','U','F','G','H','I','J','K','L','M','A','B','C','D','E'},
    	{'S','T','W','X','Y','Z','N','O','P','Q','R','S','T','U','V','E','F','G','H','I','J','K','L','M','A','B','C','D'},
    	{'U','V','X','Y','Z','N','O','P','Q','R','S','T','U','V','W','D','E','F','G','H','I','J','K','L','M','A','B','C'},
    	{'W','X','Y','Z','N','O','P','Q','R','S','T','U','V','W','X','C','D','E','F','G','H','I','J','K','L','M','A','B'},
    	{'Y','Z','Z','N','O','P','Q','R','S','T','U','V','W','X','Y','B','C','D','E','F','G','H','I','J','K','L','M','A'},
    };
    
    public Porta(String key) {
        try {
            setKey(key);
        } catch (Exception ex) {}
    }

    public void setKey(String key) {
        try {
            if (key == null || key.length() < MINIMUM_KEY_LENGTH)
                throw new Exception();

            key = key.replaceAll("[\\d\\W]", "");
            this.key = key.trim().toUpperCase().toCharArray();
        } catch (Exception ex) {
            System.out.println("Invalid key. Key must have at least 10 "
                    + "characters and non-numeric.");
        }
    }
    
    /**
     * Perform encryption of the given plaintext.
     * 
     * @param plainText the message to be encrypted
     * @return encrypted ciphertext
     */
    public String encrypt(String plainText) {
        /*
        if (!isValidText(plainText))
            throw new Exception("Plain text must be less than key length: " + key.length);
        */
        
        StringBuilder sb = new StringBuilder();
        
        // skip the spaces in between characters
        plainText = plainText.replaceAll("\\s+","");
        
        for (int i = 0; i < plainText.length(); i++)
            sb.append(getEncryptedCharacter(key[i], plainText.charAt(i)));
        
        return sb.toString();
    }
    
    private char getEncryptedCharacter(char key, char plain) {
        for (int row = 1; row <= TABULA_RECTA.length; row++) {
            if (TABULA_RECTA[row][0] == key || TABULA_RECTA[row][1] == key) {
                for (int col = 2; col <= TABULA_RECTA[row].length; col++) {
                    if (TABULA_RECTA[0][col] == plain)
                        return TABULA_RECTA[row][col];
                }
            }
        }
        return plain;
    }
    
    /**
     * Perform decryption of given ciphertext.
     * 
     * @param cipherText the message to be decrypted
     * @return original, decrypted plaintext
     */
    public String decrypt(String cipherText) {
        /*
        if (!isValidText(cipherText)) 
            throw new Exception("Cipher text must be less than key length: " + key.length);
        */
        
        StringBuilder sb = new StringBuilder();
        cipherText = cipherText.replaceAll("\\s+", "");
        
        for (int i = 0; i < cipherText.length(); i++)
            sb.append(getDecryptedCharacter(key[i], cipherText.charAt(i)));
        
        return sb.toString();
    }
    
    private char getDecryptedCharacter(char key, char cipher) {
        for (int row = 1; row <= TABULA_RECTA.length; row++) {
            if (TABULA_RECTA[row][0] == key || TABULA_RECTA[row][1] == key) {
                for (int col = 2; col <= TABULA_RECTA[row].length; col++) {
                    if (TABULA_RECTA[row][col] == cipher)
                        return TABULA_RECTA[0][col];
                }
            }
        }
        return cipher;
    }

    /**
     * Determines whether or not the text is valid. A text is valid if it is 
     * non-empty and has at least 10 characters.
     * 
     * @param text the message to be encrypted or decrypted
     * @return true if text is non-empty and has at least 10 characters
     */
    private boolean isValidText(String text) {
        /*
        if (text != null)
            return true;
        else
            return false;
         */
        
        return !text.isEmpty();
    }
    
    /**
     * Ensures that the key can be cyclically repeated to cover all characters 
     * of the plaintext or ciphertext.
     * 
     * @param capacity the maximum length of the key
     */
    public void ensureCapacity(int capacity) {
        if (capacity > key.length)
            resize(capacity);
    }

    /**
     * Dynamically allocates more space for the key if it is not sufficient 
     * enough to cover all characters of the plaintext or ciphertext.
     * 
     * @param capacity the maximum length of the key
     */
    private void resize(int capacity) {
        char[] temp = new char[capacity];
        int index = 0;
        
        while (index < temp.length) {
            for (int i = 0; i < key.length && index < temp.length; i++){
                temp[index] = key[i];
                index++;
            }
        }
        key = temp;
    }
}
