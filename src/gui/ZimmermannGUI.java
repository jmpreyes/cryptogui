package gui;

import crypto.Crypto;
import crypto.Zimmermann;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import resources.Strings;

/**
 * Creates the window for Zimmermann cipher.
 * 
 * @author Joseph R.
 * @since May 6, 2020
 * @see crypto.Zimmermann
 */
public final class ZimmermannGUI extends Gui {
    private static final ZimmermannGUI GUI_OBJ = new ZimmermannGUI();
    private final Crypto ZIMMERMANN = new Zimmermann();
    
    // Implement user interface
    private ZimmermannGUI() {
        setTitle(super.title + " -- Zimmermann Cipher");
        setPreferredSize(new Dimension(super.CIPHER_FRAME_WIDTH, super.CIPHER_FRAME_HEIGHT));
        super.setFrameProperties();
        super.addMenuBar();
        addContentPanel();
        addButtons();
        super.addPanelsToFrame();
        setJMenuBar(getFrameMenuBar());
        System.out.println(Strings.DEBUG_ZIMMERMANN_INTERFACE.getMsg());
    }
    
    /**
     * Ensures that only one instance of <code>ZimmermannGUI</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>ZimmermannGUI</code>
     */
    public static ZimmermannGUI getInstance() {
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
        
        JLabel headerLabel = new JLabel(Strings.ZIMMERMANN_HEADER_PROMPT_MSG.getMsg());
        setHeaderLabel(headerLabel);
        
        // Adding the file name label and text field on top panel
        getTopPanel().add(getHeaderLabel());
        
        // Creating a panel for the text areas
        JPanel textPanel = new JPanel(new GridLayout(1, 2));
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
        
        JButton exitBtn = new JButton(Strings.EXIT_LABEL.getMsg());
        setExitBtn(exitBtn);
        getExitBtn().setToolTipText(Strings.EXIT_HINT_MSG.getMsg());
        
        // Adding the buttons to the button panel
        getBtnPanel().add(getEncryptBtn());
        getBtnPanel().add(getDecryptBtn());
        getBtnPanel().add(getClearBtn());
        getBtnPanel().add(getMoveBtn());
        getBtnPanel().add(getExitBtn());
        
        // Assigning an event listener to the buttons
        getEncryptBtn().addActionListener((ActionEvent e) -> {
            try {
                if (getInputTextArea().getText().isEmpty())
                    throw new Exception();
                
                ZIMMERMANN.encrypt();
                getOutputTextArea().setText(ZIMMERMANN.printCodes());
                getInputTextArea().cut();
                System.out.println(Strings.DEBUG_ENCRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                getOutputTextArea().setText(Strings.EMPTY_INPUT_MSG.getMsg());
            }
        });
        
        getDecryptBtn().addActionListener((ActionEvent e) -> {
            try {
                if (getInputTextArea().getText().isEmpty())
                    throw new Exception();
                
                ZIMMERMANN.decrypt();
                getOutputTextArea().setText(ZIMMERMANN.printWords());
                System.out.println(Strings.DEBUG_DECRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                getOutputTextArea().setText(Strings.EMPTY_INPUT_MSG.getMsg());
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
        
        getExitBtn().addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
                dispose();
                System.exit(0);
            }
        });
    }
}
