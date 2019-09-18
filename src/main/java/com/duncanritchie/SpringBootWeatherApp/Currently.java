package com.duncanritchie.SpringBootWeatherApp;

public class Currently {
    private String summary;
    private double temperature;
    private double windSpeed;
    private double humidity;
    private double cloudCover;

    public double getCloudCover() {
        return cloudCover;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getSummary() {
        return summary;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
}
