package streamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class FileList implements Enumeration {
    String[] fileList;
    int current = 0;
    String myDir;

    FileList(String[] listOfFiles) {
        this.fileList = listOfFiles;
        myDir =  new File(".").getAbsolutePath();
    }

    public boolean hasMoreElements() {
        return current < fileList.length;
    }

    public Object nextElement(){
        InputStream is;
        String nextElement;
        if (!hasMoreElements()) {
            throw new NoSuchElementException("No more files.");
        } else {
            nextElement = fileList[current];
            current++;
            try {
                is = new FileInputStream(nextElement);
            } catch (FileNotFoundException e) {
                throw new NoSuchElementException("File not found " + nextElement + ", my dir: " + myDir);
            }
        }
        return is;
    }
}
