package pom;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObject.HomePage;
import pageObject.LoginPage;
import utils.BaseTestClass;


public class PageObjectModel extends BaseTestClass {

    String username = "BookingLoginTest@yahoo.com";
    String password = "7hkSG7RERiZ2neK";

    @Test
    public void loginTestWithoutPageObjectModel() {
        driver.get("http://138.68.69.185/");

        WebElement homePageLoginButton = driver.findElement(By.xpath("//div[text()='Login']"));
        homePageLoginButton.click();

        WebElement usernameInput = driver.findElement(By.cssSelector("#__next > div > div > form > input:nth-child(2)"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#__next > div > div > form > input:nth-child(3)"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        //wait
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.name("log-out-outline"));

        // Explicit wait until the logoutButton is visible
        waitForElementVisibility(By.name("log-out-outline"));

        Assert.assertTrue("Logout button is not displayed", logoutButton.isDisplayed());

        logoutButton.click();
    }

    @Test
    public void loginTestWithPageObject() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        HomePage homePage = new HomePage(driver);

        //Explicit wait until the logoutButton is visible
        waitForElementVisibility(LoginPage.logoutButton);

        Assert.assertTrue("Logout button is not displayed", homePage.isLogoutButtonIsDisplayed());
    }

    @Test
    public void loginTestWithPageObjectAdvanced() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginWith(username, password);

        HomePage homePage = new HomePage(driver);

        //Explicit wait until the logoutButton is visible
        waitForElementVisibility(LoginPage.logoutButton);

        Assert.assertTrue("Logout button is not displayed", homePage.isLogoutButtonIsDisplayed());
    }

    @Test
    public void loginTestWithPageObjectAdvanced2() {

        LoginPage loginPage = new LoginPage(driver);

        HomePage homePage = new HomePage(driver);

        loginPage.loginWithCredentials(username, password);


        //Explicit wait until the logoutButton is visible
        waitForElementVisibility(LoginPage.logoutButton);

        Assert.assertTrue("Logout button is not displayed", homePage.isLogoutButtonIsDisplayed());
    }

    @Test
    public void loginTestWithPageObjectAdvancedOnlyForUs() {
        new LoginPage(driver).loginWithCredentials(username, password);

        //Explicit wait until the logoutButton is visible
        waitForElementVisibility(LoginPage.logoutButton);

        Assert.assertTrue("Logout button is not displayed",
                new HomePage(driver).isLogoutButtonIsDisplayed());
    }
}
