package com.pb.test.cake;

class Cake implements Eatable {
    static int numberOfCakesInTheWorld = 0;
    private int a;

    Cake(int a) {
        this.a = a;
    }

    public void makeCake(int b) {
        System.out.println("i made a cake " + a + " " + b);
        numberOfCakesInTheWorld++;
    }

    public void setEaten() {
        numberOfCakesInTheWorld--;
    }

    public static void main(String[] args) {
        testNumCakes();
        testInstanceOf();
    }

    private static void testNumCakes() {
        Cake sweetCake = new Cake(12);
        Muffin smallMuffin = new Muffin();

        sweetCake.makeCake(2);
        smallMuffin.makeCake(3);
        System.out.println("total cakes: " + Cake.numberOfCakesInTheWorld);

        smallMuffin.setEaten();
        System.out.println("total cakes: " + Cake.numberOfCakesInTheWorld);
    }

    private static void testInstanceOf() {
        Cake sweetCake = new Cake(12);
        Muffin smallMuffin = new Muffin();
        System.out.println(sweetCake instanceof Cake);
        System.out.println(sweetCake instanceof Eatable);
        System.out.println(sweetCake instanceof Muffin);
        System.out.println(smallMuffin instanceof Cake);
        System.out.println(smallMuffin instanceof Eatable);
        System.out.println(smallMuffin instanceof Muffin);
    }
}

class Muffin extends Cake {
    Muffin() {
        super(13);
    }

    @Override
    public void makeCake(int b) {
        System.out.println("i made a muffin " + b);
        numberOfCakesInTheWorld++;
    }
}