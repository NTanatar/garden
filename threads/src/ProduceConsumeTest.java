public class ProduceConsumeTest {

    public static void main(String args[]) {
        // SynchronizedQueue q = new SynchronizedQueue();
        QueueWithLock q = new QueueWithLock();
        new Producer(q);
        new Consumer(q);
    }
}
