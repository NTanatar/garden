public class ProduceConsumeTest {

    public static void main(String args[]) {
        SynchronizedQueue q = new SynchronizedQueue();
        new Producer(q);
        new Consumer(q);
    }
}
