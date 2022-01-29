package tech.pathtoprogramming.greeting;

public class GreetingFactory {

    private GreetingFactory() {
    }

    public static Greeting getGreeting(HourOfDay hourOfDay) {
        if (hourOfDay.isMorning()) {
            return new MorningGreeting();
        } else if (hourOfDay.isAfternoon()) {
            return new AfternoonGreeting();
        } else if (hourOfDay.isNight()) {
            return new NightGreeting();
        } else {
            throw new RuntimeException();
        }
    }
}
