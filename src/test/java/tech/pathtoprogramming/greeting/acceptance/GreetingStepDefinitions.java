package tech.pathtoprogramming.greeting.acceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GreetingStepDefinitions extends SpringAcceptanceTest {

    private Response response;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @When("a greeting message is requested")
    public void a_greeting_message_is_requested() {
        response = when()
                .get("/greeting");
    }

    @Then("the system will reply with {string}")
    public void the_system_will_reply_with(String greeting) {
        response
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("greeting", equalTo(greeting));
    }
}
