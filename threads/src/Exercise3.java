import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise3 {

    public static void main(String[] args) {
        Lock printingLock = new ReentrantLock();
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);
        String threadNames[] = {"Joe", "Ann", "Claus", "Berta", "Phil", "Sam", "Vivian", "Roy", "Marc", "Jerry"};

        for (int i = 0; i < 10; i++) {
            PrintToQueue pn = new PrintToQueue(5, printingLock, queue);
            new Thread(pn, threadNames[i]).start();
        }
        new Thread(new PrintFromQueue(queue)).start();
    }
}
