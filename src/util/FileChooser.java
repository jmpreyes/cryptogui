package util;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import resources.Strings;

/**
 * Allows the user to open a file from a directory.
 * Unused for now since all texts are directly typed/input into the text area.
 * 
 * @author Joseph R.
 * @since May 6, 2020
 */
public class FileChooser {
    /**
     * Open a file and return the file's name.
     * 
     * @return chosenFile the name of the selected file
     */
    public String chooseFile() {
        JFileChooser file = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        file.setDialogTitle(Strings.SELECT_FILE_MSG.getMsg());
        
        int proceedCode = file.showOpenDialog(null);
        String chosenFile = "";
        
        if (proceedCode == JFileChooser.APPROVE_OPTION) {
            File f = file.getSelectedFile();
            chosenFile = f.getName();
        }
        
        return chosenFile;
    }
}
