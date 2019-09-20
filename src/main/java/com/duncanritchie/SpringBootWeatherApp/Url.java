package com.duncanritchie.SpringBootWeatherApp;

public class Url {

    // getDarkSkyUrl() accepts two or no params.
    // If two params are given, they are the latitude and longitude.
    public static String getDarkSkyUrl(double latitude, double longitude) {
        return "https://api.darksky.net/forecast/" + ApiKey.getDarkSkyKey() + "/" + latitude + "," + longitude + "?units=uk2";
    }

    // If no params are given, default co-ords representing Chester are used.
    public static String getDarkSkyUrl() {
        double latitude = 53.1921;
        double longitude = -2.8803;
        return getDarkSkyUrl(latitude, longitude);
    }

    // getMapboxUrl accepts one param or none.
    // If one param is given, it is a String representing the location in English.
    public static String getMapboxUrl(String location) {
        return "https://api.mapbox.com/geocoding/v5/mapbox.places/" + location + ".json?access_token=" +ApiKey.getMapboxKey();
    }

    // If no params are given, a default String is used.
    public static String getMapboxUrl() {
        String location = "chester";
        return "https://api.mapbox.com/geocoding/v5/mapbox.places/" + location + ".json?access_token=" + ApiKey.getMapboxKey();
    }
}
