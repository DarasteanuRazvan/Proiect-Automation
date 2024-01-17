package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.BookingData;
import pageObject.BookingProcess;
import pageObject.RoomOption;
import static pageObject.BookingData.*;
import static stepdefinition.Hooks.driver;

public class BookingProcessSteps {
    private BookingProcess bookingProcess;
    private BookingData bookingData;

    public BookingProcessSteps() {
    }

    @Given("Be on Login Page")
    public void beOnLoginPage() {
        System.out.println("Open Login Page");
        driver.get("http://138.68.69.185/login");
        this.bookingData = new BookingData();
        this.bookingProcess = new BookingProcess(driver, bookingData);
    }

    @When("I enter username {string}")
    public void enterUsername(String username) {
        System.out.println("Enter username");

        try {
            bookingData.setUsername(username);
            bookingProcess.enterUsername(username);
        } catch (Exception e) {
            Assert.fail("Failed to enter the username: " + e.getMessage());
        }
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        System.out.println("Enter password");

        try {
            bookingData.setPassword(password);
            bookingProcess.enterPassword(password);
        } catch (Exception e) {
            Assert.fail("Failed to enter the password: " + e.getMessage());
        }
    }


    @And("I click on the login button")
    public void clickOnTheLoginButton() {
        System.out.println("Click on the login button");
        bookingProcess.clickLogin();
    }

    @And("I click on the {string} image")
    public void clickOnHotelImage(String hotelName) {
        System.out.println("Click on " + hotelName + " image");
        bookingData.setHotel(hotelName);
        bookingProcess.clickOnHotelImage(hotelName);
    }

    @And("I click on the room {string} image")
    public void clickOnRoomImage(String roomName) {
        System.out.println("Click on " + roomName + " room image");
        bookingData.setRoomType(roomName);
        bookingProcess.clickOnRoomImage(roomName);
    }

    @And("I select {string} as the main contact person")
    public void selectMainContactPerson(String contactPerson) {
        System.out.println("Select " + contactPerson + " as the main contact person");
        bookingData.setMainContactPerson(contactPerson); // Set the value from BookingData
        bookingProcess.selectMainContactPerson(contactPerson); // Pass the value to BookingProcess method
    }

    @And("I click on the first {string} button")
    public void clickOnFirstNextStepButton(String buttonName) {
        System.out.println("Click on the first 'Next step' button");
        bookingProcess.clickOnFirstNextStepButton(buttonName);
    }

    @And("I select room {string}")
    public void selectRoomOption(String roomName) {
        System.out.println("Select room option " + roomName);
        bookingData.setRoomOption(RoomOption.tripla);
        bookingProcess.selectRoomOption(roomName);
    }

    @And("I enter check-in date {string}")
    public void enterCheckInDate(String date) {
        System.out.println("Enter check-in date: " + date);
        bookingProcess.enterCheckInDate(date);
    }

    @And("I enter check-out date {string}")
    public void enterCheckOutDate(String date) {
        System.out.println("Enter check-out date: " + date);
        bookingProcess.enterCheckOutDate(date);
    }

    @And("I click on the second {string} button")
    public void clickOnSecondNextStepButton(String buttonName) {
        System.out.println("Click on the second 'Next step' button");
        bookingProcess.clickOnSecondNextStepButton(buttonName);
    }

    @And("I enter {int} in the field {string}")
    public void enterValueInTheField(int value, String fieldName) {
        System.out.println("Enter value: " + value + " in the field: " + fieldName);
        bookingProcess.peopleEatingBreakfast(value, fieldName);
    }

    @And("I enter {int} in the second field {string}")
    public void enterValueInTheSecondField(int value, String fieldName) {
        System.out.println("Enter value: " + value + " in the field: " + fieldName);
        bookingProcess.enterNumberOfPets(value);
    }

    @And("I click on the third {string} button")
    public void clickOnThirdNextStepButton(String buttonName) {
        System.out.println("Click on the third 'Next step' button");
        bookingProcess.clickOnThirdNextStepButton(buttonName);
    }


    @When("I select {string} as the payment option")
    public void selectPaymentOption(String paymentOption) {
        bookingProcess.selectPaymentOption(paymentOption);
    }


    @And("I click on the fourth {string} button")
    public void clickOnFourthNextStepButton(String buttonName) throws InterruptedException {
        System.out.println("Click on the fourth 'Next step' button");
        bookingProcess.clickOnFourthNextStepButton(buttonName);
    }

    @And("I click on the {string} button")
    public void clickOnBookHolidayButton(String buttonName) {
        System.out.println("Click on the 'Book holiday' button");
        bookingProcess.clickOnBookHolidayButton(buttonName);
    }

    @Then("I should see the booking message!")
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

    @When("Making the booking process in one step")
    public void makingBookingInOneStep() {
        System.out.println("Making a booking process in one step");

        driver.get("http://138.68.69.185/login");
        this.bookingData = new BookingData();
        this.bookingProcess = new BookingProcess(driver, bookingData);

        // Adding bookingData
        bookingData.setUsername("BookingLoginTest@yahoo.com");
        bookingData.setPassword("7hkSG7RERiZ2neK");
        bookingData.setHotel("Hotel Iasi");
        bookingData.setRoomType("tripla");
        bookingData.setMainContactPerson("Me");
        bookingData.setRoomOption(RoomOption.tripla);
        bookingData.setCheckInDate("01/05/2024");
        bookingData.setCheckOutDate("01/06/2024");
        bookingData.enterValueInTheField(1, "What is the number of people eating breakfast?");
        bookingData.enterValueInTheField(1, "What is the number of pets?");


        // Calling the respective methods in the BookingProcess class to perform the steps
        bookingProcess.enterUsername(bookingData.getUsername());
        bookingProcess.enterPassword(bookingData.getPassword());
        bookingProcess.clickLogin();
        bookingProcess.clickOnHotelImage(hotelName);
        bookingProcess.clickOnRoomImage(roomName);
        bookingProcess.selectMainContactPerson(contactPerson);
        bookingProcess.clickOnFirstNextStepButton("Next step");
        bookingProcess.selectRoomOption(roomName);
        bookingProcess.enterCheckInDate(checkinDate);
        bookingProcess.enterCheckOutDate(checkoutDate);
        bookingProcess.clickOnSecondNextStepButton("Next step");
        bookingProcess.peopleEatingBreakfast(1, "breakfast-name");
        bookingProcess.clickOnThirdNextStepButton("Next step");
        bookingProcess.clickOnFourthNextStepButton("Next step");
        bookingProcess.clickOnBookHolidayButton("Book holiday");
    }

}

























