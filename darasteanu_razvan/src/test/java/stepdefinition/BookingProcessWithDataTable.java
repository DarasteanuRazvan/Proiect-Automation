package stepdefinition;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BookingData;
import pageObject.BookingProcess;
import utils.CredentialsProvider;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static pageObject.BookingData.password;
import static pageObject.BookingData.username;
import static stepdefinition.Hooks.driver;

public class BookingProcessWithDataTable {


    private BookingProcess bookingProcess;
    private BookingData bookingData;

    public BookingProcessWithDataTable() {
    }

    @Given("User is on Login Page")
    public void beOnLoginPage() {
        System.out.println("Open Login Page");
        driver.get("http://138.68.69.185/login");
        this.bookingData = new BookingData();
        this.bookingProcess = new BookingProcess(driver, bookingData);
    }

    @When("Enter username {string}")
    public void enterUsername(String username) {
        if (username.equalsIgnoreCase("default")) {
            username = CredentialsProvider.getUsername();
        }

        System.out.println("Enter username");
        bookingProcess.enterUsername(username);

    }


    @When("Enter password {string}")
    public void enterPassword(String password) {
        if (password.equalsIgnoreCase("default")) {
            password = CredentialsProvider.getPassword();
        }

        System.out.println("Enter password");
        bookingProcess.enterPassword(password);

    }


    @And("Click on the Login button")
    public void clickOnTheLoginButton() {
        System.out.println("Click on the login button");
        bookingProcess.clickLogin();
    }

    @And("Click on hotel image with map")
    public void clickOnHotelImageWithMap(Map<String, String> data) {
        System.out.println("Click on Hotel Iasi image");
        String hotelName = data.get("hotelName");
        bookingProcess.clickOnHotelImage(hotelName);
    }

    @And("Click on room image with map")
    public void clickOnRoomImageWithMap(Map<String, String> data) {
        System.out.println("Click on room 'dubla' image");
        String roomName = data.get("roomName");
        bookingProcess.clickOnRoomImage(roomName);
    }

    @And("Select main contact person")
    public void selectMainContactPerson(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String mainContactPerson = data.get(0).get("Value");

        System.out.println("Select " + mainContactPerson + " as the main contact person");
        bookingData.setMainContactPerson(mainContactPerson); // Set the value from BookingData
        bookingProcess.selectMainContactPerson(mainContactPerson); // Pass the value to BookingProcess method
    }

    @And("Click on first next step button")
    public void clickOnFirstNextStepButton() {
        System.out.println("Click on Next step button");
        bookingProcess.clickOnFirstNextStepButton("Next step");
    }

    @And("Fill the second booking form with map")
    public void fillSecondBookingFormWithMap(Map<String, String> data) {

        String roomType = data.get("roomType");
        String checkInDate = data.get("checkInDate");
        String checkOutDate = data.get("checkOutDate");

        bookingProcess.selectRoomOption(roomType);
        System.out.println("Select room name dubla: " + roomType);
        bookingProcess.enterCheckInDate(checkInDate);
        System.out.println("Select checkIn Date");
        bookingProcess.enterCheckOutDate(checkOutDate);
        System.out.println("Select checkOut Date");
    }

    @And("Click on second next step button")
    public void clickOnSecondNextStepButton() {
        System.out.println("Click on Next step button");
        bookingProcess.clickOnSecondNextStepButton("Next step");
    }

    @And("Fill People eating breakfast and number of pets with map")
    public void fillPeopleEatingBreakfastAndNumberOfPetsWithMap(Map<String, String> data) {
        int breakfastsPerDay = Integer.parseInt(data.get("breakfastsPerDay"));
        enterValueInTheField(breakfastsPerDay, "What is the number of people eating breakfast?");

        int numberOfPets = Integer.parseInt(data.get("numberOfPets"));
        enterValueInTheField(numberOfPets, "What is the number of pets?");
    }

    public void enterValueInTheField(int value, String fieldName) {
        System.out.println("Enter value: " + value + " in the field: " + fieldName);
        if (fieldName.equals("What is the number of people eating breakfast?")) {
            bookingProcess.peopleEatingBreakfast(value, "breakfastName"); // Adjust this method name as per your implementation
        } else if (fieldName.equals("What is the number of pets?")) {
            bookingProcess.enterNumberOfPets(value);
        }
    }

    @And("Click on third next step button")
    public void clickOnThirdNextStepButton() {
        System.out.println("Click on Next step button");
        bookingProcess.clickOnThirdNextStepButton("Next step");

    }

    @And("I select payment option from list")
    public void selectPaymentOptionFromList(DataTable dataTable) {
        List<String> paymentOptions = dataTable.asList(String.class);
        for (String paymentOption : paymentOptions) {
            bookingProcess.selectPaymentOption(paymentOption);
        }
    }

    @And("I select the {string}")
    public void selectPaymentOption(String paymentOption) {
        // Your implementation here based on the provided paymentOption
        List<String> paymentOptions = List.of("bank transfer", "credit card", "pay at the property");
        int paymentValue = paymentOptions.indexOf(paymentOption);

        if (paymentValue != -1) {
            // Perform the action to select the payment option
            System.out.println("Select payment option: " + paymentOption);
            // Add your code to select the payment option here based on the paymentValue
        } else {
            // If the payment option is not found in the list, fail the test
            throw new AssertionError("Payment option not found: " + paymentOption);
        }
    }


    @And("Click on fourth next step button")
    public void clickOnFourthNextStepButton() throws InterruptedException {
        System.out.println("Click on Next step button");
        bookingProcess.clickOnFourthNextStepButton("Next step");
        Thread.sleep(4000);
    }


    @And("Click on book holiday button with map")
    public void clickOnBookHolidayButtonWithMap(Map<String, String> data) {
        System.out.println("Click on book holiday button");
        String buttonName = data.get("buttonName");
        bookingProcess.clickOnBookHolidayButton(buttonName);
    }

    @Then("Check if booking message is displayed")
    public void checkBookingMessageIsDisplayed() {
        // Add the assertion to check if the booking message is displayed
        assertTrue(bookingProcess.isBookingMessageDisplayed());
    }

    @Then("The booking message should be displayed!")
    public void verifyBookingMessage() {
        System.out.println("A booking message will be displayed!");
        boolean isBookingMessageDisplayed = bookingProcess.isBookingMessageDisplayed();
        if (isBookingMessageDisplayed) {
            String messageText = bookingProcess.getBookingMessage();
            if (messageText.contains("Success!")) {
                System.out.println("Success!");
            } else if (messageText.contains("This property has no availability on our site!")) {
                System.out.println("This property has no availability on our site!");
            }
        } else {
            System.out.println("Booking message is not displayed!");
        }
    }
    @When("User puts credentials from list")
    public void putCredentialsFromList(List<String> dataTable) {
        String username = dataTable.get(0);
        String password = dataTable.get(1);

        if (username.equalsIgnoreCase("default")) {
            username = CredentialsProvider.getUsername();
        }

        if (password.equalsIgnoreCase("default")) {
            password = CredentialsProvider.getPassword();
        }

        bookingProcess.enterUsername(username);
        bookingProcess.enterPassword(password);

        System.out.println("Put credentials from list");
    }
    @When("Login with username {string} and password {string}")
    public void login(String username, String password) {
        if (username.equalsIgnoreCase("default")) {
            username = CredentialsProvider.getUsername();
        }

        if (password.equalsIgnoreCase("default")) {
            password = CredentialsProvider.getPassword();
        }

        System.out.println("Enter username and password");

        bookingProcess.enterUsername(username);
        bookingProcess.enterPassword(password);

        System.out.println("Click on login button");
        bookingProcess.clickLogin();
    }

}
