package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static WebDriver driver;
    String url = "http://138.68.69.185/";

    static By logoutButton = By.name("log-out-outline");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static boolean isLogoutButtonIsDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }


}


