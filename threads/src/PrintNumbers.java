public class PrintNumbers implements Runnable {
    private int numLoops;

    PrintNumbers(int numLoops) {
        this.numLoops = numLoops;
    }

    @Override
    public void run() {
        try {
            for (int n = numLoops; n > 0; n--) {
                System.out.println(Thread.currentThread().getName() + ": " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers(8);
        Thread t = new Thread(pn);
        t.start();
    }
}
