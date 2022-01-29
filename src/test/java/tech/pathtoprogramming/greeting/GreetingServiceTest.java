package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void getSimpleGreetingReturnsASimpleGreeting() {
        String actualGreeting = greetingService.getSimpleGreeting();

        assertThat(actualGreeting).isEqualTo("Hello my friend!");
    }

    @Test
    void getCustomizedGreetingReturnsGreetingUsingTheUsersName() {
        String actualGreeting = greetingService.getCustomizedGreeting("Joe");

        assertThat(actualGreeting).isEqualTo("Hello Joe!");
    }
}