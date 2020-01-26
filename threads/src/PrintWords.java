public class PrintWords extends Thread {
    private String[] words;

    PrintWords(String[] words) {
        this.words = words;
    }

    @Override
    public void run() {
        try {
            for (String word : words) {
                System.out.println(getName() + ": " + word);
                Thread.sleep(1300);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) {
        String[] words = {"any", "small", "eagle", "knows", "this"};
        PrintWords pw = new PrintWords(words);
        pw.start();
    }
}
