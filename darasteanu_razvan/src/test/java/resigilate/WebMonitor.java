package resigilate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebMonitor {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // URL of the product page
        String productUrl = "https://www.emag.ro/sistem-audio-jbl-partybox-1000-jbl-signature-sound-1100w-dj-pad-light-shows-bass-boost-bluetooth-usb-true-wireless-stereo-jblpartybox1000eu/pd/DH8NF5BBM/";

        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Main loop
        while (true) {
            driver.get(productUrl);
            WebElement discountedPriceElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='alternative-panel-rsb-label']")));

            if (discountedPriceElement.isDisplayed()) {
                String discountedPrice = discountedPriceElement.getText();
                System.out.println("Discounted price found: " + discountedPrice);
                // Here you can trigger an alarm or send a message
                // Replace this with your actual alarm/notification logic.
            }

            try {
                Thread.sleep(300000); // Wait for 5 minutes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Close the WebDriver when done
    }
}
