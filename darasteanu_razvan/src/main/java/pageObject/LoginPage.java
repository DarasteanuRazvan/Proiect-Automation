package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    BookingData bookingData;


    public String url = "http://138.68.69.185/login";

    public static By usernameInput = By.cssSelector("#__next > div > div > form > input:nth-child(2)");
    public static By passwordInput = By.cssSelector("#__next > div > div > form > input:nth-child(3)");
    public static By loginButton = By.xpath("//button[@type='submit']");

    public By homePageLoginButton = By.cssSelector(".hover-icon.text-sm.bg-emerald-500.p-2.rounded.font-bold");

    public static By logoutButton = By.name("log-out-outline");

    //     constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(url);
    }

    // actiuni
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginWithCredentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void loginWith(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public boolean areCredentialsCorrect(String username, String password) {
        if (this.bookingData.getUsername().equals(username) && this.bookingData.getPassword().equals(password)) {
            System.out.println("Correct username and password.");
            return true;
        } else {
            System.out.println("Incorrect username and/or password.");
            return false;
        }
    }
}


