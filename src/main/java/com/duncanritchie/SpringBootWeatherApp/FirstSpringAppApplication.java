package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.JsonElement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FirstSpringAppApplication {

	public static void main(String[] args) {
        System.out.println("Running FirstSpringApplication.java!");
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

}
