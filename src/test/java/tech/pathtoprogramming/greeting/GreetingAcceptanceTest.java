package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.String.format;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class GreetingAcceptanceTest {

    private static final int MORNING_HOUR = 7;
    private static final int AFTERNOON_HOUR = 12;
    private static final int NIGHT_HOUR = 21;
    private MockMvc mockMvc;

    private static final String USER = "Joe";

    @MockBean
    private RandomNumber mockRandomNumber;

    @MockBean
    private Timepiece mockTimepiece;

    @Autowired
    private GreetingController greetingController;


    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(greetingController).build();
    }

    /**
     * When a greeting message is requested
     * Then the system will reply with "Hello my friend!"
     */
    @Test
    void returnASimpleGreeting() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello my friend!"));
    }

    /**
     * When a User with the name Joe requests a greeting message
     * Then the system will reply with a customized message that says:
     * "Hello Joe!"
     */
    @Test
    void greetingWithGivenUserReturnsCustomizedMessage() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(AFTERNOON_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("Hello %s!", USER)));
    }

    /**
     * When a User with the name Joe requests a greeting message
     * Then the system will reply with a customized message that says:
     * "Hey Joe, nice to see you here!"
     */
    @Test
    void greetingWithGivenUserReturnsRandomCustomizedMessage() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(1);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("Hey %s, nice to see you here!", USER)));
    }

    /**
     * When a User with the name Joe requests a greeting message
     * Then the system will reply with a customized message that says:
     * "Joe welcome back!"
     */
    @Test
    void greetingWithGivenUserReturnsWelcomeGreeting() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(2);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("%s welcome back!", USER)));
    }

    /**
     * When a User with the name Joe requests a greeting message
     * Then the system will reply with a customized message that says:
     * "Have a splendid day Joe."
     */
    @Test
    void greetingWithGivenUserReturnsSpendidGreeting() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(3);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("Have a splendid day %s.", USER)));
    }

    /**
     * When a User with the name Joe requests a greeting message
     * And the time is early in the morning
     * Then the system will reply with a customized message that says:
     * "Good morning, Joe! The sun is high and shining!"
     */
    @Test
    void greetingWithGivenUserReturnsCustomizedGreetingForTheMorning() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(MORNING_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                                format("Good morning, %s! The sun is high and shining!", USER)
                        )
                );
    }

    /**
     * When a User with the name Joe requests a greeting message
     * And the time is early in the morning
     * Then the system will reply with a customized message that says:
     * "Have a good night, Joe"
     */
    @Test
    void greetingWithGivenUserReturnsCustomizedGreetingForTheNight() throws Exception {
        given(mockTimepiece.getCurrentHour())
                .willReturn(NIGHT_HOUR);
        given(mockRandomNumber.generateRandom(anyInt()))
                .willReturn(0);

        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("Have a good night, %s", USER)));
    }
}
