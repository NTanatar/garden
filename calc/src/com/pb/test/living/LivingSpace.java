package com.pb.test.living;

public class LivingSpace {
    interface Danceable {
        void dance();
    }

    private final int numCats = 4;

    // === member inner
    class Room implements Danceable {
        // static and enum are not allowed here
        private Room() {
        }

        public void dance() {
            System.out.println("dancing");
        }
    }

    private Room createRoom() {
        return new Room(); // call inner class constructor ok
    }

    private Danceable createDanceable() {
        return new Danceable() {   // === anonymous inner
            @Override
            public void dance() {
                System.out.println("boogie woogie");
            }
        };
    }

    private void makeMoreLight(final int a, int b) {
        final int c = 12;

        // === local inner :  private/pubic/protected and static NOT allowed here
        //                     also almost no static things inside it (except simple constants)
        class Lamp {
            private void on() {
                System.out.println("cats " + numCats + " a " + a); // a needs to be final
                System.out.println(" c " + c); // c needs to be final
            }
        }
        Lamp lamp = new Lamp();
        lamp.on();
    }

    private static boolean hasFreshAir() {
        return true;
    }

    // ===- static class (nested)
    static class TestStaticMethods {
        void run() {
            if (LivingSpace.hasFreshAir()) {
                System.out.println("ok");
            }
        }
    }

    public static void main(String[] args) {
        TestStaticMethods test1 = new LivingSpace.TestStaticMethods();
        TestStaticMethods test2 = new TestStaticMethods();
        test1.run();
        test2.run();

        LivingSpace space = new LivingSpace();
        Room r1 = space.createRoom();
        r1.dance();
        // Room r2 = new Room(); // cannot be referenced from static context
        r1 = space.new Room();
        r1.dance();

        space.createDanceable().dance();

        space.makeMoreLight(35, 10);
    }

}
