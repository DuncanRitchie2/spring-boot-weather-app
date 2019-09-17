package com.duncanritchie.SpringBootWeatherApp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Request {

    // requestToString() uses the Dark Sky API to return weather data as a String.
    // If requestToString() has two params, they are latitude and longitude.
    public String requestToString(double latitude, double longitude) {
        try {
            URL url = new URL(Url.getDarkSkyUrl(latitude, longitude));
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HTTP response code: "+responseCode);
            }
            else {
                Scanner sc = new Scanner(url.openStream());
                String inline = "";
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("The string created is "+inline);
                sc.close();
                return inline;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Malformed URL!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Internal server error!";
        }
    }

    // If requestToString() is called without parameters, default co-ords for Chester are used.
    public String requestToString() {
        double latitude = 53.1921;
        double longitude = -2.8803;
        return requestToString(latitude, longitude);
    }
}
