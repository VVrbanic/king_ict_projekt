package com.example.projekt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjektApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProjektApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);
		logger.info("ProjektApplication started successfully.");
	}


}
