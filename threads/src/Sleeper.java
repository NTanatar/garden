public class Sleeper extends Thread {
    private int duration;

    Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
            System.out.println(System.currentTimeMillis() + " " + getName() + " woke up");
        } catch (InterruptedException e) {
            System.out.println(System.currentTimeMillis() + " " + getName() + " was interrupted. ");
        }
    }
}
