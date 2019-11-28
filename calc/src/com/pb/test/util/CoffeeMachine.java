package com.pb.test.util;
//import static org.easymock.EasyMock.*;

public class CoffeeMachine extends HomeDevice {

    public CoffeeMachine(String name) {
        super(name, true);
    }

    @Override
    public void enable() {
        System.out.println("coffee machine " + getName() + " on");
    }

    @Override
    public void disable() {
        System.out.println("coffee machine " + getName() + " off");
    }

    @Override
    public void apply() {
        System.out.println("coffee machine " + getName() + " is working");
    }
}

