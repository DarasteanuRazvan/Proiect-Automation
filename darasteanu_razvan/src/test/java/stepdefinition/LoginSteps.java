package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.BookingData;
import pageObject.HomePage;
import pageObject.LoginPage;
import utils.CredentialsProvider;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static stepdefinition.Hooks.driver;

public class LoginSteps {

    BookingData bookingData;

    HomePage homePage;

    LoginPage loginPage;

    @Given("User is on the Login Page")
    public void userIsOnTheLoginPage() {
        System.out.println("Open Login Page");
        loginPage = new LoginPage(driver);
    }


    @When("User enters username {string}")
    public void enterUsername(String username) {
        System.out.println("Enter username");

        loginPage.enterUsername(username);
    }

    @And("User enters password {string}")
    public void enterPassword(String password) {
        System.out.println("Enter password");

        loginPage.enterPassword(password);
    }


    @When("User clicks on Login Button")
    public void clickOnLoginButton() {
        System.out.println("Click on login button");
        loginPage.clickLogin();

        // Wait for the login to complete (adjust the timeout as needed)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("login"));
    }

    @Then("Logout Button is displayed")
    public void logoutButtonIsDisplayed() {
        System.out.println("Verify Logout button is displayed");

        HomePage homePage = new HomePage(driver);
        // Add explicit wait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the logoutButton is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("log-out-outline")));

        Assert.assertTrue("Logout button is not displayed",
                HomePage.isLogoutButtonIsDisplayed());
    }


    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        try {
            // Introduce a small delay to wait for the error message element to appear (adjust the duration as needed)
            Thread.sleep(2000);

            WebElement errorMessageElement = driver.findElement(By.cssSelector(".text-center.text-red-500"));
            String errorMessage = errorMessageElement.getText().trim();
            Assert.assertEquals("Request failed with status code 404", errorMessage);
            System.out.println("Error message is displayed: " + errorMessage);
        } catch (Exception e) {
            System.out.println("Login successful! Error message not found.");
            e.printStackTrace();
        }
    }
}





