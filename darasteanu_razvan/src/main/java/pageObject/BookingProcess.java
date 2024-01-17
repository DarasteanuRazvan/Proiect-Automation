package pageObject;


import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;


public class BookingProcess {

    private WebDriver driver;
    private BookingData bookingData;

    public BookingProcess(WebDriver driver, BookingData bookingData) {
        this.driver = driver;
        this.bookingData = bookingData;
    }

    public String url = "http://138.68.69.185/login";

    private final By usernameInput = By.cssSelector("#__next > div > div > form > input:nth-child(2)");
    private final By passwordInput = By.cssSelector("#__next > div > div > form > input:nth-child(3)");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By hotelIasiImage = By.xpath("//div[@class='h-full grow cursor-pointer'][1]");
    private final By roomImageLocator = By.cssSelector("img[alt='rounded-xl']");
    private final By mainContactPerson = By.cssSelector("img[alt='rounded-xl']");
    private final By nextStepButton = By.xpath("//button[contains(text(),'Next step')]");
    private final By roomOption = By.xpath("//b[1]");
    private final By checkInDate = By.xpath("(//input[@type='date'])[1]");
    private final By checkOutDate = By.xpath("(//input[@type='date'])[2]");
    private final By nextStepButton2 = By.xpath("//button[contains(text(),'Next step')]");
    private final By peopleEatingBreakfast = By.cssSelector("div#__next input[type='number']");
    private final By numberOfPets = By.xpath("//div[@class='w-full p-2 flex flex-col gap-4']//div[contains(., 'What is the number of pets?')]/following-sibling::div/input[@type='number']");
    private final By nextStepButton3 = By.xpath("//button[contains(text(),'Next step')]");
    private final By dropdownMenu = By.cssSelector(".css-8mmkcg");
    private final By bankTransfer = By.id("react-select-2-option-0");
    private final By creditCard = By.id("react-select-2-option-1");
    private final By payAtTheProperty = By.id("react-select-2-option-2");
    private final By nextStepButton4 = By.xpath("//button[contains(text(),'Next step')]");
    private final By bookHolidayButton = By.xpath("//button[contains(text(),'Book holiday')]");
    private final By bookingNoAvailabilityMessage = By.xpath("//div[contains(text(),'This property has no availability on our site')]");

    public void enterUsername(String username) {
        try {
            driver.findElement(usernameInput).sendKeys(username);
        } catch (NoSuchElementException e) {
            // Handle the exception by failing the test and providing an error message
            Assert.fail("Failed to enter the username: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            driver.findElement(passwordInput).sendKeys(password);
        } catch (NoSuchElementException e) {
            // Handle the exception by failing the test and providing an error message
            Assert.fail("Failed to enter the password: " + e.getMessage());
        }
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickOnHotelImage(String hotelName) {

        driver.findElement(hotelIasiImage).click();
    }

    public void clickOnRoomImage(String roomName) {
        driver.findElement(roomImageLocator).click();
    }

    public void selectMainContactPerson(String contactPerson) {
        driver.findElement(mainContactPerson).click();
    }

    public void clickOnFirstNextStepButton(String buttonName) {
        driver.findElement(nextStepButton).click();
    }

    public void selectRoomOption(String roomType) {
        driver.findElement(roomOption).click();
    }

    public void enterCheckInDate(String checkinDate) {
        driver.findElement(checkInDate).sendKeys(checkinDate);
    }

    public void enterCheckOutDate(String checkoutDate) {
        driver.findElement(checkOutDate).sendKeys(checkoutDate);
    }

    public void clickOnSecondNextStepButton(String buttonName) {
        driver.findElement(nextStepButton2).click();
    }

    public void peopleEatingBreakfast(int value, String breakfastName) {
        WebElement fieldElement = driver.findElement(peopleEatingBreakfast);
        fieldElement.clear();
        fieldElement.sendKeys(String.valueOf(value));
    }

    public void enterNumberOfPets(int value) {
        WebElement fieldElement = driver.findElement(numberOfPets);
        fieldElement.clear();
        fieldElement.sendKeys(String.valueOf(value));
    }


    public void clickOnThirdNextStepButton(String buttonName) {
        driver.findElement(nextStepButton3).click();
    }


    public void selectPaymentOption(String paymentOption) {
        System.out.println("Selecting payment option: " + paymentOption);
        driver.findElement(dropdownMenu).click();

        switch (paymentOption.toLowerCase()) {
            case "bank transfer":
                driver.findElement(bankTransfer).click();
                break;
            case "credit card":
                driver.findElement(creditCard).click();
                break;
            case "pay at the property":
                driver.findElement(payAtTheProperty).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment option: " + paymentOption);
        }
    }


    public void clickOnFourthNextStepButton(String buttonName) {
        driver.findElement(nextStepButton4).click();
    }

    public void clickOnBookHolidayButton(String buttonName) {
        driver.findElement(bookHolidayButton).click();
    }

    public boolean isBookingMessageDisplayed() {
        return driver.findElement(bookingNoAvailabilityMessage).isDisplayed();
    }

    public String getBookingMessage() {
        WebElement bookingMessageElement = driver.findElement(bookingNoAvailabilityMessage);
        return bookingMessageElement.getText();
    }

}




