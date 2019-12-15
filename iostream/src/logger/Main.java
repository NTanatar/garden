package logger;
import java.io.IOException;
import java.util.logging.*;

public class Main {

    private static Logger logger;

    public static void main(String[] args) {
        try {
            logger = Logger.getLogger(Main.class.getName());

            FileHandler fh = new FileHandler("loggertest_%g_ok.txt");
            logger.addHandler(fh);
        } catch (SecurityException e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога из-за политики безопасности.", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не удалось создать файл лога из-за ошибки ввода-вывода.", e);
        }
        logger.log(Level.INFO, "Запись лога с уровнем INFO (информационная)");
        logger.log(Level.WARNING,"Запись лога с уровнем WARNING (Предупреждение)");
        logger.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)");
    }
}
