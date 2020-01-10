package nioexample;
import java.nio.channels.*;
import java.io.*;

public class TransferTo {

    public static void transferTo(FileChannel in, FileChannel out) throws IOException {
        in.transferTo(0, in.size(), out);
    }

    public static void transferFrom(FileChannel in, FileChannel out) throws IOException {
        out.transferFrom(in, 0, in.size());
    }

    public static void main(String[] args) throws Exception {
        FileChannel in = new FileInputStream("data\\input1").getChannel(),
                    out = new FileOutputStream("copy2.txt").getChannel();
        transferTo(in, out);
    }
}
