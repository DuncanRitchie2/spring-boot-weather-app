package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Json2 {

    // This returns a Json string from localhost:8080/json

    @RequestMapping("/json2")
    public static String index(@RequestParam String location) {
        System.out.println("Hello from /json2");
        if (!location.equals("")) {
            System.out.println(location);
            return Request.locationTo(location).toString();
        }
        System.out.println("No location was given in query!");
        return Request.locationTo("chicago").toString();
    }
}