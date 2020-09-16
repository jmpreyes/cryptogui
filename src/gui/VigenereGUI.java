package gui;

import crypto.Crypto;
import crypto.Vigenere;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import resources.Strings;

/**
 * Creates the window for Vigenère cipher.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 * @see crypto.Vigenere
 */
public final class VigenereGUI extends Gui {
    private static final VigenereGUI GUI_OBJ = new VigenereGUI();
    private final Crypto VIGENERE = new Vigenere();
    
    // Implement user interface
    private VigenereGUI() {
        setTitle(super.title + " -- Vigenère Cipher");
        setPreferredSize(new Dimension(super.CIPHER_FRAME_WIDTH, super.CIPHER_FRAME_HEIGHT));
        super.setFrameProperties();
        super.addMenuBar();
        addContentPanel();
        addButtons();
        super.addPanelsToFrame();
        setJMenuBar(getFrameMenuBar());
        System.out.println(Strings.DEBUG_VIGENERE_INTERFACE.getMsg());
    }
    
    /**
     * Ensures that only one instance of <code>VigenereGUI</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>VigenereGUI</code>
     */
    public static VigenereGUI getInstance() {
        return GUI_OBJ;
    }
    
    /**
     * Define text areas and panels of interface.
     */
    @Override
    public void addContentPanel() {
        // Creating a panel for the key text field at top of frame
        JPanel topPanel = new JPanel();
        setTopPanel(topPanel);
        
        JLabel keyLabel = new JLabel(Strings.VIGENERE_PASSWORD_PROMPT_MSG.getMsg());
        setKeyLabel(keyLabel);
        
        JTextField keyTextField = new JTextField(20);
        setKeyTextField(keyTextField);
        
        // Adding the key label and text field on top panel
        getTopPanel().add(getKeyLabel());
        getTopPanel().add(getKeyTextField());
        
        // Creating a panel for the text areas
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        setTextPanel(textPanel);
        
        JTextArea inputTextArea = new JTextArea(Strings.INPUT_TEXT_MSG.getMsg(), 25, 20);
        setInputTextArea(inputTextArea);
        
        JTextArea outputTextArea = new JTextArea(25, 20);
        setOutputTextArea(outputTextArea);
        
        getInputTextArea().setLineWrap(true);
        getOutputTextArea().setLineWrap(true);
        getOutputTextArea().setEditable(false);
        
        // Adding the scroll panes to each text area and adding them to the text area panel
        JScrollPane inputTextAreaScrollPane = new JScrollPane(inputTextArea);
        setInputScrollPane(inputTextAreaScrollPane);
        
        JScrollPane outputTextAreaScrollPane = new JScrollPane(outputTextArea);
        setOutputScrollPane(outputTextAreaScrollPane);
        
        getTextPanel().add(getInputScrollPane());
        getTextPanel().add(getOutputScrollPane());
    }
    
    /**
     * Define a set of buttons and its functionality.
     */
    @Override
    public void addButtons() {
        // Creating a panel for buttons and the buttons' labels
        JPanel btnPanel = new JPanel();
        setBtnPanel(btnPanel);
        
        JButton encryptBtn = new JButton(Strings.ENCRYPT_LABEL.getMsg());
        setEncryptBtn(encryptBtn);
        getEncryptBtn().setToolTipText(Strings.ENCRYPT_HINT_MSG.getMsg());
        
        JButton decryptBtn = new JButton(Strings.DECRYPT_LABEL.getMsg());
        setDecryptBtn(decryptBtn);
        getDecryptBtn().setToolTipText(Strings.DECRYPT_HINT_MSG.getMsg());
        
        JButton clearBtn = new JButton(Strings.CLEAR_LABEL.getMsg());
        setClearBtn(clearBtn);
        getClearBtn().setToolTipText(Strings.CLEAR_HINT_MSG.getMsg());
        
        JButton moveBtn = new JButton(Strings.MOVE_LABEL.getMsg());
        setMoveBtn(moveBtn);
        getMoveBtn().setToolTipText(Strings.MOVE_HINT_MSG.getMsg());
        
        // Adding the buttons to the button panel
        getBtnPanel().add(getEncryptBtn());
        getBtnPanel().add(getDecryptBtn());
        getBtnPanel().add(getClearBtn());
        getBtnPanel().add(getMoveBtn());
        
        // Assigning an event listener to the buttons
        getEncryptBtn().addActionListener((ActionEvent e) -> {
            try {
                String encKey = getKeyTextField().getText();
                
                if (encKey.isEmpty() || encKey.matches("^\\d+$"))
                    throw new Exception();
                
                VIGENERE.setKey(encKey);
                VIGENERE.setPlaintext(getInputTextArea().getText());
                VIGENERE.encrypt();
                getOutputTextArea().setText(VIGENERE.getCiphertext());
                getInputTextArea().cut();
                System.out.println(Strings.DEBUG_ENCRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                getOutputTextArea().setText(Strings.INVALID_KEY_MSG.getMsg());
            }
        });
        
        getDecryptBtn().addActionListener((ActionEvent e) -> {
            try {
                String decKey = getKeyTextField().getText();
                
                if (decKey.isEmpty() || decKey.matches("^\\d+$"))
                    throw new Exception();
                
                VIGENERE.setKey(decKey);
                VIGENERE.setCiphertext(getInputTextArea().getText());
                VIGENERE.decrypt();
                getOutputTextArea().setText(VIGENERE.getPlaintext());
                System.out.println(Strings.DEBUG_DECRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                getOutputTextArea().setText(Strings.INVALID_KEY_MSG.getMsg());
            }
        });
        
        getClearBtn().addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_CLEAR_TEXTS.getMsg());
            getOutputTextArea().setText("");
            getInputTextArea().setText(Strings.INPUT_TEXT_MSG.getMsg());
            getKeyTextField().setText("");
        });
        
        getMoveBtn().addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_MOVE_TEXTS.getMsg());
            getInputTextArea().setText(getOutputTextArea().getText());
            getOutputTextArea().setText("");
        });
    }
}
