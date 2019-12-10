package streamtest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class Sequence {
    /*
    call with params:
    .\data\input1 .\data\input2 .\data\input3
     */
    public static void main (String[] args) {
        FileList files = new FileList(args);
        SequenceInputStream s = new SequenceInputStream(files);

        try {
            FileOutputStream outStream = new FileOutputStream("output-combined.txt");
            int a = s.read();
            while (a != -1) {
                outStream.write(a);
                a = s.read();
            }
            s.close();
            outStream.close();
            System.out.println("ready");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
