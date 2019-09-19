package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Json {

    // This returns a Json string from localhost:8080/json

    @RequestMapping("/json")
    public static String index() {
        return Request.requestToJson();
    }
}