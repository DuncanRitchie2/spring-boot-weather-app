package com.duncanritchie.SpringBootWeatherApp;

public class Secrets {

    private static final String APIKEY_DARKSKY = "";
    private static final String APIKEY_MAPBOX = "";

    public static String getDarkSkyKey() {
        return APIKEY_DARKSKY;
    }

    public static String getMapboxKey() {
        return APIKEY_MAPBOX;
    }
}
