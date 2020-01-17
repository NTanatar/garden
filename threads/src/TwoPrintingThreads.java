public class TwoPrintingThreads {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        t.setName("My Thread");
        System.out.println("current thread: " + t);

        PrintNumbers pn = new PrintNumbers(8);
        Thread p = new Thread(pn, "numbers");
        System.out.println("second: " + p);

        String[] words = {"any", "small", "eagle", "knows", "this"};
        PrintWords pw = new PrintWords(words);
        pw.setName("words");
        System.out.println("third: " + pw);

        p.start();
        pw.start();
    }
}
