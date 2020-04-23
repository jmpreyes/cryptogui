package gui;

import crypto.Porta;
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
 * Creates the window for Porta cipher.
 * 
 * @author Joseph R.
 * @since April 17, 2020
 * @see crypto.Porta
 */
public class PortaGUI extends JFrame {
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
    private final JButton exitBtn;
    
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
    private final JMenuItem exitMenuItem;
    private final JMenuItem aboutMenuItem;
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    
    // Porta cipher instance
    private final Porta porta = new Porta();
    
    // Singleton design pattern
    private static final PortaGUI GUI_OBJ = new PortaGUI();
    
    /**
     * Ensures that only one instance of <code>PortaGUI</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>PortaGUI</code>
     */
    public static PortaGUI getInstance() {
        return GUI_OBJ;
    }
    
    private PortaGUI() {
        super("CryptoGUI -- Cryptic Messages -- Porta Cipher");
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
        
        // Creating a menu bar and its items
        menuBar = new JMenuBar();
        
        // "File" menu
        fileMenu = new JMenu("File");
        saveMenuItem = new JMenuItem("Save Output File");
        exitMenuItem = new JMenuItem("Exit");
        
        saveMenuItem.addActionListener((ActionEvent e) -> {
            // STUB
            JOptionPane.showMessageDialog(rootPane, "Work in progress.");
        });
        
        exitMenuItem.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        
        // "Options" menu
        optionsMenu = new JMenu("Options");
        switchMenuItem = new JMenuItem("Change Cryptographic Technique");
        
        switchMenuItem.addActionListener((ActionEvent e) -> {
            // STUB
            JOptionPane.showMessageDialog(rootPane, "Work in progress.");
        });
        
        // "Help" menu
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About Project");
        
        aboutMenuItem.addActionListener((ActionEvent e) -> {
           JOptionPane.showMessageDialog(rootPane, "Written by Joe R."
                   + "\nApril 2020\nEmail at foo@foo.com"); 
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
        
        // Creating a panel for the key text field at top of frame
        topPanel = new JPanel();
        keyLabel = new JLabel("Enter keyword or passcode");
        keyTextField = new JTextField(20);
        
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
        
        // Assigning an event listener to the buttons
        encryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String key = keyTextField.getText();
                
                if (key.isEmpty())
                    throw new Exception();
                
                String plainText = inputTextArea.getText();
                String cipherText = porta.encrypt(plainText, key);
                outputTextArea.setText(cipherText);
                inputTextArea.cut();
            } catch (Exception ex) {
                outputTextArea.setText("Warning: Invalid key value");
            }
        });
        
        decryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String key = keyTextField.getText();
                
                if (key.isEmpty())
                    throw new Exception();
                
                String cipherText = inputTextArea.getText();
                String plainText = porta.decrypt(cipherText, key);
                outputTextArea.setText(plainText);
            } catch (Exception ex) {
                outputTextArea.setText("Warning: Invalid key value");
            }
        });
        
        clearBtn.addActionListener((ActionEvent e) -> {
            outputTextArea.setText("");
            inputTextArea.setText("Enter text here");
            keyTextField.setText("");
        });
        
        moveBtn.addActionListener((ActionEvent e) -> {
            inputTextArea.setText(outputTextArea.getText());
            outputTextArea.setText("");
        });
        
        exitBtn.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Quit and Exit?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION)
                System.exit(0);
        });
        
        // Adding the buttons to the button panel
        btnPanel.add(encryptBtn);
        btnPanel.add(decryptBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(moveBtn);
        btnPanel.add(exitBtn);
        
        // Adding panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
