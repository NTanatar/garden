public class Calculation implements Runnable {

    public void run() {
        double calc;
        for (int i = 0; i < 50000; i++) {
            calc = Math.sin(i * i);
            if (i % 10000 == 0) {
                String result = String.format("%f", calc);
                System.out.println(getName() + " counts " + i / 10000 + "  " + result);
            }
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }

    public static void main(String[] s) {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Calculation(), "t" + i);
            int priority = Thread.MIN_PRIORITY + (Thread.MAX_PRIORITY - Thread.MIN_PRIORITY) / threads.length * i;
            System.out.println("priority " + i + " - " + priority);
            threads[i].setPriority(priority);
        }

        for (Thread p : threads) {
            p.start();
            System.out.println(p.getName() + " started");
        }
    }
}

