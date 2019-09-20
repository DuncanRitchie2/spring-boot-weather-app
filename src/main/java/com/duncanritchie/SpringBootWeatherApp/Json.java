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
    public static String index(@RequestParam double lat, @RequestParam double lon) {
        System.out.println("Hello from /json");
        if (lat!=0 && lon!=0) {
            System.out.println(lat);
            System.out.println(lon);
            return Request.requestToJson(lat, lon).toString();
        }
        return Request.requestToJson().toString();
    }

//    @RequestMapping("/json")
//    public static String index() {
//        return Request.requestToJson().toString();
//    }
}