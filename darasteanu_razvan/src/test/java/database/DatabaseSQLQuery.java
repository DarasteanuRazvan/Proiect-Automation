package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseSQLQuery {

    private String databaseURL;
    private String username;
    private String password;
    private Connection connection;

    public DatabaseSQLQuery(String databaseURL, String username, String password) throws SQLException {
        this.databaseURL = databaseURL;
        this.username = username;
        this.password = password;
        connection = DriverManager.getConnection(databaseURL, username, password);
    }

    public void writeQuery() {
        String query = JOptionPane.showInputDialog("Enter your SQL query:");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int j = 1; j <= columnCount; j++) {
                System.out.print(metaData.getColumnName(j) + " | ");
            }
            System.out.println();

            // Print data rows
            while (resultSet.next()) {
                for (int j = 1; j <= columnCount; j++) {
                    System.out.print(resultSet.getString(j) + " | ");
                }
                System.out.println();
            }

            JOptionPane.showMessageDialog(null, "Query executed successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error executing query: " + e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Ignore
                }
            }
        }
    }

    public void printQueryResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            // You can access individual columns from the resultSet using column names or indices.
            // For example, assuming the table has a "name" and "age" column:
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) throws SQLException {
        DatabaseSQLQuery query = new DatabaseSQLQuery("jdbc:mysql://db-mysql-ams3-23743-do-user-9860045-0.b.db.ondigitalocean.com:25060/cursant", "cursant2", "AVNS_bIIve-I0EUihV8muBUZ");
        query.writeQuery();
    }
}

