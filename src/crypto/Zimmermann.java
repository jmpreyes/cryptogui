package crypto;

import java.io.*;
import java.util.*;

/**
 * Rough implementation of Zimmermann cipher so far.
 * 
 * @author Joseph R.
 * @since April 17, 2020
 */
public class Zimmermann {
    private Map<String, String> codeBook;

    /**
     * Set the keys and values of the code book.
     * 
     * @param codeBook the key-value map
     */
    public void setCodeBook(Map<String, String> codeBook) {
        this.codeBook = codeBook;
    }
    
    /**
     * Return the key-value map.
     * 
     * @return codeBook the key-value map
     */
    public final Map<String, String> getCodeBook() {
        return codeBook;
    }
    
    /**
     * Read the contents of a given file name.
     * 
     * @param fileName the name of the file
     */
    public Zimmermann(String fileName) {
        populateCodeBook(fileName);
    }
    
    /**
     * Read the file and store its data into a map. Each word in the file has 
     * a corresponding integer value as the key-value pair. 
     * Throws <code>FileNotFoundException</code> if the given file does not 
     * exist or is not valid. 
     * Throws <code>IOException</code> if <code>BufferedReader</code> is null.
     * 
     * @param fileName the name of the file
     */
    private void populateCodeBook(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
            Map<String, String> map = new LinkedHashMap();

            String lineToRead;          // the next line to read from file
            String readWord;            // the current word that is read
            String replacedWord;        // the word after replacement is made
            StringTokenizer strtok;     // separate each word as tokens

            // Generate a random number up to 99999
            Random r = new Random();
            int codeNum;

            while ((lineToRead = br.readLine()) != null) {
                // Parse each line and separate each word (token) after delimiter
                strtok = new StringTokenizer(lineToRead, " ");
                while (strtok.hasMoreTokens()) {
                    readWord = strtok.nextToken();
                    
                    // Use regex to replace all special characters or symbols with ""
                    replacedWord = readWord.replaceAll(
                            "[|,|.|\\,||\"||:|~|!|-|@|#|$|%|^|&|*|_|+|=|<|>|?|\\(|\\)|\\[|\\]|\\{|\\}|\\;|\\\']", 
                            "").toUpperCase();
                    
                    // Assign a random number to each word and add <K, V> pair to the map
                    codeNum = r.nextInt(90000) + 10000;
                    map.put(replacedWord, String.valueOf(codeNum));
                }
            }
            setCodeBook(map);
            br.close();
        } catch (FileNotFoundException ex) {
            //System.out.println(ex.getMessage());
        } catch (IOException ex) {
            //System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Retain encrypted numerical values.
     */
    public void encrypt() {
        Map<String, String> map = getCodeBook();
        Collection<String> vals = map.values();
        String[] arr = vals.toArray(new String[vals.size()]);
        int count = 0;
        for (String s : arr) {
            System.out.print(s + " ");
            count++;
            if (count % 5 == 0)
                System.out.print("\n");
        }
        
        System.out.println();
    }
    
    /**
     * Retain decrypted, original words.
     */
    public void decrypt() {
        Map<String, String> map = getCodeBook();
        Collection<String> keys = map.keySet();
        String[] arr = keys.toArray(new String[keys.size()]);
        int count = 0;
        
        for (String s : arr) {
            System.out.print(s + " ");
            count++;
            if (count % 5 == 0)
                System.out.print("\n");
        }
        
        System.out.println();
    }
    
    /*
    // Debug -- S.O.P. to the console
    public void printCodeBook() {
        Map<String, String> map = getCodeBook();
        int wordCount = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //System.out.print(entry.getValue().toString() + " ");
            System.out.println(entry.getKey() + " : " + entry.getValue());
            wordCount++;
            if (wordCount % 5 == 0)
                System.out.print("\n");
        }
    }
    */
}
