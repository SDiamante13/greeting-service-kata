package tech.pathtoprogramming.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GreetingControllerTest {

    @Mock
    GreetingService mockGreetingService;

    @InjectMocks
    GreetingController greetingController;

    @Test
    void getSimpleGreetingReturnsHelloMyFriend() {
        given(mockGreetingService.getSimpleGreeting())
                .willReturn("Hello my friend!");

        ResponseEntity<String> response = greetingController.getSimpleGreeting();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello my friend");
    }
}