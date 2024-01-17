package database;

import java.sql.*;

public class DatabaseProcessCRUD {

    public static final String DatabaseUrl = "jdbc:mysql://db-mysql-ams3-23743-do-user-9860045-0.b.db.ondigitalocean.com:25060/cursant";
    private static final String username = "cursant2";
    private static final String password = "AVNS_bIIve-I0EUihV8muBUZ";

    public void createHotel() {
        try (Connection connection = DriverManager.getConnection(DatabaseUrl, username, password);
             Statement statement = connection.createStatement()) {

            String createQuery = "INSERT INTO Hotel (id, name, description, starRating, userRating, amenities, pricePerBreakfast, allowsPets, breakfastAsOption, location)" +
                    "VALUES ('1', 'Example Hotel', 'This is an example hotel description.', '4', '9', 'Pool, Gym, Free Wi-Fi', '11', '1', '1', 'Pascani')";
            int rowsAffected = statement.executeUpdate(createQuery);

            System.out.println("Create operation: " + rowsAffected + " row(s) affected.");
            System.out.println("Hotel created!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readHotel() {
        try (Connection connection = DriverManager.getConnection(DatabaseUrl, username, password);
             Statement statement = connection.createStatement()) {

            String readQuery = "SELECT * FROM Hotel WHERE name = 'Example Hotel'";
            ResultSet resultSet = statement.executeQuery(readQuery);
            if (resultSet.next()) {
                String hotelID = resultSet.getString("id");
                String hotelName = resultSet.getString("name");
                int starRating = resultSet.getInt("starRating");
                double userRating = resultSet.getDouble("userRating");
                String location = resultSet.getString("location");
                System.out.println("Read operation: Hotel Name: " + hotelName + ", Star Rating: " + starRating + ", User Rating: " + userRating + ", Location: " + location);
            } else {
                System.out.println("No hotel found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHotel() {
        try (Connection connection = DriverManager.getConnection(DatabaseUrl, username, password);
             Statement statement = connection.createStatement()) {

            String updateQuery = "UPDATE Hotel SET starRating = 5 WHERE name = 'Example Hotel'";
            int rowsAffected = statement.executeUpdate(updateQuery);
            System.out.println("Update operation: " + rowsAffected + " row(s) affected.");
            System.out.println("Hotel updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHotel() {
        try (Connection connection = DriverManager.getConnection(DatabaseUrl, username, password);
             Statement statement = connection.createStatement()) {

            String deleteQuery = "DELETE FROM Hotel WHERE name = 'Example Hotel'";
            int rowsAffected = statement.executeUpdate(deleteQuery);
            System.out.println("Delete operation: " + rowsAffected + " row(s) affected.");
            System.out.println("Hotel deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeSQLQuery() {
        try {
            DatabaseSQLQuery query = new DatabaseSQLQuery(DatabaseUrl, username, password);
            query.writeQuery();
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}

