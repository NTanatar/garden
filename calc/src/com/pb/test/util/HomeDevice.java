package com.pb.test.util;

import com.pb.test.tools.Test;

public abstract class HomeDevice {

    HomeDevice(String name, boolean isUsingElectricity) {
        setName(name);
        setUsingElectricity(isUsingElectricity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


    public boolean isUsingElectricity() {
        return usingElectricity;
    }

    public void setUsingElectricity(boolean usingElectricity) {
        this.usingElectricity = usingElectricity;
    }

    private boolean usingElectricity;

    public abstract void enable();

    public abstract void disable();

    public abstract void apply();

    public static void main(String[] args) {
        final int NUM_DEVICES = 4;
        HomeDevice[] myDevices = new HomeDevice[NUM_DEVICES];
        myDevices[0] = new CoffeeMachine("Manfred");
        myDevices[1] = new Freezer("William", 20);
        myDevices[2] = new CookingPot();
        // anonymous
        myDevices[3] = new HomeDevice("thing", false) {
            public void enable() {
            }

            public void disable() {
            }

            public void apply() {
                System.out.println("some thing is working");
            }
        };

        for (int i = 0; i < NUM_DEVICES; i++) {
            System.out.println("welcome, " + myDevices[i].getName());
            if (myDevices[i].isUsingElectricity()) {
                myDevices[i].enable();
                myDevices[i].apply();
                myDevices[i].disable();
            } else {
                myDevices[i].apply();
            }
            Test.reflect(myDevices[i]);
        }
    }
}
