package com.pb.test.tools;

import com.pb.test.cake.Cake;

public class Printer {
    public static <T> void prettyPrint(T element) {
        System.out.println("*** " + element + " ***");
    }

    public static <T extends Comparable> void printPairSorted(T a, T b) {
        if (a.compareTo(b) > 0) {
            System.out.println(a + " > " + b);
        } else {
            System.out.println(b + " > " + a);
        }
    }

    public static <T extends Cake> void printCakeSugar(T cake) {
        System.out.println(cake.getClass().getName() + " sugar: " + cake.getSugar());
    }

    public static void main(String[] args) {
        printPairSorted(1, 3);
        printPairSorted(5, 3);
    }
}
