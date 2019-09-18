package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FirstSpringAppApplication {

	public static void main(String[] args) {
        System.out.println("Running FirstSpringApplication.java!");
		SpringApplication.run(FirstSpringAppApplication.class, args);
		try {
            System.out.println("Trying HelloWorld.index()!");
			HelloWorld.index();
            System.out.println("Requesting Json!");
			Request.requestToJson();
//		} catch (IOException e) {
//			e.printStackTrace();
		} finally {
		}
	}

}
