package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    private static final String USER = "Joe";

    @Test
    void getSimpleGreetingReturnsASimpleGreeting() {
        String actualGreeting = greetingService.getSimpleGreeting();

        assertThat(actualGreeting).isEqualTo("Hello my friend!");
    }

    @Test
    void getCustomizedGreetingReturnsGreetingUsingTheUsersName() {
        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Hello %s!", USER));
    }
}