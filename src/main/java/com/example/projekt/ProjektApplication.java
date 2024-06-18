package com.example.projekt;

import com.example.projekt.entities.Category;
import com.example.projekt.entities.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootApplication
public class ProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);

		String url_categories = "https://dummyjson.com/products/categories";
		String url_products = "https://dummyjson.com/products";
		WebClient.Builder builder_categories = WebClient.builder();

		//Implementirajte endpoint koji vraća listu proizvoda (slika, naziv, cijena, skraćen opis do 100z nakova)
		String product_string = builder_categories.build()
				.get()
				.uri(url_products)
				.retrieve()
				.bodyToMono(String.class)
				.block();  // Consider using a non-blocking approach in a real application

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			//JSON response is an object that has a list of products
			JsonNode rootNode = objectMapper.readTree(product_string);
			JsonNode productsNode = rootNode.path("products");

			List<Product> productList = objectMapper.readValue(
					productsNode.toString(),
					objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class)
			);

			for (Product product : productList) {

				System.out.println(product.printImportant());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Implementirajte endpoint koji vraća detalje jednog proizvoda
       //Implementirajte endpoint koji omogućava filtriranje po kategoriji i cijeni
		List<Category> categories = builder_categories.build()
				.get()
				.uri(url_categories)
				.retrieve()
				.bodyToFlux(Category.class)
				.collectList()
				.block();
       //Implementirajte endpoint koji za uneseni tekst pretražuje proizvode po nazivu


	}

}
