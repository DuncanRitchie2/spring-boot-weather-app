package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Request {

    public static JsonElement requestToJson(double latitude, double longitude) {
        System.out.println("Hello from requestToJson(lat, lon)");
        System.out.println(latitude);
        System.out.println(longitude);

        JsonParser parser = new JsonParser();
        String json = latLongToRequestString(latitude, longitude);
        JsonElement jsonTree = parser.parse(json);

        return jsonTree;
    }

    public static JsonElement requestToJson(String location) {
        System.out.println("Hello from requestToJson(location)");
        System.out.println(location);

        JsonParser parser = new JsonParser();
        String json = locationTo(location);
        JsonElement jsonTree = parser.parse(json);

        return jsonTree;
    }

    public static JsonElement requestToJson() {
        System.out.println("Hello from requestToJson( no params )");

        JsonParser parser = new JsonParser();
        String json = latLongToRequestString();
        JsonElement jsonTree = parser.parse(json);

        return jsonTree;
    }

    // latLongToRequestString() uses the Dark Sky API to return weather data as a String.
    // If latLongToRequestString() has two params, they are latitude and longitude.
    public static String latLongToRequestString(double latitude, double longitude) {
        System.out.println("Hello from requestToString(lat, lon)");
        System.out.println(latitude);
        System.out.println(longitude);

        return requestUrlToString(Url.getDarkSkyUrl(latitude, longitude));
    }

    // If latLongToRequestString() is called without parameters, default co-ords for Chester are used.
    public static String latLongToRequestString() {
        System.out.println("Hello from requestToString( no params )");
        double latitude = 53.1921;
        double longitude = -2.8803;
        return latLongToRequestString(latitude, longitude);
    }

    public static String requestUrlToString(String urlString) {
        System.out.println("Hello from requestToString(url)");
        System.out.println(urlString);

        try {
            URL url = new URL(urlString);
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

    public static String locationTo(String location) {
        System.out.println("Hello from location()");

        String hello = requestUrlToString(Url.getMapboxUrl(location));


        return hello;
    }
}
