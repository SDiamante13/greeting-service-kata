package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @Mock
    private RandomNumber mockRandomNumber;

    @InjectMocks
    private GreetingService greetingService;

    private static final String USER = "Joe";

    @Test
    void getSimpleGreetingReturnsASimpleGreeting() {
        String actualGreeting = greetingService.getSimpleGreeting();

        assertThat(actualGreeting).isEqualTo("Hello my friend!");
    }

    @Test
    void getCustomizedGreetingReturnsGreetingUsingTheUsersName() {
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Hello %s!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsGreeting() {
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(1);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Hey %s, nice to see you here!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsWelcomeGreeting() {
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(2);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("%s welcome back!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsSpendidGreeting() {
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(3);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Have a splendid day %s.", USER));
    }
}