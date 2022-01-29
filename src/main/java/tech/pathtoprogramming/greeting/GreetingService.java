package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class GreetingService {

    private final RandomNumber randomNumber;

    private static final String SIMPLE_GREETING = "Hello my friend!";
    private static final List<String> greetings = List.of(
            "Hello %s!",
            "Hey %s, nice to see you here!",
            "%s welcome back!",
            "Have a splendid day %s."
    );

    public GreetingService(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getSimpleGreeting() {
        return SIMPLE_GREETING;
    }

    public String getCustomizedGreeting(String name) {
        int greetingIndex = randomNumber.generateRandom(greetings.size());
        return format(greetings.get(greetingIndex), name);
    }
}
