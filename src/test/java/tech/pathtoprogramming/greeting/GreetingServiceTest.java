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

    @Mock
    private Timepiece mockTimepiece;

    @InjectMocks
    private GreetingService greetingService;

    private static final String USER = "Joe";
    private static final HourOfDay MORNING_HOUR = new HourOfDay(7);
    private static final HourOfDay AFTERNOON_HOUR = new HourOfDay(12);
    private static final HourOfDay NIGHT_HOUR = new HourOfDay(21);

    @Test
    void getSimpleGreetingReturnsASimpleGreeting() {
        String actualGreeting = greetingService.getSimpleGreeting();

        assertThat(actualGreeting).isEqualTo("Hello my friend!");
    }

    @Test
    void getCustomizedGreetingReturnsGreetingUsingTheUsersName() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(AFTERNOON_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Hello %s!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsGreeting() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(1);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Hey %s, nice to see you here!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsWelcomeGreeting() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(2);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("%s welcome back!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsSpendidGreeting() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(3);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Have a splendid day %s.", USER));
    }

    @Test
    void getCustomizedGreetingReturnsNightGreeting() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(NIGHT_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Have a good night, %s", USER));
    }

    @Test
    void getCustomizedGreetingReturnsNightGreeting2() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(NIGHT_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(1);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(format("Wish you sweet dreams %s ...", USER));
    }

    @Test
    void getCustomizedGreetingReturnsNightGreeting3() {
        given(mockTimepiece.getCurrentHour())
                .willReturn(NIGHT_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(2);

        String actualGreeting = greetingService.getCustomizedGreeting(USER);

        assertThat(actualGreeting).isEqualTo(
                format("It was a great day! %s it's time to relax!", USER)
        );
    }
}