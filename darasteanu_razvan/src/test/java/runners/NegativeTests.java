package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.DisableLogging.setupChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "C:/Proiect Curs Automation/darasteanu_razvan/src/test/java/features",
        glue = "stepdefinition",
        tags = "@Negative",
        plugin = {"pretty"},// "html:target/SmokeTests.html"},
        publish = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class NegativeTests {

    public static void main(String[] args) throws IOException {
        setupChromeDriver();
        Date startTime = new Date();
        Result result = JUnitCore.runClasses(NegativeTests.class);
        Date endTime = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Test Execution Summary");
        System.out.println("----------------------------------------------------");
        System.out.println("Start Time: " + formatter.format(startTime));
        System.out.println("End Time: " + formatter.format(endTime));
        System.out.println("Tests Run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());
        System.out.println("Errors: " + result.getFailureCount());
        System.out.println("Skipped: " + result.getIgnoreCount());
        System.out.println("Time Elapsed: " + result.getRunTime() + " ms");
        System.out.println("----------------------------------------------------");
    }
}

