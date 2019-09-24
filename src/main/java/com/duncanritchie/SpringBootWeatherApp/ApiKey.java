package com.duncanritchie.SpringBootWeatherApp;

public class ApiKey {

    public static String getDarkSkyKey() {
        try {
            return Secrets.getDarkSkyKey();
        }
        catch (Exception e) {
            return System.getenv("APIKEY_DARKSKY");
        }
    }

    public static String getMapboxKey() {
        try {
            return Secrets.getMapboxKey();
        }
        catch (Exception e) {
            return System.getenv("APIKEY_MAPBOX");
        }
    }
}
