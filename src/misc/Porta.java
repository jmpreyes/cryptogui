package misc;
/*

/**
 * This class defines the Porta cipher.
 * 
 * @author Joseph R.
 * @since April 14, 2020

public class Porta {
    // Ignore first row and first two columns since they are only "labels"
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
    
    //private final int MINIMUM_KEY_LENGTH = key.length() + 1;
    
    /**
     * Perform encryption of the given plaintext and key.
     * 
     * @param plainText the message to be encrypted
     * @param key the given key for encryption
     * @return encrypted ciphertext
    
    public String encrypt(String plainText, String key) {
        // Throw new Exception("Plain text must be less than key length: " + key.length);
        
        StringBuilder sb = new StringBuilder();
        plainText = plainText.toUpperCase().replaceAll("\\s+","");
        
        for (int i = 0; i < plainText.length(); i++)
            sb.append(getEncryptedCharacter(key.charAt(i), plainText.charAt(i)));
        
        return sb.toString();
    }
    
    /**
     * Determine key character from row[0] starting at column[2].
     * Begin reading from row[1] for i-th character of plaintext.
     * At row[i], read from column[2] match the i-th character of the key.
     * The intersection of the two characters on the table is the encrypted character.
     * 
     * @param key the character of the given key for encryption
     * @param targetEncryptChar the character of the plaintext to be encrypted
     * @return the encrypted character
    
    private char getEncryptedCharacter(char key, char targetEncryptChar) {
        for (int row = 1; row <= TABULA_RECTA.length; row++) {
            if (TABULA_RECTA[row][0] == key || TABULA_RECTA[row][1] == key) {
                for (int col = 2; col <= TABULA_RECTA[row].length; col++) {
                    if (TABULA_RECTA[0][col] == targetEncryptChar)
                        return TABULA_RECTA[row][col];
                }
            }
        }
        
        return targetEncryptChar;
    }
    
    /**
     * Perform decryption of given ciphertext.
     * 
     * @param cipherText the message to be decrypted
     * @param key the given key for decryption
     * @return original, decrypted plaintext
  
    public String decrypt(String cipherText, final String key) {
        // Throw new Exception("Cipher text must be less than key length: " + key.length);
        
        StringBuilder sb = new StringBuilder();
        cipherText = cipherText.toUpperCase().replaceAll("\\s+", "");
        
        for (int i = 0; i < cipherText.length(); i++)
            sb.append(getDecryptedCharacter(key.charAt(i), cipherText.charAt(i)));
        
        return sb.toString();
    }
    
    /**
     * Determine the key character from column [0] starting at row [1].
     * Begin reading from column [2] for i-th character of ciphertext.
     * At column[i], read from row[1] to match the i-th character of the key.
     * The intersection of the two characters on the table is the decrypted character.
     * 
     * @param key the character of the key for decryption
     * @param targetDecryptChar the character of the ciphertext to be decrypted
     * @return the decrypted character
    
    private char getDecryptedCharacter(char key, char targetDecryptChar) {
        for (int row = 1; row <= TABULA_RECTA.length; row++) {
            if (TABULA_RECTA[row][0] == key || TABULA_RECTA[row][1] == key) {
                for (int col = 2; col <= TABULA_RECTA[row].length; col++) {
                    if (TABULA_RECTA[row][col] == targetDecryptChar)
                        return TABULA_RECTA[0][col];
                }
            }
        }
        
        return targetDecryptChar;
    }

    /*
    /**
     * Determines whether or not the text is valid. A text is valid if it is 
     * non-empty and has at least 10 characters.
     * 
     * @param text the message to be encrypted or decrypted
     * @return true if text is non-empty and has at least 10 characters; false otherwise
    
    private boolean isValidText(String text) {
        return !text.isEmpty();
    }
    
    /**
     * Ensures that the key can be cyclically repeated to cover all characters 
     * of the plaintext or ciphertext.
     * 
     * @param key the given key for encryption or decryption
     * @param capacity the maximum length of the key
    
    public void ensureCapacity(String key, int capacity) {
        if (capacity > key.length())
            resize(key, capacity);
    }

    /**
     * Dynamically allocates more space for the key if it is not sufficient 
     * enough to cover all characters of the plaintext or ciphertext.
     * 
     * @param capacity the maximum length of the key
    
    private void resize(String key, int capacity) {
        char[] temp = new char[capacity];
        int index = 0;
        
        while (index < temp.length) {
            for (int i = 0; i < key.length() && index < temp.length; i++){
                temp[index] = key.charAt(i);
                index++;
            }
        }
        key = new String(temp);
    }
    
}

*/
