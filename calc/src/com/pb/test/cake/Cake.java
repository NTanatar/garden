package com.pb.test.cake;

import com.pb.test.tools.Important;
import com.pb.test.tools.NewYearParty;
import com.pb.test.tools.Printer;
import com.pb.test.tools.Test;

public class Cake implements Eatable {
    static int numCakesInTheWorld = 0;
    int sugarInGrams;

    public Cake() {
        numCakesInTheWorld++;
        sugarInGrams = 0;
    }

    public void addSomeSugar(@Important int grams) {
        sugarInGrams += grams;
    }

    public int getSugar() {
        return sugarInGrams;
    }

    public void setEaten() {
        numCakesInTheWorld--;
    }

    public static void main(String[] args) {
        testInstanceOf();
        testCakes();
        testInterface();

        new Eatable() { // anonymous
            @Override
            public void setEaten() {
                System.out.println("its not a cake");
            }
        }.setEaten();

        Test.printInfoFromAnnotation(Muffin.class);
    }

    private static void testCakes() {
        Cake sweetCake = new Cake();
        Muffin smallMuffin = new Muffin();

        sweetCake.addSomeSugar(20);
        sweetCake.addSomeSugar(4);
        smallMuffin.addSomeSugar(30);
        smallMuffin.setEaten();
        Test.reflect(smallMuffin);
        Printer.printCakeSugar(sweetCake);
        Printer.printCakeSugar(smallMuffin);
        System.out.println("total cakes: " + Cake.numCakesInTheWorld);
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
        Test.reflect(wow); // should we see field and method inherited from Cake??
    }
}

@NewYearParty
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