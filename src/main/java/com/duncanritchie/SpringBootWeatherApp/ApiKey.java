package com.duncanritchie.SpringBootWeatherApp;

public class ApiKey {

    public static String getDarkSkyKey() {
        try {
            if (System.getenv("APIKEY_DARKSKY") == null) {
                throw new NullPointerException();
            }
            return System.getenv("APIKEY_DARKSKY");
        }
        catch (Exception e) {
            return Secrets.getDarkSkyKey();
        }
    }

    public static String getMapboxKey() {
        try {
            if (System.getenv("APIKEY_MAPBOX") == null) {
                throw new NullPointerException();
            }
            return System.getenv("APIKEY_MAPBOX");
        }
        catch (Exception e) {
            return Secrets.getMapboxKey();
        }
    }
}
