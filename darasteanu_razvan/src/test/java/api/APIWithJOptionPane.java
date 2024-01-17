package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;

public class APIWithJOptionPane {


    public static String executeAPIRequestWithDialog() throws UnsupportedEncodingException {
        String url = JOptionPane.showInputDialog("Enter the URL for the API request:");
        String method = JOptionPane.showInputDialog("Enter the HTTP method (GET, POST, PUT, DELETE):");

        if (isValidHttpMethod(method)) {
            performAPIRequest(url, method);
            return "URL: " + url + ", Method: " + method;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid HTTP method!");
            return null;
        }
    }

    private static boolean isValidHttpMethod(String method) {
        return method != null && (method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("POST") ||
                method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE"));
    }

    private static void performAPIRequest(String url, String method) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpRequestBase request;

        switch (method.toUpperCase()) {
            case "GET":
                request = new HttpGet(url);
                break;
            case "POST":
                request = new HttpPost(url);
                ((HttpPost) request).setEntity(getRequestBodyFromDialog());
                break;
            case "PUT":
                request = new HttpPut(url);
                ((HttpPut) request).setEntity(getRequestBodyFromDialog());
                break;
            case "DELETE":
                request = new HttpDelete(url);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid HTTP method!");
                return;
        }

        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String responseBody = EntityUtils.toString(entity);
                Object responseObject = parseResponseObject(responseBody);
                System.out.println("API Response:\n" + responseObject.toString());

                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Status Code: " + statusCode);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error executing API request: " + e.getMessage());
        }
    }

    private static HttpEntity getRequestBodyFromDialog() {
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        int result = JOptionPane.showOptionDialog(null, scrollPane, "Enter Request Body",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            String requestBody = textArea.getText();
            return new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        }

        return null;
    }

    private static Object parseResponseObject(String responseBody) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = gson.fromJson(responseBody, JsonElement.class);

            if (jsonElement.isJsonObject()) {
                return gson.fromJson(jsonElement, Object.class);
            } else if (jsonElement.isJsonArray()) {
                return gson.fromJson(jsonElement, Object[].class);
            } else {
                return responseBody;
            }
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Error parsing API response: " + e.getMessage());
            return null;
        }
    }
}
