/**
 * package gui implements the user interface of the application.
 */
package gui;

import crypto.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Create the frame/window on screen with its buttons, text areas, and 
 * other properties. Strategy and Singleton design patterns are implemented 
 * for practice.
 * 
 * @author Joseph R.
 * @since April 3, 2020
 * @see crypto.CryptoStratContext
 */
public class CryptoGUI extends JFrame{
    // Text areas
    private final JTextArea inputTextArea;
    private final JTextArea outputTextArea;
    
    // Text field
    private final JTextField keyTextField;
    
    // Buttons
    private final JButton encryptBtn;
    private final JButton decryptBtn;
    private final JButton clearBtn;
    private final JButton moveBtn;
    private final JButton quitBtn;
    
    // Panels
    private final JPanel topPanel;
    private final JPanel btnPanel;
    private final JPanel textPanel;
    
    // Scroll panes
    private final JScrollPane inputTextAreaScrollPane;
    private final JScrollPane outputTextAreaScrollPane;
    
    // Label
    private final JLabel keyLabel;
    
    // Menu bar and menu items
    private final JMenuBar menuBar;
    private final JMenu fileMenu;
    private final JMenu optionsMenu;
    private final JMenu helpMenu;
    private final JMenuItem saveMenuItem;
    private final JMenuItem switchMenuItem;
    private final JMenuItem quitMenuItem;
    private final JMenuItem aboutMenuItem;
    
    // Frame width
    private final int FRAME_WIDTH = 650;
    // Frame height
    private final int FRAME_HEIGHT = 500;
    // Strategy design pattern
    private static CryptoStratContext cs;
    // Singleton design pattern
    private static final CryptoGUI GUI_OBJ = new CryptoGUI();
    
    /**
     * Singleton implementation: create only one JFrame object. Object creation 
     * is done by invoking <code>CrypoGUI.createInstance()</code> instead of 
     * calling its class constructor.
     * 
     * @return only one object of CryptoGUI
     */
    public static CryptoGUI createInstance() {
        if (GUI_OBJ != null)
            return GUI_OBJ;
        
        return new CryptoGUI();
    }
    
    /**
     * Singleton implementation: allow only one instance of the frame at once. 
     * The constructor creates the frame, its buttons, and associating 
     * properties. Event handling is implemented for the buttons.
     */
    private CryptoGUI() {
        // Frame properties
        super("CryptoGUI -- Cryptic Messages");
        setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        
        // Prompt confirmation to exit when user tries to close the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                int exitCode = JOptionPane.showConfirmDialog(rootPane, "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (exitCode == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
            }
        });
        
        // Creating a menu bar and its items
        menuBar = new JMenuBar();
        
        // "File" menu
        fileMenu = new JMenu("File");
        saveMenuItem = new JMenuItem("Save Output File");
        quitMenuItem = new JMenuItem("Quit");
        
        saveMenuItem.addActionListener((ActionEvent e) -> {
            // STUB
            JOptionPane.showMessageDialog(rootPane, "Work in progress.");
        });
        
        quitMenuItem.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        
        // "Options" menu
        optionsMenu = new JMenu("Options");
        switchMenuItem = new JMenuItem("Change Cryptanalysis Technique");
        
        switchMenuItem.addActionListener((ActionEvent e) -> {
            // STUB
            JOptionPane.showMessageDialog(rootPane, "Work in progress.");
        });
        
        // "Help" menu
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About Project");
        
        aboutMenuItem.addActionListener((ActionEvent e) -> {
           JOptionPane.showMessageDialog(rootPane, "Written by Joe R.\nApril 2020\nEmail at foo@foo.com"); 
        });
        
        // Adding the menu items to the "Options" menu bar
        fileMenu.add(saveMenuItem);
        fileMenu.add(quitMenuItem);
        optionsMenu.add(switchMenuItem);
        helpMenu.add(aboutMenuItem);
        
        // Adding each type of menu to the main menu bar
        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);
        
        // Creating a panel for the key text field at top of frame
        topPanel = new JPanel();
        keyLabel = new JLabel("Enter key value [0 - 25]");
        keyTextField = new JTextField(5);
        
        // Adding the key label and text field on top panel
        topPanel.add(keyLabel);
        topPanel.add(keyTextField);
        
        // Creating a panel for buttons and the buttons' labels
        // Added tool tip for every button on hover
        btnPanel = new JPanel();
        encryptBtn = new JButton("Encrypt");
        encryptBtn.setToolTipText("Encrypt your original message with a key.");
        decryptBtn = new JButton("Decrypt");
        decryptBtn.setToolTipText("Decrypt your coded message to get the original text. Same key for encryption is necessary.");
        clearBtn = new JButton("Clear");
        clearBtn.setToolTipText("Clear and reset both text screens.");
        moveBtn = new JButton("Move");
        moveBtn.setToolTipText("Move the text from the right to the left pane.");
        quitBtn = new JButton("Quit");
        quitBtn.setToolTipText("Exit the application.");
        
        // Adding the buttons to the button panel
        btnPanel.add(encryptBtn);
        btnPanel.add(decryptBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(moveBtn);
        btnPanel.add(quitBtn);
        
        // Creating a panel for the text areas
        textPanel = new JPanel(new GridLayout(1, 2));
        inputTextArea = new JTextArea("Enter plain text here", 25, 20);
        outputTextArea = new JTextArea(25, 20);
        inputTextArea.setLineWrap(true);
        outputTextArea.setLineWrap(true);
        outputTextArea.setEditable(false);
        
        // Adding the scroll panes to each text area 
        // and adding them to the text area panel
        inputTextAreaScrollPane = new JScrollPane(inputTextArea);
        outputTextAreaScrollPane = new JScrollPane(outputTextArea);
        textPanel.add(inputTextAreaScrollPane);
        textPanel.add(outputTextAreaScrollPane);
        
        // Adding panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        // Assigning an event listener to the buttons
        encryptBtn.addActionListener((ActionEvent e) -> {
            cs = new CryptoStratContext(new Caesar());
            try {
                int key = Integer.parseInt(keyTextField.getText());
                
                if (key > 25 || key < 0)
                    throw new Exception();
                
                String plainText = inputTextArea.getText();
                String cipherText = cs.executeEncryption(plainText, key);
                outputTextArea.setText(cipherText);
                inputTextArea.cut();
            } catch (Exception ex) {
                outputTextArea.setText("Warning: Invalid key value");
            }
        });
        
        decryptBtn.addActionListener((ActionEvent e) -> {
            cs = new CryptoStratContext(new Caesar());
            try {
                int key = Integer.parseInt(keyTextField.getText());
                
                if (key > 25 || key < 0)
                    throw new Exception();
                
                String cipherText = inputTextArea.getText();
                String plainText = cs.executeDecryption(cipherText, key);
                outputTextArea.setText(plainText);
            } catch (Exception ex) {
                outputTextArea.setText("Warning: Invalid key value");
            }
        });
        
        clearBtn.addActionListener((ActionEvent e) -> {
            outputTextArea.setText("");
            inputTextArea.setText("Enter plain text here");
            keyTextField.setText("");
        });
        
        moveBtn.addActionListener((ActionEvent e) -> {
            inputTextArea.setText(outputTextArea.getText());
            outputTextArea.setText("");
        });
        
        quitBtn.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        
        setJMenuBar(menuBar);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
