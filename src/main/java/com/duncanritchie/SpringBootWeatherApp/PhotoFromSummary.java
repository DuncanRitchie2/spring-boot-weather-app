package com.duncanritchie.SpringBootWeatherApp;

public class PhotoFromSummary {
    public static String getUrl(String summary) {
        switch (summary) {
            case "Drizzle":
                return "https://live.staticflickr.com/4565/27004180969_a0a9e40af7_b.jpg";
            case "Rain":
                return "https://live.staticflickr.com/2575/5704096027_2effd3f008_b.jpg";
            case "Mostly Cloudy":
                return "https://live.staticflickr.com/3366/3508877775_a113a4498f_b.jpg";
            case "Partly Cloudy":
                return "https://live.staticflickr.com/1496/25468555771_98e1ab1042_b.jpg";
            case "Cloudy":
                return "https://live.staticflickr.com/3366/3508877775_a113a4498f_b.jpg";
            case "Clear":
                return "https://live.staticflickr.com/4702/38650217890_0b6e81a527_b.jpg";
        }


        // Default is rain.
        return "https://live.staticflickr.com/2575/5704096027_2effd3f008_b.jpg";
    }
}
