package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialsProvider {

    private static final Properties credentials = new Properties();

    static {
        // Load the credentials file
        try (FileInputStream configFile = new FileInputStream("C:/Proiect Curs Automation/darasteanu_razvan/src/test/resources/credentials.properties")) {
            credentials.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUsername() {
        return credentials.getProperty("username");
    }

    public static String getPassword() {
        return credentials.getProperty("password");
    }
}
