package com.pb.test.box;

public enum WeekDay {
    MONDAY,
    TUESDAY {
        public String getPlan() {
            return "learn";
        }
    },
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public String getPlan() {
        return "no plans";
    }

    public WeekDay tomorrow() {
        switch (this) {
            case MONDAY:
                return TUESDAY;
            case TUESDAY:
                return WEDNESDAY;
            case WEDNESDAY:
                return THURSDAY;
            case THURSDAY:
                return FRIDAY;
            case FRIDAY:
                return SATURDAY;
            case SATURDAY:
                return SUNDAY;
            case SUNDAY:
                return MONDAY;
        }
        return null;
    }

    private static void print2Days(WeekDay day) {
        System.out.println(day + "  " + day.tomorrow());
        System.out.println(day.getPlan() + "  " + day.tomorrow().getPlan());
    }

    public static void main(String[] args) {
        WeekDay[] days = WeekDay.values();
        for (int i = 0; i < days.length; i++) {
            print2Days(days[i]);
        }
    }
}

