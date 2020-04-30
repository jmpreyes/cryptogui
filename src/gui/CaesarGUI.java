package gui;

import crypto.Caesar;
import crypto.Crypto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the window for Caesar cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 * @see crypto.Caesar
 */
public final class CaesarGUI extends Gui {
    private static final CaesarGUI GUI_OBJ = new CaesarGUI();
    private final Crypto caesar = new Caesar();
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JTextField keyTextField;
    private JButton encryptBtn;
    private JButton decryptBtn;
    private JButton clearBtn;
    private JButton moveBtn;
    private JButton exitBtn;
    private JPanel topPanel;
    private JPanel btnPanel;
    private JPanel textPanel;
    private JScrollPane inputTextAreaScrollPane;
    private JScrollPane outputTextAreaScrollPane;
    private JLabel keyLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu optionsMenu;
    private JMenu helpMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem switchMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    
    /**
     * Ensures that only one instance of <code>CaesarGUI</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>CaesarGUI</code>
     */
    public static CaesarGUI getInstance() {
        return GUI_OBJ;
    }
    
    /**
     * Initialize and implement user interface.
     */
    private CaesarGUI() {
        addMenuBar();
        addContentPanel();
        addButtons();
        addPanelsToFrame();
        setFrameProperties();
        System.out.println("> CREATING CAESAR CIPHER INTERFACE");
    }
    
    /**
     * Define interface menu bar and its menu items.
     */
    @Override
    public void addMenuBar() {
         // Creating a menu bar and its items
        menuBar = new JMenuBar();
        
        // "File" menu
        fileMenu = new JMenu("File");
        saveMenuItem = new JMenuItem("Save Output File");
        exitMenuItem = new JMenuItem("Quit");
        
        saveMenuItem.addActionListener((ActionEvent e) -> {
            System.out.println("> SAVING DATA");
            // STUB
            JOptionPane.showMessageDialog(rootPane, "Work in progress.");
        });
        
        exitMenuItem.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println("> EXITING APPLICATION");
                dispose();
                System.exit(0);
            }
        });
        
        // "Options" menu
        optionsMenu = new JMenu("Options");
        switchMenuItem = new JMenuItem("Change Cryptographic Technique");
        
        switchMenuItem.addActionListener((ActionEvent e) -> {
            int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Are you sure?", "Change Cryptographic Technique", 
                    JOptionPane.YES_NO_OPTION);
            
            if (proceedCode == JOptionPane.YES_OPTION) {
                System.out.println("> SWITCHING CIPHERS");
                MainMenu.getInstance().setVisible(true);
                dispose();
                setVisible(false);
            }
        });
        
        // "Help" menu
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About Project");
        
        // Idea: Help > About Cipher
        
        aboutMenuItem.addActionListener((ActionEvent e) -> {
           JOptionPane.showMessageDialog(rootPane, "Written by Joe R."
                   + "\nApril 2020\nEmail at foo@foo.com");
           System.out.println("> READING ABOUT PROJECT");
        });
        
        // Adding the menu items to the "Options" menu bar
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        optionsMenu.add(switchMenuItem);
        helpMenu.add(aboutMenuItem);
        
        // Adding each type of menu to the main menu bar
        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);
    }
    
    /**
     * Define text areas and panels of interface.
     */
    @Override
    public void addContentPanel() {
        // Creating a panel for the key text field at top of frame
        topPanel = new JPanel();
        keyLabel = new JLabel("Enter a number between 0 and 25 (inclusive)");
        keyTextField = new JTextField(5);
        
        // Adding the key label and text field on top panel
        topPanel.add(keyLabel);
        topPanel.add(keyTextField);
        
        // Creating a panel for the text areas
        textPanel = new JPanel(new GridLayout(2, 1));
        inputTextArea = new JTextArea("Enter text here", 25, 20);
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
    }
    
    /**
     * Define a set of buttons and its functionality.
     */
    @Override
    public void addButtons() {
        // Creating a panel for buttons and the buttons' labels
        // Added tool tip for every button on hover
        btnPanel = new JPanel();
        encryptBtn = new JButton("Encrypt");
        encryptBtn.setToolTipText("Encrypt your original message with a key.");
        decryptBtn = new JButton("Decrypt");
        decryptBtn.setToolTipText("Decrypt your coded message to get the "
                + "original text. Same key for encryption is necessary.");
        clearBtn = new JButton("Clear");
        clearBtn.setToolTipText("Clear and reset both text screens.");
        moveBtn = new JButton("Move");
        moveBtn.setToolTipText("Move the text from the right to the left pane.");
        exitBtn = new JButton("Exit");
        exitBtn.setToolTipText("Exit the application.");
        
        // Adding the buttons to the button panel
        btnPanel.add(encryptBtn);
        btnPanel.add(decryptBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(moveBtn);
        btnPanel.add(exitBtn);
        
        // Assigning an event listener to the buttons
        encryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String encKey = keyTextField.getText();
                
                if (Integer.valueOf(encKey) > 25 || Integer.valueOf(encKey) < 0)
                    throw new Exception();
                
                caesar.setKey(encKey);
                String ptext = inputTextArea.getText();
                caesar.setPlaintext(ptext);
                caesar.encrypt();
                outputTextArea.setText(caesar.getCiphertext());
                inputTextArea.cut();
                System.out.println("> ENCRYPTING PLAINTEXT\n" + caesar);
            } catch (Exception ex) {
                outputTextArea.setText("!!! Warning: Invalid key value !!!");
            }
        });
        
        decryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String decKey = keyTextField.getText();
                
                if (Integer.valueOf(decKey) > 25 || Integer.valueOf(decKey) < 0)
                    throw new Exception();
                
                caesar.setKey(decKey);
                String ctext = inputTextArea.getText();
                caesar.setCiphertext(ctext);
                caesar.decrypt();
                outputTextArea.setText(caesar.getPlaintext());
                System.out.println("> DECRYPTING CIPHERTEXT\n" + caesar);
            } catch (Exception ex) {
                outputTextArea.setText("!!! Warning: Invalid key value !!!");
            }
        });
        
        clearBtn.addActionListener((ActionEvent e) -> {
            System.out.println("> CLEARING TEXT AREAS");
            outputTextArea.setText("");
            inputTextArea.setText("Enter text here");
            keyTextField.setText("");
        });
        
        moveBtn.addActionListener((ActionEvent e) -> {
            System.out.println("> MOVING TEXTS");
            inputTextArea.setText(outputTextArea.getText());
            outputTextArea.setText("");
        });
        
        exitBtn.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println("> EXITING APPLICATION");
                dispose();
                System.exit(0);
            }
        });
    }
    
    /**
     * Compiles all panels into the frame.
     */
    @Override
    public void addPanelsToFrame() {
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Define operations on close and other frame properties.
     */
    @Override
    public void setFrameProperties() {
        setTitle(super.title + " -- Caesar Cipher");
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        
        // Prompt confirmation to exit when user tries to close the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (exitCode == JOptionPane.YES_OPTION) {
                    System.out.println("> EXITING APPLICATION");
                    dispose();
                    System.exit(0);
                }
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
