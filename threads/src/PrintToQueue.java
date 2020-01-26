import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintToQueue implements Runnable {
    private int numLoops;
    private Lock myLock;
    private BlockingQueue<String> bq;

    PrintToQueue(int numLoops, Lock lock, BlockingQueue<String> destination) {
        this.numLoops = numLoops;
        this.myLock = lock;
        this.bq = destination;
    }

    @Override
    public void run() {
        try {
            myLock.lock();
            for (int n = numLoops; n > 0; n--) {
                bq.put(Thread.currentThread().getName() + ": " + n);
                Thread.sleep(100);
            }
            myLock.unlock();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) {
        BlockingQueue<String> q = new ArrayBlockingQueue<String>(10);
        PrintToQueue pn = new PrintToQueue(8, new ReentrantLock(), q);
        Thread Printer = new Thread(pn, "xop");
        Printer.start();

        new Thread(new PrintFromQueue(q)).start();
    }
}
