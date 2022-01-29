package tech.pathtoprogramming.greeting;

import java.util.List;

public class NightGreeting implements Greeting {
    @Override
    public List<String> getGreetings() {
        return List.of(
          "Have a good night, %s",
          "Wish you sweet dreams %s",
          "It was a great day! %s it's time to relax!"
        );
    }
}
