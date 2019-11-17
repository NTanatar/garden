package com.pb.test.util;

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
        final int NUM_DEVICES = 3;
        HomeDevice[] myDevices = new HomeDevice[NUM_DEVICES];
        myDevices[0] = new CoffeeMachine("Manfred");
        myDevices[1] = new Freezer("William", 20);
        myDevices[2] = new CookingPot();

        for (int i = 0; i < NUM_DEVICES; i++) {
            System.out.println("welcome, " + myDevices[i].getName());
            if (myDevices[i].isUsingElectricity()) {
                myDevices[i].enable();
                myDevices[i].apply();
                myDevices[i].disable();
            } else {
                myDevices[i].apply();
            }
        }
    }
}
