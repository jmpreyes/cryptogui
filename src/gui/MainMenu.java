package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import resources.Strings;

/**
 * Creates the window for the main menu.
 * 
 * @author Joseph R.
 * @since April 9, 2020
 */
public final class MainMenu extends Gui {
    private static final MainMenu MENU_OBJ = new MainMenu();
    private final int FRAME_WIDTH = 350;
    private final int FRAME_HEIGHT = 150;
    private final int GRID_ROWS = 1;
    private final int GRID_COLS = 1;
    private JRadioButton caesarRadioBtn;
    private JRadioButton vigenereRadioBtn;
    //private JRadioButton portaRadioBtn;
    //private JRadioButton zimmermannRadioBtn;
    private ButtonGroup radioBtnGroup;
    private JLabel topLabel;
    private JPanel topPanel;
    private JPanel radioGroupPanel;
    private JPanel btnPanel;
    private JButton selectBtn;
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem aboutMenuItem;
    
    /**
     * Ensures that only one instance of <code>MainMenu</code> is created. 
     * Re-use the object if it's already instantiated.
     * 
     * @return object of <code>MainMenu</code>
     */
    public static MainMenu getInstance() {
        return MENU_OBJ;
    }
    
    /**
     * Creates the main menu frame.
     */
    private MainMenu() {
        addMenuBar();
        addContentPanel();
        addButtons();
        addPanelsToFrame();
        setFrameProperties();
        System.out.println(Strings.DEBUG_MENU_INTERFACE.getMsg());
    }
    
    /**
     * Define interface menu bar and its menu items.
     */
    @Override
    public void addMenuBar() {
        // Creating a menu bar and its items
        menuBar = new JMenuBar();
        
        // "Help" menu
        helpMenu = new JMenu(Strings.HELP_LABEL.getMsg());
        aboutMenuItem = new JMenuItem(Strings.ABOUT_PROJECT_LABEL.getMsg());
        
        aboutMenuItem.addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_ABOUT_PROJECT.getMsg());
            JOptionPane.showMessageDialog(rootPane, Strings.PROJECT_DESC.getMsg()); 
        });
        
        // Adding the menu items to the "Help" menu bar
        helpMenu.add(aboutMenuItem);
        
        // Adding type of menu to the main menu bar
        menuBar.add(helpMenu);
    }
    
    /**
     * Define text areas and panels of interface.
     */
    @Override
    public void addContentPanel() {
        // Creating the top partfor the header label
        // and adding it to the top panel
        topPanel = new JPanel();
        topLabel = new JLabel(Strings.SELECT_CRYPTO_LABEL.getMsg());
        topPanel.add(topLabel);
        
        // Creating a panel for the radio button group
        // and adding the radio buttons to that group
        radioGroupPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        caesarRadioBtn = new JRadioButton(Strings.CAESAR_LABEL.getMsg());
        vigenereRadioBtn = new JRadioButton(Strings.VIGENERE_LABEL.getMsg());
        /*
        portaRadioBtn = new JRadioButton("Porta Cipher");
        zimmermannRadioBtn = new JRadioButton("Zimmermann Cipher");
        */
        
        // Adding the radio buttons to a group so only one is enabled at once
        radioBtnGroup = new ButtonGroup();
        radioBtnGroup.add(caesarRadioBtn);
        radioBtnGroup.add(vigenereRadioBtn);
        /*
        radioBtnGroup.add(portaRadioBtn);
        radioBtnGroup.add(zimmermannRadioBtn);
        */
        
        // Adding each radio button to the radio group panel
        radioGroupPanel.add(caesarRadioBtn);
        radioGroupPanel.add(vigenereRadioBtn);
        /*
        radioGroupPanel.add(portaRadioBtn);
        radioGroupPanel.add(zimmermannRadioBtn);
        */
    }
    
    /**
     * Define a set of buttons and its functionality.
     */
    @Override
    public void addButtons() {
        // Creating the panel for the button and adding the button to the panel
        btnPanel = new JPanel();
        selectBtn = new JButton(Strings.SELECT_LABEL.getMsg());
        btnPanel.add(selectBtn);
        
        // Determine which radio button is selected 
        // and which cipher to use
        selectBtn.addActionListener((ActionEvent e) -> {
            if (caesarRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, "Continue with " + caesarRadioBtn.getText() + "?", Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    System.out.println(Strings.DEBUG_SELECT_CAESAR.getMsg());
                    CaesarGUI.getInstance().setVisible(true);
                    dispose();
                    setVisible(false);
                }
            } else if (vigenereRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, "Continue with " + vigenereRadioBtn.getText() + "?", Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    System.out.println(Strings.DEBUG_SELECT_VIGENERE.getMsg());
                    VigenereGUI.getInstance().setVisible(true);
                    dispose();
                    setVisible(false);
                }
            } /*else if (portaRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Continue with " + portaRadioBtn.getText() + "?", 
                        "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    PortaGUI.getInstance().setVisible(true);
                    dispose();
                    setVisible(false);
                }
            } else if (zimmermannRadioBtn.isSelected()) {
                int proceedCode = JOptionPane.showConfirmDialog(rootPane, 
                        "Continue with " + zimmermannRadioBtn.getText() + "?", 
                        "Confirm", JOptionPane.YES_NO_OPTION);
                
                if (proceedCode == JOptionPane.YES_OPTION) {
                    // Stub for now
                    JOptionPane.showMessageDialog(rootPane, "Work in progress!");
                }
            } */else {
                JOptionPane.showMessageDialog(rootPane, Strings.DEFAULT_MSG.getMsg());
            }
        });
    }
    
    /**
     * Compiles all panels into the frame.
     */
    @Override
    public void addPanelsToFrame() {
        // Add the respective panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(radioGroupPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Define operations on close and other frame properties.
     */
    @Override
    public void setFrameProperties() {
        setTitle(super.title);
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
