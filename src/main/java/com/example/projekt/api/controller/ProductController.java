package com.example.projekt.api.controller;

import com.example.projekt.api.model.Product;
import com.example.projekt.api.model.ShortProduct;
import com.example.projekt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //Example: http://localhost:8080/products/id?id=1
    @GetMapping("/id")
    //filtriranje po IDu
    public Product getProduct(@RequestParam int id){
        Optional product = productService.getProduct(id);
        if(product.isPresent()){
            return (Product) product.get();
        }
        return null;

    };

    //Example: http://localhost:8080/products/name?name=Eyeshadow%20Palette%20with%20Mirror
    @GetMapping("/name")
    //filtriranje po imenu
    public Product getProductByName(@RequestParam String name){
        Optional product = productService.getProductByName(name);
        if(product.isPresent()){
            return (Product) product.get();
        }
        return null;

    };

    //Example: http://localhost:8080/products
    @GetMapping
    public List<ShortProduct> getProducts() {
        return productService.getProducts();
    }

    //http://localhost:8080/products/filter?category=beauty&price=19.99
    //http://localhost:8080/products/filter?category=beauty
    //http://localhost:8080/products/filter?category=price=19.99
    @GetMapping("/filter")
    public Optional<Product> getFilteredProducts(@RequestParam String category, @RequestParam String price) {
        return productService.getFilteredProducts(category, price);
    }


}
