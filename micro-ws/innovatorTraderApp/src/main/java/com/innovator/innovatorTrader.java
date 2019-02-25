package com.innovator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class innovatorTrader {

	public static void main(String[] args) {
		SpringApplication.run(innovatorTrader.class, args);

	}

}
