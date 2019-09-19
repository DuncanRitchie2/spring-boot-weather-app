package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.JsonElement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Json {

    // This returns a Json string from localhost:8080/json

    @RequestMapping("/json")
    public static String index() {
        return Request.requestToJson().toString();
    }
}