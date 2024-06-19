package com.example.projekt;

import com.example.projekt.api.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProjektApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjektApplication.class, args);

	}
}
