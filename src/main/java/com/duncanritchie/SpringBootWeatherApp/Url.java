package com.duncanritchie.SpringBootWeatherApp;

public class Url {

    // getDarkSkyUrl() accepts two or no params.
    // If two params are given, they are the latitude and longitude.
    public static String getDarkSkyUrl(double latitude, double longitude) {
        return "https://api.darksky.net/forecast/" + ApiKey.getApiKey() + "/" + latitude + "," + longitude;
    }

    // If no params are specified, default co-ords representing Chester are used.
    public static String getDarkSkyUrl() {
        double latitude = 53.1921;
        double longitude = -2.8803;
        return "https://api.darksky.net/forecast/" + ApiKey.getApiKey() + "/" + latitude + "," + longitude;
    }
}
