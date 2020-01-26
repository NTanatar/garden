import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumbers implements Runnable {
    private int numLoops;
    private Lock myLock;

    PrintNumbers(int numLoops, Lock lock) {
        this.numLoops = numLoops;
        this.myLock = lock;
    }

    @Override
    public void run() {
        try {
            myLock.lock();
            for (int n = numLoops; n > 0; n--) {
                System.out.println(Thread.currentThread().getName() + ": " + n);
                Thread.sleep(100);
            }
            myLock.unlock();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers(8, new ReentrantLock());
        Thread t = new Thread(pn);
        t.start();
    }
}
