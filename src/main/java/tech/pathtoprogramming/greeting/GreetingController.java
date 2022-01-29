package tech.pathtoprogramming.greeting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    public ResponseEntity<String> getSimpleGreeting() {
        return null;
    }
}
