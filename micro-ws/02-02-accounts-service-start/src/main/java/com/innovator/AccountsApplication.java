package com.innovator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
//TODO -1 Write an annotation to Enable Discovery Client

public class AccountsApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}
}
