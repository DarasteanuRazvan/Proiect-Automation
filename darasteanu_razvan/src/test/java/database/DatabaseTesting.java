package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseTesting {

    public static void main(String[] args) {

        Connection connection = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db-mysql-ams3-23743-do-user-9860045-0.b.db.ondigitalocean.com:25060/cursant",
                    "cursant2", "AVNS_bIIve-I0EUihV8muBUZ");

            Statement statement = connection.createStatement();

            System.out.println("Connected to the database!");

            System.out.println("Executing the following query: SELECT * FROM Hotel;");

            resultSet = statement.executeQuery("SELECT * FROM Hotel;");

// Process and print the result set for the first query
            System.out.println("Results for the first query:");
            System.out.println("id | name | description | starRating | userRating | amenities | pricePerBreakfast | allowsPets | breakfastAsOption | location");

            while (resultSet.next()) {
                System.out.print(" | ");
                System.out.print(resultSet.getString("id") + " | ");
                System.out.print(resultSet.getString("name") + " | ");
                System.out.print(resultSet.getString("description") + " | ");
                System.out.print(resultSet.getString("starRating") + " | ");
                System.out.print(resultSet.getString("userRating") + " | ");
                System.out.print(resultSet.getString("amenities") + " | ");
                System.out.print(resultSet.getString("pricePerBreakfast") + " | ");
                System.out.print(resultSet.getString("allowsPets") + " | ");
                System.out.print(resultSet.getString("breakfastAsOption") + " | ");
                System.out.print(resultSet.getString("location") + " | ");
                System.out.println();
            }

            System.out.println("----------------------------------");


            System.out.println("Executing the following query: SELECT * FROM Room;");
            resultSet = statement.executeQuery("SELECT * FROM Room;");

// Process and print the result set for the second query
            System.out.println("Results for the second query:");
            System.out.println("breakfastIncluded | img | description | maximumNumberOfGuests | price | type | hotelId | id");


            while (resultSet.next()) {
                System.out.print(" | ");
                System.out.print(resultSet.getString("breakfastIncluded") + " | ");
                System.out.print(resultSet.getString("img") + " | ");
                System.out.print(resultSet.getString("description") + " | ");
                System.out.print(resultSet.getString("maximumNumberOfGuests") + " | ");
                System.out.print(resultSet.getString("price") + " | ");
                System.out.print(resultSet.getString("type") + " | ");
                System.out.print(resultSet.getString("hotelId") + " | ");
                System.out.print(resultSet.getString("id") + " | ");
                System.out.println();
            }

            System.out.println("----------------------------------");


            System.out.println("Executing the following query: SELECT * FROM TimeInterval;");
            resultSet = statement.executeQuery("SELECT * FROM TimeInterval;");

// Process and print the result set for the third query
            System.out.println("Results for the third query:");
            System.out.println("id | min | max | hotelId ");

            while (resultSet.next()) {
                System.out.print(" | ");
                System.out.print(resultSet.getString("id") + " | ");
                System.out.print(resultSet.getString("min") + " | ");
                System.out.print(resultSet.getString("max") + " | ");
                System.out.print(resultSet.getString("hotelId") + " | ");
                System.out.println();
            }

            System.out.println("----------------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection and result set in the finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}






