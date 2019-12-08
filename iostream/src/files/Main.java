package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    private static void copyFile(String inputName, String outputName) {
        try {
            FileInputStream inStream = new FileInputStream(inputName);
            FileOutputStream outStream = new FileOutputStream(outputName);
            int c;
            while ((c = inStream.read()) != -1) {
                outStream.write(c);
            }
            inStream.close();
            outStream.close();
            System.out.println("copied");
        } catch (FileNotFoundException ex) {
            System.err.println("file not found " + ex.getMessage());
        } catch (IOException e) {
            System.err.println("exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("src\\files\\input1.txt", "output1.txt");
    }
}
