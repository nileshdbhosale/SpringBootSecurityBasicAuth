package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityBasicAuthApplication.class, args);
		System.out.print("Welcome to Spring Boot Security Basic Auth App !");
	}

}
