package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseSteps {
    private Connection connection;
    private Statement statement;

    public DatabaseSteps() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db-mysql-ams3-23743-do-user-9860045-0.b.db.ondigitalocean.com:25060/cursant",
                    "cursant2", "AVNS_bIIve-I0EUihV8muBUZ");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("The hotel must be deleted from the database")
    public void theHotelMustBeDeletedFromTheDatabase() {
        // Code to clear the Hotel table in the database
        String deleteQuery = "DELETE FROM Hotel WHERE id = '87506b5a-3df8-4967-9379-265925aa9873';";
        try {
            // Execute the Delete query
            statement.executeUpdate(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The Hotel is deleted from the database");
    }

    @When("I execute the insert query for a new hotel")
    public void executeInsertQuery() {
        try {
            String insertQuery = "INSERT INTO Hotel (id, name, description, starRating, userRating, " +
                    "amenities, pricePerBreakfast, allowsPets, breakfastAsOption, location) " +
                    "VALUES ('87506b5a-3df8-4967-9379-265925aa9873', 'Example Hotel', " +
                    "'This is an example hotel description.', 4, 9, 'Pool, Gym, Free Wi-Fi', 11, 1, 1, 'Pascani');";

            // Execute the Insert query
            int rowsAffected = statement.executeUpdate(insertQuery);

            // Assert that the Insert query affected at least one row
            assertTrue(rowsAffected > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The Hotel is inserted back into the database");
    }

    @Then("The new hotel should be inserted into the database")
    public void verifyHotelInsertion() {
        try {
            //
            // Example: Execute a Select query to retrieve the inserted hotel
            String selectQuery = "SELECT * FROM Hotel WHERE name = 'Example Hotel';";
            // Execute the Select query
            ResultSet resultSet = statement.executeQuery(selectQuery);

            // Assert that the result set has at least one row
            assertTrue(resultSet.next());

            // Print the values of the retrieved hotel record
            String name = resultSet.getString("name");
            int starRating = resultSet.getInt("starRating");
            double userRating = resultSet.getDouble("userRating");
            String location = resultSet.getString("location");

            System.out.println("Hotel Information:");
            System.out.println("Name: " + name);
            System.out.println("Star Rating: " + starRating);
            System.out.println("User Rating: " + userRating);
            System.out.println("Location: " + location);

            // Assert the values match the inserted hotel
            assertEquals("Example Hotel", name);
            assertEquals(4, starRating);
            assertEquals(9, userRating, 0.001);
            assertEquals("Pascani", location);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
