package gui;

import java.awt.BorderLayout;
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
import resources.Strings;
import util.RuntimeCalc;

/**
 * Abstract class of each user interface to be created.
 * 
 * @author Joseph R.
 * @since April 24, 2020
 */
public abstract class Gui extends JFrame {
    private final RuntimeCalc runtimeCalc;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JTextField keyTextField;
    private JButton encryptBtn;
    private JButton decryptBtn;
    private JButton clearBtn;
    private JButton moveBtn;
    private JPanel topPanel;
    private JPanel btnPanel;
    private JPanel textPanel;
    private JScrollPane inputTextAreaScrollPane;
    private JScrollPane outputTextAreaScrollPane;
    private JLabel headerLabel;
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
     * Title of the frame.
     */
    protected String title = Strings.WINDOW_TITLE.getMsg();
    
    /**
     * Width of main menu's frame.
     */
    protected final int MENU_FRAME_WIDTH = 350;
    
    /**
     * Height of main menu's frame.
     */
    protected final int MENU_FRAME_HEIGHT = 175;
    
    /**
     * Width of each cryptographic interface frame.
     */
    protected final int CIPHER_FRAME_WIDTH = 800;
    
    /**
     * Height of each cryptographic interface frame.
     */
    protected final int CIPHER_FRAME_HEIGHT = 600;
    
    /**
     * Set the title of the frame.
     */
    public Gui() {
        setTitle(title);
        runtimeCalc = new RuntimeCalc();
    }
    
    /*
    protected void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    protected void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    protected void setExecTime(long execTime) {
        this.execTime = execTime;
    }
    
    protected long getStartTime() {
        return this.startTime;
    }
    
    protected long getEndTime() {
        return this.endTime;
    }
    
    protected long getExecTime() {
        return this.execTime;
    }
    */
    
    public void setInputTextArea(JTextArea inputTextArea) {
        this.inputTextArea = inputTextArea;
    }
    
    public void setOutputTextArea(JTextArea outputTextArea) {
        this.outputTextArea = outputTextArea;
    }
    
    public void setKeyTextField(JTextField keyTextField) {
        this.keyTextField = keyTextField;
    }
    
    public void setEncryptBtn(JButton encryptBtn) {
        this.encryptBtn = encryptBtn;
    }
    
    public void setDecryptBtn(JButton decryptBtn) {
        this.decryptBtn = decryptBtn;
    }
    
    public void setClearBtn(JButton clearBtn) {
        this.clearBtn = clearBtn;
    }
    
    public void setMoveBtn(JButton moveBtn) {
        this.moveBtn = moveBtn;
    }
    
    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }
    
    public void setBtnPanel(JPanel btnPanel) {
        this.btnPanel = btnPanel;
    }
    
    public void setTextPanel(JPanel textPanel) {
        this.textPanel = textPanel;
    }
    
    public void setInputScrollPane(JScrollPane inputTextAreaScrollPane) {
        this.inputTextAreaScrollPane = inputTextAreaScrollPane;
    }
    
    public void setOutputScrollPane(JScrollPane outputTextAreaScrollPane) {
        this.outputTextAreaScrollPane = outputTextAreaScrollPane;
    }
    
    public void setHeaderLabel(JLabel headerLabel) {
        this.headerLabel = headerLabel;
    }
    
    public void setKeyLabel(JLabel keyLabel) {
        this.keyLabel = keyLabel;
    }
    
    public void setFrameMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }
    
    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }
    
    public void setOptionsMenu(JMenu optionsMenu) {
        this.optionsMenu = optionsMenu;
    }
    
    public void setHelpMenu(JMenu helpMenu) {
        this.helpMenu = helpMenu;
    }
    
    public void setSaveMenuItem(JMenuItem saveMenuItem) {
        this.saveMenuItem = saveMenuItem;
    }
    
    public void setSwitchMenuItem(JMenuItem switchMenuItem) {
        this.switchMenuItem = switchMenuItem;
    }
    
    public void setExitMenuItem(JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }
    
    public void setAboutMenuItem(JMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    public JTextArea getInputTextArea() {
        return this.inputTextArea;
    }
    
    public JTextArea getOutputTextArea() {
        return this.outputTextArea;
    }
    
    public JTextField getKeyTextField() {
        return this.keyTextField;
    }
    
    public JButton getEncryptBtn() {
        return this.encryptBtn;
    }
    
    public JButton getDecryptBtn() {
        return this.decryptBtn;
    }
    
    public JButton getClearBtn() {
        return this.clearBtn;
    }
    
    public JButton getMoveBtn() {
        return this.moveBtn;
    }
    
    public JPanel getTopPanel() {
        return this.topPanel;
    }
    
    public JPanel getBtnPanel() {
        return this.btnPanel;
    }
    
    public JPanel getTextPanel() {
        return this.textPanel;
    }
    
    public JScrollPane getInputScrollPane() {
        return this.inputTextAreaScrollPane;
    }
    
    public JScrollPane getOutputScrollPane() {
        return this.outputTextAreaScrollPane;
    }
    
    public JLabel getHeaderLabel() {
        return this.headerLabel;
    }
    
    public JLabel getKeyLabel() {
        return this.keyLabel;
    }
    
    public JMenuBar getFrameMenuBar() {
        return this.menuBar;
    }
    
    public JMenu getFileMenu() {
        return this.fileMenu;
    }
    
    public JMenu getOptionsMenu() {
        return this.optionsMenu;
    }
    
    public JMenu getHelpMenu() {
        return this.helpMenu;
    }
    
    public JMenuItem getSaveMenuItem() {
        return this.saveMenuItem;
    }
    
    public JMenuItem getSwitchMenuItem() {
        return this.switchMenuItem;
    }
    
    public JMenuItem getExitMenuItem() {
        return this.exitMenuItem;
    }
    
    public JMenuItem getAboutMenuItem() {
        return this.aboutMenuItem;
    }
    
    /**
     * Define operations on close and other frame properties.
     */
    public void setFrameProperties() {
        // Prompt confirmation to exit when user tries to close the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
                
                if (exitCode == JOptionPane.YES_OPTION) {
                    System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
                    runtimeCalc.setEndTime(System.nanoTime());
                    runtimeCalc.setExecTime(runtimeCalc.getEndTime() - runtimeCalc.getStartTime());
                    System.out.println(runtimeCalc);
                    dispose();
                    System.exit(0);
                }
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    /**
     * Define interface menu bar and its menu items.
     */
    public void addMenuBar() {
        // Creating a menu bar and its items
        JMenuBar mb = new JMenuBar();
        setFrameMenuBar(mb);
        
        // "File" menu
        JMenu f = new JMenu(Strings.FILE_LABEL.getMsg());
        setFileMenu(f);
        
        JMenuItem smi = new JMenuItem(Strings.SAVE_LABEL.getMsg());
        setSaveMenuItem(smi);
        
        JMenuItem emi = new JMenuItem(Strings.QUIT_LABEL.getMsg());
        setExitMenuItem(emi);
        
        getSaveMenuItem().addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_SAVE_DATA.getMsg());
            // STUB
            JOptionPane.showMessageDialog(rootPane, Strings.WIP_MSG.getMsg());
        });
        
        getExitMenuItem().addActionListener((ActionEvent e) -> {
            int exitCode = JOptionPane.showConfirmDialog(rootPane, Strings.QUIT_MSG.getMsg(), Strings.CONFIRM_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (exitCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_EXIT_APP.getMsg());
                runtimeCalc.setEndTime(System.nanoTime());
                    runtimeCalc.setExecTime(runtimeCalc.getEndTime() - runtimeCalc.getStartTime());
                    System.out.println(runtimeCalc);
                dispose();
                System.exit(0);
            }
        });
        
        // "Options" menu
        JMenu om = new JMenu(Strings.OPTIONS_LABEL.getMsg());
        setOptionsMenu(om);
        
        JMenuItem smiO = new JMenuItem(Strings.CHANGE_CRYPTO_LABEL.getMsg());
        setSwitchMenuItem(smiO);
        
        getSwitchMenuItem().addActionListener((ActionEvent e) -> {
            int proceedCode = JOptionPane.showConfirmDialog(rootPane, Strings.CONFIRMATION_MSG.getMsg(), Strings.CHANGE_CRYPTO_LABEL.getMsg(), JOptionPane.YES_NO_OPTION);
            
            if (proceedCode == JOptionPane.YES_OPTION) {
                System.out.println(Strings.DEBUG_SWITCH_CIPHER.getMsg());
                MainMenu.getInstance().setVisible(true);
                dispose();
                setVisible(false);
            }
        });
        
        // "Help" menu
        JMenu hm = new JMenu(Strings.HELP_LABEL.getMsg());
        setHelpMenu(hm);
        
        JMenuItem abi = new JMenuItem(Strings.ABOUT_PROJECT_LABEL.getMsg());
        setAboutMenuItem(abi);
        
        // Idea: Help > About Cipher
        
        getAboutMenuItem().addActionListener((ActionEvent e) -> {
            System.out.println(Strings.DEBUG_ABOUT_PROJECT.getMsg());
            JOptionPane.showMessageDialog(rootPane, Strings.PROJECT_DESC.getMsg());
        });
        
        // Adding the menu items to the "Options" menu bar
        getFileMenu().add(getSaveMenuItem());
        getFileMenu().add(getExitMenuItem());
        getOptionsMenu().add(getSwitchMenuItem());
        getHelpMenu().add(getAboutMenuItem());
        
        // Adding each type of menu to the main menu bar
        getFrameMenuBar().add(getFileMenu());
        getFrameMenuBar().add(getOptionsMenu());
        getFrameMenuBar().add(getHelpMenu());
    }
    
    /**
     * Compiles all panels into the frame.
     */
    public void addPanelsToFrame() {
        add(getTopPanel(), BorderLayout.NORTH);
        add(getTextPanel(), BorderLayout.CENTER);
        add(getBtnPanel(), BorderLayout.SOUTH);
    }
    
    /**
     * Define text areas and panels of interface.
     */
    public abstract void addContentPanel();
    
    /**
     * Define a set of buttons and its functionality.
     */
    public abstract void addButtons();
}
