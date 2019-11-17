package com.pb.test.cake;

class Cake implements Eatable {
    static int numCakesInTheWorld = 0;
    int sugarInGrams;

    Cake() {
        numCakesInTheWorld++;
        sugarInGrams = 0;
    }

    public void addSomeSugar(int grams) {
        sugarInGrams += grams;
    }

    public void setEaten() {
        numCakesInTheWorld--;
    }

    public static void main(String[] args) {
        testCakes();
        testInstanceOf();
        testInterface();
    }

    private static void testCakes() {
        Cake sweetCake = new Cake();
        Muffin smallMuffin = new Muffin();

        sweetCake.addSomeSugar(20);
        sweetCake.addSomeSugar(4);
        smallMuffin.addSomeSugar(30);
        smallMuffin.setEaten();
        System.out.println("total cakes: " + Cake.numCakesInTheWorld);
        System.out.println("sugar in cake " + sweetCake.sugarInGrams);
        System.out.println("sugar in muffin " + smallMuffin.sugarInGrams);
    }

    private static void testInterface() {
        Eatable food = new Cake();
        food.setEaten();
        Eatable f2 = new Muffin();
        f2.setEaten();
        PartlyEatable bigFood = new VeryBigCake();
        bigFood.setPartlyEaten(50);
        bigFood.setPartlyEaten(10);
        System.out.println("cakes: " + Cake.numCakesInTheWorld);
        bigFood.setPartlyEaten(0);
        System.out.println("cakes: " + Cake.numCakesInTheWorld);
    }

    private static void testInstanceOf() {
        Cake sweetCake = new Cake();
        Muffin smallMuffin = new Muffin();
        PartlyEatable wow = new VeryBigCake();
        System.out.println(sweetCake instanceof Cake);
        System.out.println(sweetCake instanceof Eatable);
        System.out.println(smallMuffin instanceof Cake);
        System.out.println(smallMuffin instanceof Eatable);
        System.out.println(wow instanceof Cake);
        System.out.println(wow instanceof Eatable);
        System.out.println(wow instanceof PartlyEatable);
    }
}

class Muffin extends Cake {

    @Override
    public void addSomeSugar(int value) {
        super.addSomeSugar(value / 2);
    }
}

class VeryBigCake extends Cake implements PartlyEatable {
    int percentRemaining;

    VeryBigCake() {
        percentRemaining = 100;
    }

    @Override
    public void setPartlyEaten(int percentRemaining) {
        this.percentRemaining = percentRemaining;
        if (percentRemaining == 0) {
            setEaten();
        }
    }
}