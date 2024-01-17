package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;


public class Hooks {

    static WebDriver driver;

    @Before
    public void setupBefore() {
        System.out.println("Initializing the driver");
        driver = new ChromeDriver();
        // Set the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // Set background color to black
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.backgroundColor = 'black';");

    }

    @After
    public void tearDownAfter() {
        System.out.println("Closing the driver");
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setupChromeDriver() {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.OFF);
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        driver = new ChromeDriver();
    }
}