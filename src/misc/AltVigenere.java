/*
 * *** Use crypto.Vigenere.java instead ***
 */
package misc;

/*
/**
 * This class defines the Vigenère cipher using a 2-D table of characters for 
 * poly-alphabetic manipulation.
 * 
 * This is a work in progress. Need to check unit tests.
 * 
 * @author Joseph R.
 * @since April 7, 2020
 * @see crypto.CryptoStrat

public class AltVigenere implements CryptoStrat {
    private char[][] tabulaRecta = { 
            {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
            {'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
            {'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
            {'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
            {'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
            {'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
            {'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
            {'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
            {'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
            {'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
            {'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
            {'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
            {'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
            {'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
            {'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
            {'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
            {'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
            {'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
            {'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
            {'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
            {'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
            {'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
            {'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
            {'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
            {'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
            {'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'}
    };
    
    @Override
    public String performEncryption(String plainText, String key) {
        return encrypt(plainText, key);
    }

    @Override
    public String performDecryption(String cipherText, String key) {
        return decrypt(cipherText, key);
    }
    
    /**
     * Returns the encrypted message after the characters in plaintext are 
     * replaced on the table given the key value.
     * 
     * @param plainText the message to be encrypted
     * @param key the value for encryption
     * @return the encrypted ciphertext
    
    private String encrypt(String plainText, String key) {
        StringBuilder sb = new StringBuilder();
        plainText = plainText.toUpperCase();
        
        for (int i = 0; i < plainText.length(); i++)
            sb.append(getEncryptedChar(plainText.charAt(i), key.charAt(i)));
        
        return sb.toString();
    }
    
    /**
     * Returns the encrypted character. Read down and across to match the 
     * plaintext and key characters and return the character in which they 
     * intersect on the character table.
     * 
     * @param plainTextChar the letter in the plaintext
     * @param key the letter in the key used for encryption
     * @return the character for encryption to replace the plaintext character
    
    private char getEncryptedChar(char plainTextChar, char key) {
        for (int row = 0; row < tabulaRecta.length; row++) {
            if (tabulaRecta[row][0] == key) {
                for (int col = 0; col < tabulaRecta[row].length; col++) {
                    if (tabulaRecta[0][col] == plainTextChar)
                        return tabulaRecta[row][col];
                }
            }
        }
        return plainTextChar;
    }
    
    /**
     * Returns the decrypted message after the characters in ciphertext are 
     * replaced on the table given the key value.
     * 
     * @param cipherText the message to be decrypted
     * @param key the value for decryption
     * @return the original plaintext
     
    private String decrypt(String cipherText, String key) {
        StringBuilder sb = new StringBuilder();
        cipherText = cipherText.toUpperCase();
        
        for (int i = 0; i < cipherText.length(); i++)
            sb.append(getDecryptedChar(cipherText.charAt(i), key.charAt(i)));
        
        return sb.toString();
    }
    
    /**
     * Returns the decrypted character. Read across and down to match the 
     * ciphertext and key characters and return the character in which they 
     * intersect on the character table.
     * 
     * @param cipherTextChar the letter in the ciphertext
     * @param key the letter in the key used for decryption
     * @return the character for decryption to replace the ciphertext character
    
    private char getDecryptedChar(char cipherTextChar, char key) {
        for (int col = 0; col < tabulaRecta[0].length; col++) {
            if (tabulaRecta[0][col] == key) {
                for (int row = 0; row < tabulaRecta.length; row++) {
                    if (tabulaRecta[row][col] == cipherTextChar)
                        return tabulaRecta[row][0];
                }
            }
        }
        return cipherTextChar;
    }
}
*/
