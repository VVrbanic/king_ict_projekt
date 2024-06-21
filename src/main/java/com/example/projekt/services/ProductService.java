package com.example.projekt.services;

import com.example.projekt.api.model.Product;
import com.example.projekt.api.model.ShortProduct;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> productList;


    public ProductService(){
        String url_products = "https://dummyjson.com/products";
        WebClient.Builder builder_categories = WebClient.builder();

        String product_string = builder_categories.build()
                .get()
                .uri(url_products)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode productsNode = null;
            JsonNode rootNode = objectMapper.readTree(product_string);
            productsNode = rootNode.path("products");

            productList = objectMapper.readValue(
                    productsNode.toString(),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ShortProduct> getProducts() {
        List<ShortProduct> productListAll = new ArrayList<>();
        for (Product product : productList) {
            productListAll.add(new ShortProduct(product.getTitle(), product.getPrice(), product.getDescription(), product.getImages()));
        }
        return productListAll;
    }

    public Optional<Product> getProduct(int id) {
        Optional optional = Optional.empty();
        for (Product product : productList) {
            if (id == product.getId()) {
                optional = Optional.of(product);
                return optional;
            }
        }
        return optional;
    }

    public Optional<Product> getProductByName(String title) {
        Optional optional = Optional.empty();
        for (Product product : productList) {
            if (title.equalsIgnoreCase(product.getTitle())) {
                optional = Optional.of(product);
                return optional;
            }
        }
        return optional;
    }


    //Example: http://localhost:8080/products/filter?category=beauty&price=19.99
    public Optional<Product> getFilteredProducts(String category, String price) {
        System.out.println(category);
        System.out.println(price);
        Optional optional = Optional.empty();
        for (Product product : productList) {
            if (category.equalsIgnoreCase(product.getCategory()) && price.equals(product.getPrice().toString())) {
                optional = Optional.of(product);
                return optional;
            }
        }
        return optional;
    }



}
