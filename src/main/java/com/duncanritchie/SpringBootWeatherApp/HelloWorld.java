package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping("/")
    public String index() {
        double latitude = 53.1921;
        double longitude = -2.8803;
        return "Hello world! This is going to be a weather app. Here is an interesting URL: "+ Url.getDarkSkyUrl(latitude,longitude);
    }
}
