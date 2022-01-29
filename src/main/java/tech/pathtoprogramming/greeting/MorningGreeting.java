package tech.pathtoprogramming.greeting;

import java.util.List;

public class MorningGreeting implements Greeting {
    @Override
    public List<String> getGreetings() {
            return List.of(
                    "Good morning, %s! The sun is high and shining!",
                    "Hey %s, nice to see you here!",
                    "%s welcome back!",
                    "Have a splendid day %s."
            );
    }
}
