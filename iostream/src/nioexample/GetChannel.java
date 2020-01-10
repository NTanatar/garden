package nioexample;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        String filePath = "output2.txt";
        // Запись файла
        FileChannel fc = new FileOutputStream(filePath).getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
        // Добавление в конец файла
        fc = new RandomAccessFile(filePath, "rw").getChannel();
        fc.position(fc.size()); // Переходим в конец
        fc.write(ByteBuffer.wrap("Some more".getBytes()), 12);
        fc.close();
        // Чтение файла:
        fc = new FileInputStream(filePath).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining()) {
            System.out.print((char) buff.get());
        }
    }
}