package tech.pathtoprogramming.greeting;

public class GreetingFactory {

    private GreetingFactory() {
    }

    // TODO: extract Hour type out of hourOfDay - primitive obsession
    public static Greeting getGreeting(int hourOfDay) {
        if (hourOfDay >= 7 && hourOfDay <= 11) {
            return new MorningGreeting();
        } else if (hourOfDay >= 12 && hourOfDay <= 20) {
            return new AfternoonGreeting();
        } else if (hourOfDay >= 21 || hourOfDay <= 6) {
            return new NightGreeting();
        } else {
            throw new RuntimeException();
        }
    }
}
