public class JoiningTest {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
            grumpy = new Sleeper("Grumpy", 1500);
        Joiner a = new Joiner("AfterSleepy", sleepy),
            b = new Joiner("AfterGrumpy", grumpy);
        sleepy.interrupt();
    }
}
