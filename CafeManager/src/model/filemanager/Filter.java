package model.filemanager;

import java.io.File;
import java.io.FilenameFilter;

public class Filter {

    public File[] finder( String dirName, String extension){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(extension); }
        } );
    }
}
