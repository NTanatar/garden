import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class ProduceConsumeTest {

    public static void main(String args[]) {
        SharedQueue q1 = new SynchronizedQueue();
        SharedQueue q2 = new QueueWithLock();
        SharedQueue q3 = new QueueB();

        new Producer(q3);
        new Consumer(q3);
    }
}
