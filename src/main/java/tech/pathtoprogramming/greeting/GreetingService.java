package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public static final String SIMPLE_GREETING = "Hello my friend!";

    public String getSimpleGreeting() {
        return SIMPLE_GREETING;
    }

    public String getCustomizedGreeting(String name) {
        return String.format("Hello %s!", name);
    }
}
