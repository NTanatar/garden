import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        double inf = 12.9 / 0.0;
        System.out.println("test 12/0 "+ inf);
        double zero = -5 / inf;
        System.out.println("test -5/infinity "+ zero);

        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte b = (byte) 0xcc;
        System.out.println ("b = Ox" + hex[(b>> 4) & 0x0f] + hex [b & 0x0f]);

        Farfalla alice = new Farfalla();
        System.out.println("Hello World! i am sleeping");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        alice.doSomething(4);
        System.out.println("Clouds=" + System.getProperty("numClouds"));

    }
}

class Farfalla {
    private int numLegs;
    private int numWings;
    Farfalla() {
        numLegs = 6;
        numWings = 4;
    }

    void doSomething(int food) {
        System.out.println("I ate something " + food);
    }
}
