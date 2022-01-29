package tech.pathtoprogramming.greeting;

import java.util.List;

public class AfternoonGreeting implements Greeting {
    @Override
    public List<String> getGreetings() {
            return List.of(
                    "Hello %s!",
                    "You are great %s"
            );
    }
}
