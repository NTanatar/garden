import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        double result = Math.sin(id * id);
        return "result of TaskWithResult " + id + ": " + result;
    }
}
