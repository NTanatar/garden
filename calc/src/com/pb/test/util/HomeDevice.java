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
        HomeDevice[] myDevices = {
            new CoffeeMachine("Manfred"),
            new Freezer("William", 20),
            new CookingPot(),
            new HomeDevice("thing", false) {
                public void enable() {
                }

                public void disable() {
                }

                public void apply() {
                    System.out.println("some thing is working");
                }
            }
        };

        for (HomeDevice device : myDevices) {
            System.out.println("welcome, " + device.getName());
            if (device.isUsingElectricity()) {
                device.enable();
                device.apply();
                device.disable();
            } else {
                device.apply();
            }
            Test.reflect(device);
        }
    }
}
