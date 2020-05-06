package gui;

import crypto.Crypto;
import crypto.Zimmermann;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import resources.Strings;

/**
 * Creates the window for Zimmermann cipher.
 * 
 * @author Joseph R.
 * @since May 6, 2020
 * @see crypto.Zimmermann
 */
public class ZimmermannGUI extends Gui {
    private static final ZimmermannGUI GUI_OBJ = new ZimmermannGUI();
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private Crypto zimmermann;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JTextField fileNameTextField;
    private JButton selectFileBtn;
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
    private JLabel fileNameLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu optionsMenu;
    private JMenu helpMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem switchMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    
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
     * Initialize and implement user interface.
     */
    private ZimmermannGUI() {
        addMenuBar();
        addContentPanel();
        addButtons();
        addPanelsToFrame();
        setFrameProperties();
        System.out.println(Strings.DEBUG_ZIMMERMANN_INTERFACE.getMsg());
    }
    
    /**
     * Define interface menu bar and its menu items.
     */
    @Override
    public void addMenuBar() {
        // Creating a menu bar and its items
        menuBar = new JMenuBar();
        
        // "File" menu
        fileMenu = new JMenu(Strings.FILE_LABEL.getMsg());
        saveMenuItem = new JMenuItem(Strings.SAVE_LABEL.getMsg());
        exitMenuItem = new JMenuItem(Strings.QUIT_LABEL.getMsg());
        
        saveMenuItem.addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_SAVE_DATA.getMsg());
            // STUB
            JOptionPane.showMessageDialog(rootPane, Strings.WIP_MSG.getMsg());
        });
        
        exitMenuItem.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
                dispose();
                System.exit(0);
            }
        });
        
        // "Options" menu
        optionsMenu = new JMenu(Strings.OPTIONS_LABEL.getMsg());
        switchMenuItem = new JMenuItem(Strings.CHANGE_CRYPTO_LABEL.getMsg());
        
        switchMenuItem.addActionListener((ActionEvent e) -> {
            int proceedCode = JOptionPane.showConfirmDialog(rootPane, Strings.CONFIRMATION_MSG.getMsg(), Strings.CHANGE_CRYPTO_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (proceedCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_SWITCH_CIPHER.getMsg());
                MainMenu.getInstance().setVisible(true);
                dispose();
                setVisible(false);
            }
        });
        
        // "Help" menu
        helpMenu = new JMenu(Strings.HELP_LABEL.getMsg());
        aboutMenuItem = new JMenuItem(Strings.ABOUT_PROJECT_LABEL.getMsg());
        
        // Idea: Help > About Cipher
        
        aboutMenuItem.addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_ABOUT_PROJECT.getMsg());
            JOptionPane.showMessageDialog(rootPane, Strings.PROJECT_DESC.getMsg());
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
        // Creating a panel for the file name text field at top of frame
        topPanel = new JPanel();
        fileNameLabel = new JLabel(Strings.ZIMMERMANN_FILENAME_PROMPT_MSG.getMsg());
        fileNameTextField = new JTextField(25);
        selectFileBtn = new JButton(Strings.SELECT_FILE_LABEL.getMsg());
        
        // Adding the file name label and text field on top panel
        topPanel.add(fileNameLabel);
        topPanel.add(fileNameTextField);
        topPanel.add(selectFileBtn);
        
        // Creating a panel for the text areas
        textPanel = new JPanel(new GridLayout(1, 2));
        inputTextArea = new JTextArea(Strings.INPUT_TEXT_ZIMMERMANN_MSG.getMsg(), 25, 20);
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
        encryptBtn = new JButton(Strings.ENCRYPT_LABEL.getMsg());
        encryptBtn.setToolTipText(Strings.ENCRYPT_HINT_MSG.getMsg());
        decryptBtn = new JButton(Strings.DECRYPT_LABEL.getMsg());
        decryptBtn.setToolTipText(Strings.DECRYPT_HINT_MSG.getMsg());
        clearBtn = new JButton(Strings.CLEAR_LABEL.getMsg());
        clearBtn.setToolTipText(Strings.CLEAR_HINT_MSG.getMsg());
        moveBtn = new JButton(Strings.MOVE_LABEL.getMsg());
        moveBtn.setToolTipText(Strings.MOVE_HINT_MSG.getMsg());
        exitBtn = new JButton(Strings.EXIT_LABEL.getMsg());
        exitBtn.setToolTipText(Strings.EXIT_HINT_MSG.getMsg());
        
        // Adding the buttons to the button panel
        btnPanel.add(encryptBtn);
        btnPanel.add(decryptBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(moveBtn);
        btnPanel.add(exitBtn);
        
        // Assigning an event listener to the buttons
        selectFileBtn.addActionListener((ActionEvent e) -> {
            String fileName = fileNameTextField.getText();
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            String line;
            
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
                
                while ((line = br.readLine()) != null)
                    sb.append(line);
                
                inputTextArea.setText(sb.toString());
            } catch (IOException ex) {
                outputTextArea.setText(Strings.INVALID_FILENAME_MSG.getMsg());
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ex) {
                    outputTextArea.setText(Strings.INVALID_FILENAME_MSG.getMsg());
                }
            }
        });
        
        encryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String fileName = fileNameTextField.getText();
                
                if (fileName.isEmpty())
                    throw new Exception();
                
                zimmermann = new Zimmermann(fileName);
                zimmermann.encrypt();
                outputTextArea.setText(zimmermann.printCodes());
                inputTextArea.cut();
                System.out.println(Strings.DEBUG_ENCRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                outputTextArea.setText(Strings.INVALID_FILENAME_MSG.getMsg());
            }
        });
        
        decryptBtn.addActionListener((ActionEvent e) -> {
            try {
                String fileName = fileNameTextField.getText();
                
                if (fileName.isEmpty())
                    throw new Exception();
                
                zimmermann.decrypt();
                outputTextArea.setText(zimmermann.printWords());
                System.out.println(Strings.DEBUG_DECRYPTING_TEXT.getMsg());
            } catch (Exception ex) {
                outputTextArea.setText(Strings.INVALID_FILENAME_MSG.getMsg());
            }
        });
        
        clearBtn.addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_CLEAR_TEXTS.getMsg());
            outputTextArea.setText("");
            inputTextArea.setText(Strings.INPUT_TEXT_ZIMMERMANN_MSG.getMsg());
            fileNameTextField.setText("");
        });
        
        moveBtn.addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_MOVE_TEXTS.getMsg());
            inputTextArea.setText(outputTextArea.getText());
            outputTextArea.setText("");
        });
        
        exitBtn.addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
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
        setTitle(super.title + " -- Zimmermann Cipher");
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        
        // Prompt confirmation to exit when user tries to close the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
                
                if (exitCode == JOptionPane.YES_OPTION) {
                    System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
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
