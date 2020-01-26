import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueB implements SharedQueue {
    private BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(4); // new SynchronousQueue<Integer>();

    @Override
    public int get() {
        try {
            int a = bq.take();
            System.out.println("Got:" + a);
            return a;
        } catch (InterruptedException e) {}
        return 0;
    }

    @Override
    public void put(int value) {
        try {
            bq.put(value);
            System.out.println("Put:" + value);
        } catch (InterruptedException e) {}
    }
}
