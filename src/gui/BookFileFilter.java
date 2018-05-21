package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class BookFileFilter extends FileFilter{
    public boolean accept(File file) {
        if(file.isDirectory()) {
            return true;
        }

        String name = file.getName();

        String extension = Utils.getFileExtension(name);

        if(extension == null) {
            return false;
        }

        if(extension.equals("book")) {
            return true;
        }

        return false;
    }

    public String getDescription() {return "Book Database Files (*.book";}
}
