package com.pb.test.util;

public class CookingPot extends HomeDevice {

    CookingPot() {
        super("pot", false);
    }

    @Override
    public void enable() {
    }

    @Override
    public void disable() {
    }

    @Override
    public void apply() {
        System.out.println("Pot is working");
    }
}
