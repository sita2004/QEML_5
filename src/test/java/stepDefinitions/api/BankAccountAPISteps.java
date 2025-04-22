package stepDefinitions.api;



import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.testng.Assert;

import static io.restassured.RestAssured.baseURI;
public class BankAccountAPISteps {

    private Response response;
    private int code;

//    @Given("the API endpoint {string} is running")
//    public void theAPIEndpointIsRunning(String endpoint) {
//        baseURI = "http://localhost:9000";
//    }
//
//    @When("I send GET request to {string}")
//    public void iSendAGETRequestToEndPoint(String endpoint) {
//        response = given()
//                .header("Authorization", "Bearer " + AuthContext.token)
//                .header("Content-Type", "application/json")
//                .when()
//                .get(endpoint);
//    }
//


    @When("I send a POST request to {string} with name {string} and balance {int}")
    public void iSendAPOSTRequestToWithNameAndBalance(String endpoint, String name, int balance) {
        String requestBody = "{"
                + "\"id\": null,"
                + "\"name\": \"" + name + "\","
                + "\"balance\": " + balance + ","
                + "\"user\": null"
                + "}";

        code = given()
                .header("Authorization", "Bearer " + AuthContext.token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint)
            .statusCode();
    }



    @When("I send a DELETE request to {string}")
    public void iSendADELETERequestTo(String endpoint) {
        code = given()
                .header("Authorization", "Bearer " + AuthContext.token)
                .when()
                .delete(endpoint)
            .statusCode();
    }
    @Then("the response status code of {int}")
    public void theResponseStatusCodeOf(int expectedCode) {
        Assert.assertEquals(expectedCode, code);
    }
}

