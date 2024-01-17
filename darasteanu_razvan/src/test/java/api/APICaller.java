package api;

import utils.ConsoleLogger;

import java.io.UnsupportedEncodingException;

public class APICaller {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String requestDetails = APIWithJOptionPane.executeAPIRequestWithDialog();
        System.out.println("API request: " + requestDetails);
        ConsoleLogger.logResult();
    }
}
