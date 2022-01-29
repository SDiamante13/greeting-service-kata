package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class GreetingAcceptanceTest {

    private MockMvc mockMvc;

    private static final String USER = "Joe";

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
     * When a User with the name Joe request a greeting message
     * Then the system will reply with a customized message that says:
     * "Hello Joe!"
     */
    @Test
    void greetingWithGivenUserReturnsCustomizedMessage() throws Exception {
        mockMvc.perform(get("/greeting/{user}", USER))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(format("Hello %s!", USER)));
    }
}
