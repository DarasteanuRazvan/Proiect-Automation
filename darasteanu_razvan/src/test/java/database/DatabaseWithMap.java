package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DatabaseWithMap {

        public static void main(String[] args) {

            DatabaseWithMap databaseWithMap = new DatabaseWithMap();

            // Create sample test data
            List<Map<String, String>> testData = new ArrayList<>();

            // Call the fillDataWithTable method
            databaseWithMap.fillDataWithTable(testData);

            // Add a query for retrieving all columns from the "Hotel" table
            Map<String, String> query1 = new HashMap<>();
            query1.put("query", "SELECT * FROM Hotel WHERE name = 'Bed&Wine';");
            testData.add(query1);

            // Add a query for retrieving specific columns from the "Hotel" table
            Map<String, String> query2 = new HashMap<>();
            query2.put("query", "SELECT id, name FROM Hotel;");
            testData.add(query2);

            // Add a query for retrieving specific columns from the "Hotel" table
            Map<String, String> query3 = new HashMap<>();
            query3.put("query", "SELECT name, starRating, userRating, location FROM Hotel WHERE id = '97506b5a-3df8-4967-9379-265925aa9839';");
            testData.add(query3);

            // Add a query for retrieving specific columns from the "Hotel" table
            Map<String, String> query4 = new HashMap<>();
            query4.put("query", "SELECT id, name FROM Hotel;");
            testData.add(query4);

            // Add a query for retrieving specific columns from the "Hotel" table with a condition
            Map<String, String> query5 = new HashMap<>();
            query5.put("query", "SELECT id, name, breakfastAsOption FROM Hotel WHERE breakfastAsOption = TRUE;");
            testData.add(query5);

            // Add a query to select a specific row from the "Hotel" table
            Map<String, String> query6 = new HashMap<>();
            query6.put("query", "SELECT * FROM Hotel WHERE id = '97506b5a-3df8-4967-9379-265925aa9839' AND name = 'Cabana Plapumioara';");
            testData.add(query6);

            // Call the fillDataWithTable method
            databaseWithMap.fillDataWithTable(testData);
        }

        // Method to execute the SQL query and return the results as a list of maps
        public void fillDataWithTable(List<Map<String, String>> testData) {
            // Define your database connection properties
            String dbUrl = "jdbc:mysql://db-mysql-ams3-23743-do-user-9860045-0.b.db.ondigitalocean.com:25060/cursant";
            String username = "cursant2";
            String password = "AVNS_bIIve-I0EUihV8muBUZ";

            // Connection and ResultSet objects
            Connection connection = null;
            ResultSet resultSet = null;

            try {
                // Establish the database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(dbUrl, username, password);
                System.out.println("Connected to the database!");

                for (Map<String, String> queryData : testData) {
                    String query = queryData.get("query");
                    System.out.println("Executing query: " + query);

                    // Create a statement and execute the query
                    Statement statement = connection.createStatement();
                    resultSet = statement.executeQuery(query);

                    // Get column names from the result set
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    List<String> columnNames = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        columnNames.add(metaData.getColumnName(i));
                    }

                    // Print the query results
                    while (resultSet.next()) {
                        for (String columnName : columnNames) {
                            System.out.println(columnName + ": " + resultSet.getObject(columnName));
                        }
                        System.out.println();
                    }

                    // Close the statement after executing the query
                    statement.close();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the connection and result set when done
                try {
                    if (resultSet != null) resultSet.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}






