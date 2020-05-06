package crypto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
     * Constructor reads from given file and populates the code book.
     * 
     * @param fileName the name of file to read from
     */
    public Zimmermann(String fileName) {
        setFileName(fileName);
        populateCodeBook(getFileName());
    }

    /**
     * Performs Zimmermann cipher encryption.
     */
    @Override
    public void encrypt() {
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
     * Contents read from given file are encoded with random 5-digit numbers. 
     * Each words receives a code and the key-value pairs are stored in a map.
     * 
     * Throws FileNotFoundException if given file name does not exist.
     * Throws IOException if there's an error with input stream.
     * 
     * @param fileName the name of file to read from
     */
    private void populateCodeBook(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            Map<String, String> map = new LinkedHashMap();
            Random r = new Random();
            int codeNum;

            String lineToRead;          // the next line to read from file
            String readWord;            // the current word that is read
            String replacedWord;        // the word after replacement is made
            StringTokenizer strtok;     // separate each word as tokens

            // read each word (token) while !E.O.F.
            while ((lineToRead = br.readLine()) != null) {
                strtok = new StringTokenizer(lineToRead, " ");
                while (strtok.hasMoreTokens()) {
                    readWord = strtok.nextToken();
                    replacedWord = readWord.replaceAll(SPEC_CHARS, "").toUpperCase();
                    
                    // generate a random number up to 99999
                    codeNum = r.nextInt(90000) + 10000;
                    
                    // assign a random number to each word and add <K, V> pair to the map
                    map.put(replacedWord, String.valueOf(codeNum));
                }
            }
            
            setCodeBook(map);
            br.close();
        } catch (FileNotFoundException ex) {
            // add logger class here
            System.out.println("Exception: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
