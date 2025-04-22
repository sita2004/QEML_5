package stepDefinitions.api;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class OperationsAPISteps {
    
    private Response response;
    @Given("the API endpoint {string} is up and running")
    public void theAPIEndpointIsUpAndRunning(String apiEndpoint) {
        baseURI = "http://localhost:9000"; 
        
    }

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String endpoint) {
        response = given()
                .header("Authorization", "Bearer " + AuthContext.token)
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint);
    }
    @Then("the response should be status code of {int}")
    public void verifyStatusCode(int expectedCode) {
        Assert.assertEquals(expectedCode, response.getStatusCode());
    }

    @When("I send a POST request with amount {string} description {string}, and today's date and time to to {string}")
    public void iSendAPOSTRequestWithAmountDescriptionTo(String amountStr, String description, String endpoint) {

        int amount = Integer.parseInt(amountStr);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")) + "Z";

        String requestBody = "{"
                + "\"id\": null,"
                + "\"date\": \"" + currentDateTime + "\","
                + "\"description\": \"" + description + "\","
                + "\"amount\": " + amount + ","
                + "\"bankAccount\": null,"
                + "\"labels\": []"
                + "}";

        response=given()
                .header("Authorization", "Bearer " + AuthContext.token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint);


    }
}
