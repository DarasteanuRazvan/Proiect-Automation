# Booking Automation Project

Welcome to my Booking Automation Project! This automation project aims to automate the booking process on a booking page using Cucumber, IntelliJ, and Java.

This is just a preview. For the full code, please contact me and i will grant a collaborator access for you. Thank you!

## Project Details

- The booking page URL: [http://138.68.69.185/]
- Framework: Cucumber
- IDE: IntelliJ
- Programming Language: Java

## Setup Instructions

1. Clone this repository to your local machine.
2. Open the project in IntelliJ.
3. Set up the necessary dependencies for Cucumber and WebDriver.
4. Configure the Cucumber runner to execute the feature file.

## Feature Details

The project includes a feature file that describes the booking process with various steps. Each step represents a specific action or verification during the booking process.

## Project Overview

This project, titled "Booking Automation Project" is a Java-based automation project focused on testing various functionalities of a booking application. The primary goal is to automate end-to-end testing of the booking application, covering user login, database operations, API testing, and more.

## Project Structure

The project is structured as follows:

**.idea**: Directory containing configuration files for IntelliJ IDEA (IDE) project settings.
**runners**: Contains Cucumber test runners for executing the feature files related to the booking process.
**BookingProcess**: Directory containing feature files related to the booking process.
**credentials.properties**: Properties file containing login credentials (username and password) for the booking application.
**DataTableSteps**: Class file with Cucumber step definitions for handling DataTables in test scenarios.
**chromedriver_win32 (2).zip**: Archive file containing the ChromeDriver executable for Windows.
**LoginPositive.feature**: Feature file with positive test scenarios for user login.
**LoginPage**: Directory containing page object model classes representing the login page.
**cucumber.properties**: Properties file containing Cucumber configuration settings.
**DatabaseTesting**: Directory containing feature files related to database testing.
**DatabaseCallerCRUD.feature**: Feature file with CRUD database operations.
**resources**: Directory containing various resource files like property files.
**DisableLogging**: Class file for disabling Selenium logging to improve console output.
**libs**: Directory containing external libraries or dependencies.
**database**: Directory containing feature files for database testing.
**DatabaseQueries.feature**: Feature file with scenarios related to database queries.
**src**: Source directory containing Java source code.
**main**: Main package containing the main entry point for the application.
**java**: Directory containing Java source code.
**seleniumcourse.utils**: Package containing utility classes.
**BaseTestClass**: Class file providing a base test class with WebDriver initialization.
**ConsoleLogger**: Class file for logging results to the console.
**CredentialsProvider**: Class file for providing login credentials from the properties file.
**pageObject**: Package containing page object model classes.
**BookingData**: Class file for handling booking data.
**HomePage**: Class file representing the home page of the application.
**HotelObject**: Class file representing a hotel object.
**LoginPage**: Class file representing the login page.
**RoomOption**: Class file representing room options for booking.
**DatabaseWithMap**: Class file for handling database operations with a map.
**resources**: Directory containing resources, including ChromeDriver executable files.
**test**: Directory containing test classes and feature files.
**DatabaseCrudSteps**: Class file with Cucumber step definitions for CRUD database operations.
**Hooks**: Class file containing Cucumber hooks (Before and After).
**LoginSteps**: Class file with Cucumber step definitions for login-related testing.
**ApiBookingProcessSteps**: Class file with Cucumber step definitions for API booking process testing.
**BookingProcessSteps**: Class file with Cucumber step definitions for the booking process.
**DatabaseProcessCRUD**: Class file for handling CRUD operations on the database.
**features**: Directory containing Cucumber feature files.
**build**: Directory containing build artifacts and generated files.
**target**: Directory containing compiled classes and build artifacts.
**.gitignore**: File specifying ignored files and directories for version control.
**pom.xml**: Maven project configuration file specifying dependencies and build settings.
**README.md**: Markdown file providing an overview of the project and its structure.
**module-info.java**: Java module declaration file specifying dependencies and exported packages.

Processes and Main Ideas

* The project is an end-to-end automation testing project for a booking application.
* Cucumber is used for defining test scenarios in Gherkin language.
* JUnit is utilized for test execution, and Selenium is used for web automation.
* The project includes positive and negative test scenarios for user login, booking process, API testing, and database testing.
* The project follows the page object model design pattern for maintaining test code and page elements separately.
* The CredentialsProvider class is used to retrieve login credentials from the credentials.properties file.
* The BaseTestClass provides a base test class with WebDriver initialization and common utility methods.
* The Hooks class contains Cucumber hooks for setup and teardown before and after each scenario.
* The DisableLogging class disables Selenium logging for a cleaner console output.
* The ConsoleLogger class logs test results to the console with timestamps and locations.
* The project includes API testing using the APICaller class and API feature files.
* The project follows Maven as the build tool and contains a pom.xml file for dependency management.
* The DatabaseSQLQuery class handles executing SQL queries on the database.
* The DatabaseCallerCRUD class handles CRUD operations on the database.
* The DatabaseProcessCRUD class handles CRUD operations for database testing.
* The project uses the ChromeDriver for web automation on the Chrome browser.
* The project is organized into multiple packages for better code management and separation of concerns.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.

## License

This project is licensed under the [Darasteanu Razvan(18/01/2024).
