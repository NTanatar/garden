import java.util.concurrent.BlockingQueue;

public class PrintFromQueue implements Runnable {
    private BlockingQueue<String> bq;

    PrintFromQueue(BlockingQueue<String> source) {
        this.bq = source;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(bq.take());
            }
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
