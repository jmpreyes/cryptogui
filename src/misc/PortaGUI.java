package misc;

/*
import gui.Gui;
import gui.MainMenu;
import misc.Porta;
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
 * @see misc.Porta

public final class PortaGUI extends Gui {
    private static final PortaGUI GUI_OBJ = new PortaGUI();
    private final Porta porta = new Porta();
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
     * Ensures that only one instance of <code>PortaGUI</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>PortaGUI</code>
    
    public static PortaGUI getInstance() {
        return GUI_OBJ;
    }
    
    private PortaGUI() {
        addMenuBar();
        addContentPanel();
        addButtons();
        addPanelsToFrame();
        setFrameProperties();
    }
    
    @Override
    public void addMenuBar() {
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
            int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                    "Are you sure?", "Change Cryptographic Technique", 
                    JOptionPane.YES_NO_OPTION);
            
            if (proceedCode == JOptionPane.YES_OPTION) {
                MainMenu.getInstance().setVisible(true);
                dispose();
                setVisible(false);
            }
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
    }
    
    @Override
    public void addContentPanel() {
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
    }
    
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
                String key = keyTextField.getText();
                
                if (key.isEmpty())
                    throw new Exception();
                
                String plainText = inputTextArea.getText();
                key = new String(new char[(plainText.length() - 1) - (key.length() - 1) + 1]).replace("\0", key);
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
                key = new String(new char[(cipherText.length() - 1) - (key.length() - 1) + 1]).replace("\0", key);
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
    }
    
    @Override
    public void addPanelsToFrame() {
        // Adding panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void setFrameProperties() {
        setTitle(super.title + " -- Porta Cipher");
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
        
        pack();
        setLocationRelativeTo(null);
        setJMenuBar(menuBar);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}

*/
