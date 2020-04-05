/**
 * package driver contains the main method of the application.
 */
package driver;

import gui.CryptoGUI;

/**
 * This class is the driver class (main class) of the program.
 * 
 * @author Joseph R.
 * @since January 13, 2020
 * @see gui.CryptoGUI
 */
public class Driver {
    /**
     * Main method.
     * @param args String arguments
     */
    public static void main(String[] args) {
        //CryptoGUI c = new CryptoGUI();
        CryptoGUI c = CryptoGUI.createInstance();
    }
}
