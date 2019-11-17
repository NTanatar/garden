package com.pb.test.util;

public class Freezer extends HomeDevice {

    private int volume;

    Freezer(String name, int volume) {
        super(name, true);
        this.volume = volume;
    }

    @Override
    public void enable() {
        System.out.println("freezer " + getName() + " on");
    }

    @Override
    public void disable() {
        System.out.println("freezer " + getName() + " off");
    }

    @Override
    public void apply() {
        System.out.println("freezer " + getName() + " is working");
    }
}
