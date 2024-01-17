package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger {
    public static void logResult() {
        String timestamp = getCurrentTimestamp();
        String location = getCurrentLocation();

        System.out.println("[" + timestamp + "] ");
        System.out.println("Location: " + location);
        System.out.println("-------------------------");
    }

    private static String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    private static String getCurrentLocation() {
        // Customize this method to retrieve the location information based on your project setup
        return "România";
    }
}
