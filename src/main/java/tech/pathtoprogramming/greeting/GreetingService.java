package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class GreetingService {

    private final RandomNumber randomNumber;
    private final Timepiece timepiece;

    private static final String SIMPLE_GREETING = "Hello my friend!";

    public GreetingService(RandomNumber randomNumber, Timepiece timepiece) {
        this.randomNumber = randomNumber;
        this.timepiece = timepiece;
    }

    public String getSimpleGreeting() {
        return SIMPLE_GREETING;
    }

    public String getCustomizedGreeting(String name) {
        int hourOfDay = timepiece.getCurrentHour();
        HourOfDay hour = new HourOfDay(hourOfDay);
        Greeting greeting = GreetingFactory.getGreeting(hour);

        int greetingIndex = randomNumber.generateRandom(greeting.getGreetings().size());
        return format(greeting.getGreetings().get(greetingIndex), name);
    }
}
