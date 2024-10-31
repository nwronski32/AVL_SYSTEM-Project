package SYSTEM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class mapquestAPI {
    // Hardcoded MapQuest API Key
    private static final String API_KEY = "xxxxxxxxxxxxxxxxxxxxxxx"; 
    //Key Left Out Due to it being linked to my credit card
    //Costs $ for every time I use the API, still in college =)
    private static final String BASE_URL = "http://www.mapquestapi.com/directions/v2/route";

    public mapquestAPI() {
        // Constructor (if needed for instantiation)
    }

    // Method to get ETA from MapQuest API
    public static int getETA(String from, String to) {
        String key = API_KEY;  // Use your actual MapQuest API key
        String urlString = BASE_URL;
        // Make sure the addresses are properly encoded
        try {
            urlString = String.format("https://www.mapquestapi.com/directions/v2/route?key=%s&from=%s&to=%s", 
                                      key, 
                                      java.net.URLEncoder.encode(from, "UTF-8"), 
                                      java.net.URLEncoder.encode(to, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1; // Return invalid value if encoding fails
        }

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Process the response (assuming it contains the ETA as an integer)
                return parseAndReturnETAInSeconds(response.toString());
            } else {
                System.out.println("Failed to get response: " + responseCode);
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;  // Return invalid value if an exception occurs
        }
    }

    // Method to get directions from MapQuest API
    private static String getDirections(String start, String end) throws Exception {
        String urlString = String.format("%s?start=%s&end=%s", BASE_URL, start, end);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        
        // Set Authorization header with the API key
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);  // Update here: "Bearer" token if needed
        
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new Exception("Failed to get response from API: " + responseCode);
        }
    }


    // Parse the response and extract the ETA (time in seconds)
    private static int parseAndReturnETAInSeconds(String response) {
        try {
            // Find the "time" field manually in the raw response
            String timeKey = "\"time\":";
            int timeIndex = response.indexOf(timeKey);
            if (timeIndex != -1) {
                int startIndex = timeIndex + timeKey.length();
                int endIndex = response.indexOf(",", startIndex);
                String timeValue = response.substring(startIndex, endIndex).trim();
                return Integer.parseInt(timeValue);  // Return ETA in seconds
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Return -1 in case of failure
    }

	
}
