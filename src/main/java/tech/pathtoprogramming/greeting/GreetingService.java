package tech.pathtoprogramming.greeting;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getSimpleGreeting() {
        return "Hello my friend!";
    }
}
