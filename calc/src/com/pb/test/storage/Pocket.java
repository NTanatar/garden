package com.pb.test.storage;

import com.pb.test.tools.Printer;

import java.util.ArrayList;

public class Pocket<T> {
    ArrayList<T> items;

    Pocket() {
        items = new ArrayList<T>();
    }

    public void addItem(T element) {
        items.add(element);
    }

    public T getFirst() {
        if (!items.isEmpty()) {
            T element = items.get(0);
            items.remove(0);
            return element;
        }
        return null;
    }

    public static void main(String[] args) {
        Pocket<String> p = new Pocket<>();
        p.addItem("Maria");
        p.addItem("Roy");
        String a = p.getFirst();
        Printer.prettyPrint(a);
        System.out.println(p.getFirst());
        System.out.println(p.getClass().getName());

        Pocket<Integer> g = new Pocket<>();
        g.addItem(10);
        g.addItem(2);
        g.addItem(7);

        Integer elem = g.getFirst();
        int result = 0;
        while (elem != null) {
            result += elem;
            elem = g.getFirst();
        }
        System.out.println("sum " + result);
    }
}
