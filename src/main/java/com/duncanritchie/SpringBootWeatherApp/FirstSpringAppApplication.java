package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringAppApplication {

	public static void main(String[] args) {
        System.out.println("Running FirstSpringApplication.java!");
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

}
