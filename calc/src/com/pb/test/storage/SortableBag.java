package com.pb.test.storage;

import com.pb.test.tools.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class SortableBag<T extends Comparable> {
    ArrayList<T> items;

    SortableBag() {
        items = new ArrayList<T>();
    }

    public void addItem(T element) {
        items.add(element);
    }

    public T getBest() {
        items.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        });
        return items.get(0);
    }

    public static void main(String[] args) {
        SortableBag<Integer> bag = new SortableBag<Integer>();
        bag.addItem(10);
        bag.addItem(4);
        bag.addItem(93);
        bag.addItem(57);
        System.out.println(bag.getBest());
        Test.reflect(bag);

    }
}
