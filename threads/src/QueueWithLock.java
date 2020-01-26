import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QueueWithLock implements SharedQueue{

    int n;
    boolean valueSet = false;
    private Lock myLock = new ReentrantLock();

    private Condition newDataAvailable = myLock.newCondition();
    private Condition previousDataIsTaken = myLock.newCondition();

    public int get() {
        myLock.lock();
        while(!valueSet){
            try {
                newDataAvailable.await();
            } catch (InterruptedException e) {}
        }
        System.out.println("Got: " + n);
        valueSet = false;
        previousDataIsTaken.signalAll();
        myLock.unlock();
        return n;
    }

    public void put(int n) {
        myLock.lock();
        while (valueSet) {
            try {
                previousDataIsTaken.await();
            } catch (InterruptedException e) {}
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        newDataAvailable.signalAll();
        myLock.unlock();
    }
}
