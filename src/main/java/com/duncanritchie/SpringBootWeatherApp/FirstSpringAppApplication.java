package com.duncanritchie.SpringBootWeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
		try {
			HelloWorld.index();
			Request.requestToJson();
//		} catch (IOException e) {
//			e.printStackTrace();
		} finally {
		}
	}

}
