package tech.pathtoprogramming.greeting.acceptance;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tech.pathtoprogramming.greeting.GreetingApplication;

@CucumberContextConfiguration
@ContextConfiguration(classes = GreetingApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringAcceptanceTest {
}
