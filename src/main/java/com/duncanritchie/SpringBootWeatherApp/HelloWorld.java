package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/weather")
    public static String index() {
        double latitude = 53.1921;
        double longitude = -2.8803;
//        return "Hello world! This is going to be a weather app. Here is an interesting URL: "+ Url.getDarkSkyUrl(latitude,longitude);
        System.out.println("Hello from HelloWorld.index()!");
        Gson gson = new Gson();
        return gson.fromJson(Request.requestToJson(latitude,longitude),String.class);
    }
}
