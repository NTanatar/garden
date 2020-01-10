package streamtest;

import java.io.*;

public class Main {

    private static ByteArrayInputStream createInput() {
        String tmp = "abcdefghijklmnopqrstuvwxyz";
        return new ByteArrayInputStream(tmp.getBytes());
    }

    private static void readAndPrint(InputStream input, int count) throws IOException {
        ByteArrayOutputStream f0 = new ByteArrayOutputStream(12);
        while (f0.size() != count) {
            f0.write(input.read());
        }
        System.out.println("Buffer as a string");
        System.out.println(f0.toString());

        System.out.println("Into array");
        byte[] b = f0.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.print((char) b[i]);
        }
        System.out.println();
    }

    private static void writeSomeData() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat"));
        out.writeInt(12);
        out.writeFloat(87.42F);
        out.writeUTF("troll");
        out.writeInt(834);
    }

    private static void readSomeData() throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream("data.dat"));
        System.out.print("\nint:" + input.readInt());
        System.out.print("\nfloat:" + input.readFloat());
        System.out.print("\nstr:" + input.readUTF());
        System.out.print("\nint:" + input.readInt());
    }

    public static void main(String[] args) throws IOException {
        readAndPrint(createInput(), 12);

        System.out.println("Enter 3 characters and a return");
        readAndPrint(System.in, 3);

        writeSomeData();
        readSomeData();
    }
}
