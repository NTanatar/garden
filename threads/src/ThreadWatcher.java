public class ThreadWatcher extends Thread {
    ThreadWatcher() {
        super("ThreadWatcher daemon thread");
        setDaemon(true);
        start();
    }

    public void run() {
        Thread[] threads = new Thread[10];
        while (true) {
            // Получаем набор всех потоков из тестовой группы
            int count = ThreadBunch.GROUP.activeCount();
            if (threads.length < count) {
                threads = new Thread[count + 10];
            }
            count = ThreadBunch.GROUP.enumerate(threads);
            // Распечатываем имя каждого потока
            for (int i = 0; i < count; i++) {
                System.out.print(threads[i].getName() + ", ");
            }
            System.out.println();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}