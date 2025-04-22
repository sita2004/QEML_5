package stepDefinitions.api;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginAPISteps {

    private String endpoint;
    private Response response;

    @Given("the API endpoint {string} is available")
    public void the_api_endpoint_is_available(String apiEndpoint) {
        baseURI = "http://localhost:9000"; // adjust base URI as per your setup
        endpoint = apiEndpoint;
    }

    @When("I send a POST request with username {string} and password {string}")
    public void i_send_a_post_request_with_username_and_password(String username, String password) {
        String body = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"rememberMe\":false}", username, password);
        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    @When("I send a POST request with empty credentials")
    public void i_send_a_post_request_with_empty_credentials() {
        String emptyBody = "{}";
        response = given()
                .header("Content-Type", "application/json")
                .body(emptyBody)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response should contain an authentication token")
    public void the_response_should_contain_an_authentication_token() {
//        String token = response.jsonPath().getString("id_token");
//        assertThat("Token should not be null", token, is(notNullValue()));
//        System.out.println("Auth Token: " + token);
        String token = response.jsonPath().getString("id_token");
        assertThat("Token should not be null", token, is(notNullValue()));
        AuthContext.token = token; // Save to shared context
        System.out.println("Auth Token: " + token);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedMessage) {
        String responseBody = response.getBody().asString();
        assertThat(responseBody, containsString(expectedMessage));
    }
}
