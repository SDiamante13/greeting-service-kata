package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GreetingControllerTest {

    @Mock
    GreetingService mockGreetingService;

    private static final String USER = "Joe";

    @InjectMocks
    GreetingController greetingController;

    @Test
    void getSimpleGreetingReturnsASimpleGreetingToTheConsumer() {
        given(mockGreetingService.getSimpleGreeting())
                .willReturn("Hello my friend!");

        ResponseEntity<String> response = greetingController.getSimpleGreeting();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello my friend!");
    }

    @Test
    void getCustomizedGreetingReturnsAGreetingWithTheUsersName() {
        given(mockGreetingService.getCustomizedGreeting(USER))
                .willReturn(format("Hello %s!", USER));

        ResponseEntity<String> response = greetingController.getCustomizedGreeting(USER);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(format("Hello %s!", USER));
    }

    @Test
    void getCustomizedGreetingReturnsANiceGreeting() {
        given(mockGreetingService.getCustomizedGreeting(USER))
                .willReturn(format("Hey %s, nice to see you here!", USER));

        ResponseEntity<String> response = greetingController.getCustomizedGreeting(USER);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(format("Hey %s, nice to see you here!", USER));
    }
}