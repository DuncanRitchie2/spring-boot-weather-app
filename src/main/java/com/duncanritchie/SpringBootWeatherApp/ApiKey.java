package com.duncanritchie.SpringBootWeatherApp;

public class ApiKey {

    public static String getDarkSkyKey() {
        try {
            return System.getenv("APIKEY_DARKSKY");
        }
        catch (Exception e) {
            return Secrets.getDarkSkyKey();
        }
    }

    public static String getMapboxKey() {
        try {
            return System.getenv("APIKEY_MAPBOX");
        }
        catch (Exception e) {
            return Secrets.getMapboxKey();
        }
    }
}
