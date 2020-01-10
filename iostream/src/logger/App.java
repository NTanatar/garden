package logger;
import java.util.logging.*;
// import org.apache.log4j.xml.DOMConfigurator;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {

        //DOMConfigurator.configureAndWatch("c:\log4j.xml", 1000);
        while(true){
            try {
                LOGGER.info("info");
                LOGGER.log(Level.FINE, "debug");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                LOGGER.log(Level.SEVERE, "", ex);
            }
        }
    }
}
