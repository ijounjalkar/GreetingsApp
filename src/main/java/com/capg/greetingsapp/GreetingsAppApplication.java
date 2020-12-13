package com.capg.greetingsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingsAppApplication {

	public static void main(String[] args) {
		System.out.println("Hello from Capgemini!");
		SpringApplication.run(GreetingsAppApplication.class, args);
	}

}
