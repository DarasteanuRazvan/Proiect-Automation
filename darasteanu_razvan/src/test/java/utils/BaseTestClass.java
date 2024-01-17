package utils;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTestClass {


    public static WebDriver driver;
    private static final Duration explicitWaitTimeout = Duration.ofSeconds(10);

    @Before
    public void initializeDriver() {
        System.out.println("Before superclass");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }

        @After
    public void quitDriver() {
        System.out.println("After superclass");
        driver.quit();
    }

    protected void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, explicitWaitTimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void setupChromeDriver() {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        driver = new ChromeDriver();
    }
}

