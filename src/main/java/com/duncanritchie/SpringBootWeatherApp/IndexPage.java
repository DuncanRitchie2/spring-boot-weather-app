package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPage {

    @RequestMapping("/")
    public String welcome() {
        return "index.html";
    }
}