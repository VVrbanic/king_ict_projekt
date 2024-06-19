package com.example.projekt.api.controller;

import com.example.projekt.api.model.Product;
import com.example.projekt.api.model.ShortProduct;
import com.example.projekt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/products")
    //filtriranje po IDu
    public Product getProduct(@RequestParam int id){
        Optional product = productService.getProduct(id);
        if(product.isPresent()){
            return (Product) product.get();
        }
        return null;

    };

    @GetMapping("/products/name")
    //filtriranje po imenu
    public ShortProduct getProductByName(@RequestParam String name){
        Optional product = productService.getProductByName(name);
        if(product.isPresent()){
            return (ShortProduct) product.get();
        }
        return null;

    };

    @GetMapping
    public List<ShortProduct> getProducts() {
        return productService.getProducts();
    }

}
