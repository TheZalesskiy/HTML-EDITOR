package htmlFileFilter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * HTMLFileFilter class
 * 17.08.2016
 * To open or save a file
 * Created by TheZalesskie
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()){
            return true;
        }
        else if (!f.isDirectory()) {
            String fileName = f.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
