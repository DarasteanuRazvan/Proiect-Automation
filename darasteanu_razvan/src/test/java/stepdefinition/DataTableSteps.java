package stepdefinition;

import io.cucumber.java.en.When;

import java.sql.*;
import java.util.List;
import java.util.Map;


public class DataTableSteps {

    @When("Fill data with list")
    public void fillDataWithList(List<String> testData) {

        for (int i = 0; i < testData.size(); i++) {
            System.out.println("Pe randul " + (i + 1) + " este: " + testData.get(i));
        }
    }

    @When("Fill data with map")
    public void fillDataWithMap(Map<String, String> testData) {

        for (Map.Entry<String, String> entry : testData.entrySet()) {
            System.out.println("Cheia: " + entry.getKey() + " are valoarea: " + entry.getValue());
        }
    }

    @When("Fill data with table")
    public void fillDataWithTable(List<Map<String, String>> testData) {

        for (int i = 0; i < testData.size(); i++) {
            System.out.println("Suntem la lista" + (i+1));
            for (Map.Entry<String, String> entry : testData.get(i).entrySet()) {
                System.out.println("Cheia: " + entry.getKey() + " are valoarea: " + entry.getValue());
            }
        }
    }
}
