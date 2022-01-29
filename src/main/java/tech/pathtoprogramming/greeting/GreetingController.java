package tech.pathtoprogramming.greeting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> getSimpleGreeting() {
        return ResponseEntity.ok(greetingService.getSimpleGreeting());
    }

    @GetMapping("/greeting/{user}")
    public ResponseEntity<String> getCustomizedGreeting(@PathVariable String user) {
        return ResponseEntity.ok(greetingService.getCustomizedGreeting(user));
    }
}
