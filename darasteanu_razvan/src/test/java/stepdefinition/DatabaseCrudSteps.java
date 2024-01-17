package stepdefinition;

import database.DatabaseCallerCRUD;
import database.DatabaseSQLQuery;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import database.DatabaseProcessCRUD;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseCrudSteps {

    private DatabaseSQLQuery query;

    private ResultSet queryResult;
    private DatabaseProcessCRUD dbOperations;

    public DatabaseCrudSteps() {
        dbOperations = new DatabaseProcessCRUD();
    }

    @Given("I create a hotel")
    public void iCreateAHotel() {
        dbOperations.createHotel();
    }

    @Then("the hotel should be created!")
    public void theHotelShouldBeCreated() {
        System.out.println("Hotel created!");
    }

    @When("I read the hotel")
    public void iReadTheHotel() {
        dbOperations.readHotel();
    }

    @Then("the hotel should be found!")
    public void theHotelShouldBeFound() {
        if (noHotelFound()) {
            System.out.println("No hotel found!");
        }
    }

    @Then("I update the hotel")
    public void iUpdateTheHotel() {
        dbOperations.updateHotel();
    }

    @Then("the hotel should be updated!")
    public void theHotelShouldBeUpdated() {
        System.out.println("Hotel updated!");
    }

    @And("I delete the hotel")
    public void iDeleteTheHotel() {
        dbOperations.deleteHotel();
    }

    @Then("the hotel should be deleted!")
    public void theHotelShouldBeDeleted() {
        System.out.println("Hotel deleted!");
    }

    private boolean noHotelFound() {
        // Add your logic to check if no hotel was found
        return false;
    }


    @When("I execute a SQL query")
    public void executeSQLQueryStep() {
        DatabaseCallerCRUD databaseCallerCRUD = new DatabaseCallerCRUD();
        DatabaseProcessCRUD databaseProcessCRUD = new DatabaseProcessCRUD();
        databaseProcessCRUD.executeSQLQuery();
    }

    @Then("I receive a result from that query")
    public void receiveSQLQueryResultStep() {
        try {
            if (queryResult != null) {
                System.out.println("Query result received:");
                while (queryResult.next()) {
                    // You can access individual columns from the resultSet using column names or indices.
                    // For example, assuming the table has a "name" and "age" column:
                    String name = queryResult.getString("name");
                    int age = queryResult.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            } else {
                System.out.println("No query result received.");
            }
        } catch (SQLException e) {
            System.out.println("Error processing query result: " + e.getMessage());
        }
    }
}

