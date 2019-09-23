package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Json {

    // This returns a Json string from localhost:8080/json

    @RequestMapping("/json")
    public static String index(@RequestParam String location) {
        System.out.println("Hello from /json");
        if (!location.equals("")) {
            System.out.println(location);
            String json = Request.locationToDarkSkyJsonString(location);
            return json;
        }
        System.out.println("No location was given in query! Let's tell you about Chicago.");
        return Request.requestToJson("chicago").toString();
    }
}