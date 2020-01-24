import java.util.concurrent.atomic.AtomicInteger;

public class Exercise1 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        IncrementCounter[] counters = new IncrementCounter[5];

        for (int i = 0; i < threads.length; i++) {
            counters[i] = new IncrementCounter();
            threads[i] = new Thread(counters[i], "t" + i);

            int priority = 11 - (1 + i) * 2;
            threads[i].setPriority(priority);
            System.out.println("priority of thread " + i + " is " + priority);
        }
        for (Thread p : threads) {
            p.start();
        }
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < counters.length; i++) {
            System.out.println("counter " + i + " : " + counters[i].getValue());
        }
    }
}
