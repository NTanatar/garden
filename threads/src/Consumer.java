public class Consumer implements Runnable {
    SynchronizedQueue q;

    Consumer(SynchronizedQueue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }
    }
}
