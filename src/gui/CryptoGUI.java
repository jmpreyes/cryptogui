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
 */
public class CryptoGUI extends JFrame {
    private final JTextArea inputTextArea;
    private final JTextArea outputTextArea;
    private final JTextField keyTextField;
    private final JButton encryptBtn;
    private final JButton decryptBtn;
    private final JButton clearBtn;
    private final JButton moveBtn;
    private final JButton quitBtn;
    private final JPanel topPanel;
    private final JPanel btnPanel;
    private final JPanel textPanel;
    private final JScrollPane inputTextAreaScrollPane;
    private final JScrollPane outputTextAreaScrollPane;
    private final JLabel keyLabel;
    
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
        super("CryptoGUI: Cryptic Messages");
        setBounds(0, 0, 500, 300);
        
        // Creating a panel for the key text field at top of frame
        topPanel = new JPanel();
        keyLabel = new JLabel("Enter key value [0 - 25]");
        keyTextField = new JTextField(5);
        
        // Adding the key label and text field on top panel
        topPanel.add(keyLabel);
        topPanel.add(keyTextField);
        
        // Creating a panel for buttons and the buttons' labels
        btnPanel = new JPanel();
        encryptBtn = new JButton("Encrypt");
        decryptBtn = new JButton("Decrypt");
        clearBtn = new JButton("Clear");
        moveBtn = new JButton("Move");
        quitBtn = new JButton("Quit");
        
        // Adding the buttons to the button panel
        btnPanel.add(encryptBtn);
        btnPanel.add(decryptBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(moveBtn);
        btnPanel.add(quitBtn);
        
        // Creating a panel for the text areas
        textPanel = new JPanel(new GridLayout(1, 2));
        inputTextArea = new JTextArea("Enter plain text", 25, 20);
        outputTextArea = new JTextArea(25, 20);
        inputTextArea.setLineWrap(true);
        outputTextArea.setLineWrap(true);
        outputTextArea.setEditable(false);
        
        // Adding the scroll panes to each text area and 
        // adding them to the text area panel
        inputTextAreaScrollPane = new JScrollPane(inputTextArea);
        outputTextAreaScrollPane = new JScrollPane(outputTextArea);
        textPanel.add(inputTextAreaScrollPane);
        textPanel.add(outputTextAreaScrollPane);
        
        // Adding panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        // Assigning an event listener to the buttons
        encryptBtn.addActionListener(new ButtonListener());
        decryptBtn.addActionListener(new ButtonListener());
        clearBtn.addActionListener(new ButtonListener());
        moveBtn.addActionListener(new ButtonListener());
        quitBtn.addActionListener(new ButtonListener());
        
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Assigns an operation or a functionality to each button by implementing 
     * the <code>ActionListener</code> interface.
     */
    // Note: Need to decouple context object and encrypt/decrypt operation !!!
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == encryptBtn) {
                cs = new CryptoStratContext(new Caesar());
                try {
                    int key = Integer.parseInt(keyTextField.getText());
                    if (key > 25 || key < 0) throw new Exception();
                    String plainText = inputTextArea.getText();
                    String cipherText = cs.executeEncryption(plainText, key);
                    outputTextArea.setText(cipherText);
                    inputTextArea.cut();
                } catch (Exception ex) {
                    outputTextArea.setText("Warning: Invalid key value");
                }
            } else if (e.getSource() == decryptBtn) {
                cs = new CryptoStratContext(new Caesar());
                try {
                    int key = Integer.parseInt(keyTextField.getText());
                    if (key > 25 || key < 0) throw new Exception();
                    String cipherText = inputTextArea.getText();
                    String plainText = cs.executeDecryption(cipherText, key);
                    outputTextArea.setText(plainText);
                } catch (Exception ex) {
                    outputTextArea.setText("Warning: Invalid key value");
                }
            } else if (e.getSource() == clearBtn) {
                outputTextArea.setText("");
                inputTextArea.setText("Enter plain text");
                keyTextField.setText("");
            } else if (e.getSource() == moveBtn) {
                inputTextArea.setText(outputTextArea.getText());
                outputTextArea.setText("");
            } else
                System.exit(0);
        }
    }
}
