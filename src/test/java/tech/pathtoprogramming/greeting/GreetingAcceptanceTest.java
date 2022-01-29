package tech.pathtoprogramming.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
class GreetingAcceptanceTest {

    private MockMvc mockMvc;

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
}
