package tech.pathtoprogramming.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void getSimpleGreetingReturnsASimpleGreeting() {
        String actualGreeting = greetingService.getSimpleGreeting();

        Assertions.assertThat(actualGreeting).isEqualTo("Hello my friend!");
    }
}