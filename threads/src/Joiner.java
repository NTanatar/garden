public class Joiner extends Thread {
    private Sleeper sleeper;

    Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
            System.out.println(System.currentTimeMillis() + " " + getName() + " join completed!");
        } catch (InterruptedException e) {
            System.out.println(System.currentTimeMillis() + " " + getName() + " interrupted");
        }
    }
}
