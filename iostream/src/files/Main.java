package files;

import java.io.*;

public class Main {

    private static void fileTest(String name) throws IOException {
        File f = new File(name);
        if (f.exists()) {
            System.out.println("+++ " + name + ": i am " + (f.isDirectory() ? "a directory" : "a file"));
        } else {
            System.out.println("+++ "+ name + ": no such file/dir " + f.getAbsolutePath());
        }
        System.out.println("parent " + f.getParent() + " abs " + f.isAbsolute());
        System.out.println("canonical " + f.getCanonicalPath());
        System.out.println("path " + f.getPath());
    }


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

    private static void randomAccess() {
        try {
            RandomAccessFile rand = new RandomAccessFile("output2.txt", "rw");
            double[] values = {2.3, 1.6, 4.7, 8.9};
            long[] pos = new long[4];

            for (int i = 0; i < 4; i++) {
                pos[i] = rand.getFilePointer();
                rand.writeDouble(values[i]);
                System.out.println("write " + i + " ("+ pos[i] + ") :  " + values[i]);
            }
            for (int i = 3; i >= 0; i--) {
                rand.seek(pos[i]);
                System.out.println("read " + i + " ("+ pos[i] + ") -> " + rand.readDouble());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        copyFile("src\\files\\input1.txt", "output1.txt");
        randomAccess();

        fileTest("output1.txt");
        fileTest("jo1.txt");
        fileTest("src\\files");
    }
}
