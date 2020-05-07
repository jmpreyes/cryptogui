package driver;

import gui.MainMenu;
import javax.swing.SwingUtilities;

/**
 * This is the driver class (main class) of the program.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public class Driver {
    /**
     * Main method.
     * 
     * @param args command-line parameters
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu m = MainMenu.getInstance();
        });
    }
}
