package tech.pathtoprogramming.greeting;

public class HourOfDay {
    private final int hour;

    public HourOfDay(int hour) {
        this.hour = hour;
    }

    public boolean isMorning() {
        return this.hour >= 7 && this.hour <= 11;
    }

    public boolean isAfternoon() {
        return this.hour >= 12 && this.hour <= 20;
    }

    public boolean isNight() {
        return this.hour >= 21 || this.hour <= 6;
    }

    public int hour() {
        return this.hour;
    }
}
