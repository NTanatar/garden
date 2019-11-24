package com.pb.test.box;

public enum LifeState {
    STUDENT(true, false),
    EMPLOYEE(false, true);

    private boolean hasTime;
    private boolean hasMoney;

    LifeState(boolean hasTime, boolean hasMoney) {
        this.hasTime = hasTime;
        this.hasMoney = hasMoney;
    }

    public String getProblems() {
        String result = "";
        if (!hasMoney) {
            result += " no money";
        }
        if (!hasTime) {
            result += " no time";
        }
        return result;
    }

    public static void main(String[] args) {
        LifeState[] states = LifeState.values();
        for (int i = 0; i < states.length; i++) {
            System.out.println(states[i].ordinal() + " " + states[i] + " " + states[i].getProblems());
        }
        LifeState a = STUDENT;
        System.out.println(a == STUDENT);
        System.out.println(a == EMPLOYEE);
        System.out.println(a.equals(STUDENT));

        try {
            LifeState.valueOf("CHILD");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid state");
        }
    }
}
