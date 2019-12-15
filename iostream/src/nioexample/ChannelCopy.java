package nioexample;
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
public class ChannelCopy {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel
            in = new FileInputStream("data\\input1").getChannel(),
            out = new FileOutputStream("copy1.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while(in.read(buffer) != -1) {
            buffer.flip(); // Подготовка к записи
            out.write(buffer);
            buffer.clear(); // Подготовка к чтению
        }
    }
}
