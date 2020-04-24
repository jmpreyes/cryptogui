package gui;

import javax.swing.JFrame;

/**
 * Abstract class of each interface to be created. This is an attempt to 
 * reduce code redundancy.
 * 
 * @author Joseph R.
 * @since April 24, 2020
 */
public abstract class Gui extends JFrame {
    /**
     * Title of the frame.
     */
    protected String title = "CryptoGUI -- Cryptic Messages";
    
    /**
     * Set the title of the frame.
     */
    public Gui() {
        setTitle(title);
    }
    
    /**
     * Define interface menu bar and its menu items.
     */
    public abstract void addMenuBar();
    
    /**
     * Define text areas and panels of interface.
     */
    public abstract void addContentPanel();
    
    /**
     * Define a set of buttons and its functionality.
     */
    public abstract void addButtons();
    
    /**
     * Compiles all panels into the frame.
     */
    public abstract void addPanelsToFrame();
    
    /**
     * Define operations on close and other frame properties.
     */
    public abstract void setFrameProperties();
}
