import java.util.concurrent.atomic.AtomicInteger;

public class IncrementCounter implements Runnable {
    AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        while (true) {
            counter.incrementAndGet();
        }
    }

    public int getValue() {
        return counter.get();
    }
}