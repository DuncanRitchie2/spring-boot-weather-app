package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/")
    public static String index() {
        double latitude = 53.1921;
        double longitude = -2.8803;
//        return "Hello world! This is going to be a weather app. Here is an interesting URL: "+ Url.getDarkSkyUrl(latitude,longitude);
        System.out.println("Hello from HelloWorld.index()!");

        JsonElement jsonTree = Request.requestToJson(latitude, longitude);

        if (jsonTree.isJsonObject()) {
            System.out.println("jsonTree is a Json object!");
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            JsonElement currently = jsonObject.get("currently");
            System.out.println(currently);
            if (currently.isJsonObject()) {
                System.out.println("currently is a Json object!");
                String outputMessage = "<h1>Duncan&rsquo;s weather page</h1><p>Greetings from Chester!</p>";
                String[] keys = {"temperature","summary","windSpeed","windBearing","precipProbability","precipIntensity"};
                String[] english = {"temperature","summary","wind speed","wind bearing","probability of precipitation","intensity of precipitation"};
                String[] units = {" degrees Celsius",""," miles per hour"," degrees from north","%",""};

                JsonObject currentlyObj =  currently.getAsJsonObject();
                for (int i = 0; i < keys.length; i++) {
                    outputMessage += "\n<p>The "+english[i]+" is <strong>"+currentlyObj.get(keys[i])+"</strong>"+units[i]+".</p>";
                }
                System.out.println(outputMessage);

                String footer = "<footer style='position: absolute; bottom: 0; width: 100%;'>" +
                        "<p>Made by Duncan Ritchie using Java Spring and the Dark Sky API. <a href='https://www.duncanritchie.co.uk' title='My website'>See my website.</a> <a href='https://github.com/DuncanRitchie2/spring-boot-weather-app' title='My code on GitHub'>See the code.</a></p>" +
                        "</footer>";

                String htmlOutput = "<html><head><title>Duncan&rsquo;s weather page</title><link href='https://fonts.googleapis.com/css?family=Alegreya&display=swap' rel='stylesheet'></head><body style='text-align: center; font-family: \"Alegreya\", serif;'>" +
                        outputMessage +
                        footer +
                        "</body></html>" ;

                return htmlOutput;
            }
            return currently.toString();
        }

        return jsonTree.toString();

//        Gson gson = new Gson();
//
//        Currently currently = gson.fromJson(Request.requestToJson(latitude,longitude),Currently.class);
//
//        try {
//            String tempString = "The current temperature is "+currently.getTemperature();
//            return tempString;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            String allData = gson.fromJson(Request.requestToJson(latitude,longitude),String.class);
//            return allData;
//        }
    }
}
