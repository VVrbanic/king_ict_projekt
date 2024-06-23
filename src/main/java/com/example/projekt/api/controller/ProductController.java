package com.example.projekt.api.controller;

import com.example.projekt.api.model.Product;
import com.example.projekt.api.model.ShortProduct;
import com.example.projekt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
        logger.debug("ProductController initialized with ProductService.");
    }

    // Example: http://localhost:8080/products/id?id=1
    @GetMapping("/id")
    // Filter by ID
    public Product getProduct(@RequestParam int id){
        logger.info("Received request to get product by ID: {}", id);
        Optional<Product> product = productService.getProduct(id);
        if (product.isPresent()) {
            logger.debug("Product found: {}", product.get());
            return product.get();
        } else {
            logger.warn("Product with ID {} not found", id);
            return null;
        }
    }

    // Example: http://localhost:8080/products/name?name=Eyeshadow%20Palette%20with%20Mirror
    @GetMapping("/name")
    // Filter by name
    public Product getProductByName(@RequestParam String name){
        logger.info("Received request to get product by name: {}", name);
        Optional<Product> product = productService.getProductByName(name);
        if (product.isPresent()) {
            logger.debug("Product found: {}", product.get());
            return product.get();
        } else {
            logger.warn("Product with name '{}' not found", name);
            return null;
        }
    }

    // Example: http://localhost:8080/products
    @GetMapping
    public List<ShortProduct> getProducts() {
        logger.info("Received request to get all products");
        List<ShortProduct> products = productService.getProducts();
        logger.debug("Number of products retrieved: {}", products.size());
        return products;
    }

    // Example: http://localhost:8080/products/filter?category=beauty&price=19.99
    // Example: http://localhost:8080/products/filter?price=19.99
    // Example: http://localhost:8080/products/filter?category=beauty
    @GetMapping("/filter")
    public Optional<Product> getFilteredProducts(@RequestParam(required = false) String category,
                                                 @RequestParam(required = false) Float price) {
        logger.info("Received request to filter products by category: '{}' and price: {}", category, price);
        Optional<Product> product = productService.getFilteredProducts(category, price);
        if (product.isPresent()) {
            logger.debug("Filtered product found: {}", product.get());
            return product;
        } else {
            logger.warn("No products found with category '{}' and price {}", category, price);
            return Optional.empty();
        }
    }
}
