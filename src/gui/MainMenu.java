/**
 * package gui implements the user interface of the application.
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates the window for the main menu.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 * @see gui.CaesarGUI
 */
public class MainMenu extends JFrame {
    // Radio buttons and group for selection
    private final JRadioButton caesarRadioBtn;
    private final JRadioButton vigenereRadioBtn;
    private final ButtonGroup radioBtnGroup;
    
    // Label for header text
    private final JLabel topLabel;
    
    // Panels
    private final JPanel topPanel;
    private final JPanel radioGroupPanel;
    private final JPanel btnPanel;
    
    // Button
    private final JButton selectBtn;
    
    private final int FRAME_WIDTH = 350;
    private final int FRAME_HEIGHT = 150;
    
    // Singleton design pattern
    private static final MainMenu MENU_OBJ = new MainMenu();
    
    /**
     * Ensures that only one instance of <code>MainMenu</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>MainMenu</code>
     */
    public static MainMenu createMainMenuInstance() {
        if (MENU_OBJ != null)
            return MENU_OBJ;
        
        return new MainMenu();
    }
    
    private MainMenu() {
        super("CryptoGUI -- Cryptic Messages");
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        
        // Prompt confirmation to exit when user tries to close the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (exitCode == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        
        // Creating the top partfor the header label
        // and adding it to the top panel
        topPanel = new JPanel();
        topLabel = new JLabel("Select Cryptographic Technique");
        topPanel.add(topLabel);
        
        // Creating a panel for the radio button group
        // and adding the radio buttons to that group
        radioGroupPanel = new JPanel(new GridLayout(2, 1));
        caesarRadioBtn = new JRadioButton("Caesar Cipher");
        vigenereRadioBtn = new JRadioButton("Vigenère Cipher");
        radioBtnGroup = new ButtonGroup();
        radioBtnGroup.add(caesarRadioBtn);
        radioBtnGroup.add(vigenereRadioBtn);
        radioGroupPanel.add(caesarRadioBtn);
        radioGroupPanel.add(vigenereRadioBtn);
        
        // Creating the panel for the button and adding the button to the panel
        btnPanel = new JPanel();
        selectBtn = new JButton("Select");
        btnPanel.add(selectBtn);
        
        // Determine which radio button is selected 
        // and which cipher to use
        selectBtn.addActionListener((ActionEvent e) -> {
            if (caesarRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Continue with " + caesarRadioBtn.getText() + "?", 
                        "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    CaesarGUI.createInstance();
                    dispose();
                    setVisible(false);
                }
            }
            else if (vigenereRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Continue with " + vigenereRadioBtn.getText() + "?", 
                        "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    VigenereGUI.createInstance();
                    dispose();
                    setVisible(false);
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Please select an option");
                // stub
            }
        });
        
        // Add the respective panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(radioGroupPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
