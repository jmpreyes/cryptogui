package crypto;

import gui.ZimmermannGUI;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * This class defines the Zimmermann cipher.
 * 
 * @author Joseph R.
 * @since May 6, 2020
 * @see crypto.Crypto
 */
public class Zimmermann extends Crypto {
    /**
     * Performs Zimmermann cipher encryption.
     */
    @Override
    public void encrypt() {
        populateCodeBook();
        Map<String, String> map = getCodeBook();
        Collection<String> vals = map.values();
        String[] encValsArr = vals.toArray(new String[vals.size()]);
        setEncValsArr(encValsArr);
    }

    /**
     * Performs Zimmermann cipher decryption.
     */
    @Override
    public void decrypt() {
        Map<String, String> map = getCodeBook();
        Collection<String> keys = map.keySet();
        String[] decWordsArr = keys.toArray(new String[keys.size()]);
        setDecWordsArr(decWordsArr);
    }
    
    /**
     * Read from given text area and encode with random 5-digit numbers. 
     * Each words receives a code and the key-value pairs are stored in a map.
     */
    private void populateCodeBook() {
        Map<String, String> map = new LinkedHashMap();
        StringTokenizer strtok;
        Random r = new Random();
        int codeNum;
        
        String readWord;
        String replacedWord;
        
        for (String line : ZimmermannGUI.getInstance().getInputTextArea().getText().split("\\n")) {
            strtok = new StringTokenizer(line, " ");
            
            while (strtok.hasMoreTokens()) {
                readWord = strtok.nextToken();
                replacedWord = readWord.replaceAll(SPEC_CHARS, "").toUpperCase();
                codeNum = r.nextInt(99999) + 10000;
                map.put(replacedWord, String.valueOf(codeNum));   
            }
        }
        
        setCodeBook(map);
    }
}
