package com.example.europa;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEmailTools
@EnableScheduling
public class EuropaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuropaApplication.class, args);
	}
}
