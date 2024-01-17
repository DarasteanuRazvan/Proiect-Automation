package stepdefinition;

import api.APIWithJOptionPane;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.UnsupportedEncodingException;


public class ApiBookingProcessSteps {

    private String requestBody;

    private String apiResponse;

    @Given("I have a base URI {string}")
    public void iHaveABaseURI(String arg0) {
        System.out.println("----------------------------------------------------");
    }

    //Scenario: Login Step using POST request
    @When("I set the login URL as {string}")
    public void iSetTheLoginURLAs(String arg0) {
        System.out.println("----------------------------------------------------");
        System.out.println("Scenario: Login Step using POST request");
    }

    @And("I set the request body as {string}")
    public void iSetTheRequestBodyAs(String body) {
        requestBody = body;
    }

    @And("I send a POST request to the login URL")
    public void iSendAPOSTRequestToTheLoginURL() {
    }

    @And("the first response status code should be {int}")
    public void theFirstResponseStatusCodeShouldBe(int arg0) {
    }

    @Then("I extract the access token")
    public void iExtractTheAccessToken() {
    }

    //Scenario: Click on Hotel Iasi Image Step using GET request
    @When("I set the hotel URL as {string}")
    public void iSetTheHotelURLAs(String arg0) {
        System.out.println("----------------------------------------------------");
        System.out.println("Scenario: Click on Hotel Iasi Image Step using GET request");
    }

    @And("I set the access token header")
    public void iSetTheAccessTokenHeader() {
    }

    @When("I send a GET request to the hotel URL")
    public void iSendAGETRequestToTheHotelURL() {
    }

    @And("the second response status code should be {int}")
    public void theSecondResponseStatusCodeShouldBe(int arg0) {
    }

    @Then("the first response body should have property {string} with value {string}")
    public void theResponseBodyShouldHavePropertyWithValue(String arg0, String arg1) {
    }

    //Scenario: Click on Room "tripla" Step using GET request
    @When("I set the room URL as {string}")
    public void iSetTheRoomURLAs(String arg0) {
        System.out.println("----------------------------------------------------");
        System.out.println("Scenario: Click on Room \"tripla\" Step using GET request");
    }

    @And("I set the parameter {string} as {string}")
    public void iSetTheParameterAs(String arg0, String arg1) {
    }

    @And("I send a GET request to the room URL")
    public void iSendAGETRequestToTheRoomURL() {
    }

    @And("the third response status code should be {int}")
    public void theThirdResponseStatusCodeShouldBe(int arg0) {
    }

    @Then("the second response body should have property {string} with value {string}")
    public void theSecondResponseBodyShouldHavePropertyWithValue(String arg0, String arg1) {
    }

    //Scenario: Logout Step using POST request
    @When("I set the logout URL as {string}")
    public void iSetTheLogoutURLAs(String arg0) {
        System.out.println("----------------------------------------------------");
        System.out.println("Scenario: Logout Step using POST request");
    }

    @And("I send a POST request to the logout URL")
    public void iSendAPOSTRequestToTheLogoutURL() {
    }

    @Then("the fourth response status code should be {int}")
    public void theFourthResponseStatusCodeShouldBe(int arg0) {
        System.out.println("----------------------------------------------------");
        System.out.println("End of testing process!");
    }

    @When("I make an API request")
    public void makeAPIRequest() throws UnsupportedEncodingException {
        String requestDetails = APIWithJOptionPane.executeAPIRequestWithDialog();
        System.out.println("API request: " + requestDetails);
    }

    @Then("I should receive a response from the server!")
    public void verifyAPIResponse() {
        if (apiResponse != null) {
            System.out.println("API response: " + apiResponse);
        }
    }
}





