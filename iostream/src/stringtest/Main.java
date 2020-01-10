package stringtest;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {

    private static void bufferTest() {
        StringBuffer b = new StringBuffer("lorna ");
        b.append(12).append(" monkeys").append(" and ").append(1);
        System.out.println(b + " capacity: " + b.capacity());
    }

    private static void builderTest() {
        StringBuilder b = new StringBuilder("scorpio");
        b.replace(1, 5, "pol");
        System.out.println(b + " capacity: " + b.capacity());
    }

    private static String getSomeString() {
        Random rand = new Random();
        int n = rand.nextInt(5);
        switch(n) {
            case 0: return "ABC";
            case 1:
                char [] arr = {'3', '4'};
                return new String(arr);
            case 2:
                byte [] asci = {20, 15, 2};
                return new String(asci);
            case 3: return String.valueOf(2390.2);
            default:
                return "muxa jim";
        }
    }

    private static String setCharset(String a) {
        try {
            return new String(a.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e){
            System.out.println("unsupported encoding");
        }
        return a;
    }

    private static void equalsTest() {
        String a = "no reason to";
        String b = "no reason to";
        System.out.println("equals "+ (a.equals(b)));
        System.out.println("a == b "+ (a == b));
    }

    private static void splitTest() {
        String a = "I object to violence because when it appears to do good, the good is only temporary; the evil it does is permanent.";
        String [] b = a.split("[;,. ]+");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "--");
        }
        System.out.println();
        String [] c = a.split(";|,");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        StringTokenizer t = new StringTokenizer(a, " ,.;", false);
        while(t.hasMoreTokens()) {
            System.out.print(t.nextToken() + " * ");
        }
        System.out.println();
    }

    private static void createStringTest() {
        for (int i = 0; i < 6; i++) {
            System.out.println(getSomeString());
        }
        String a = "mum цум";
        System.out.println(a + " - " + setCharset(a));
    }

    private static void concatTest() {
        System.out.println("four 1: " + 2 + 2);
        System.out.println("four 2: " + (2 + 2));

        String a = "malinka" + getSomeString();
        String b = getSomeString() + "kos";
        String d = a + "  -*- " + b;
        System.out.println(d);

        String s = "";
        for (int i = 0; i < 10; i++){
            s += i;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        createStringTest();
        equalsTest();
        splitTest();
        concatTest();
        bufferTest();
        builderTest();
    }
}
