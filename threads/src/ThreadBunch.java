public class ThreadBunch implements Runnable {

    final static ThreadGroup GROUP = new ThreadGroup("Bunch");

    // Стартовое значение, указывается при создании объекта
    private int startValue;

    ThreadBunch(int s) {
        startValue = (s % 2 == 0) ? s : s + 1;
        new Thread(GROUP, this, "Thread " + startValue).start();
    }

    public void run() {
        // Начинаем обратный отсчет
        for (int i = startValue; i > 0; i--) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            // По достижению середины порождаем новый поток с половинным начальным значением
            if (startValue > 2 && i == startValue / 2) {
                new ThreadBunch(i);
            }
        }
    }

    public static void main(String[] s) {
        new ThreadBunch(16);
        new ThreadWatcher();
    }
}

