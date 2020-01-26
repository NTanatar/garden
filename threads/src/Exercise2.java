import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exercise2 {

    public static void main(String[] args) {
        Lock printingLock = new ReentrantLock();
        String threadNames[] = {"Joe", "Ann", "Claus", "Berta", "Phil", "Sam", "Vivian", "Roy", "Marc", "Jerry"};
        for (int i = 0; i < 10; i++) {
            PrintNumbers pn = new PrintNumbers(5, printingLock);
            Thread t = new Thread(pn, threadNames[i]);
            t.start();
        }
    }
}
