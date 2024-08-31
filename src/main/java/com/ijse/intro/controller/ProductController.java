package com.ijse.intro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.intro.dto.ProductResponseDto;
import com.ijse.intro.entity.Product;
import com.ijse.intro.services.CategoryService;
import com.ijse.intro.services.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.status(200).body(productService.getProductById(id));
    }
    
    @PostMapping("/products")
    public ResponseEntity<Product> creatProduct(@RequestBody ProductResponseDto productResponseDto){

        Product product = new Product();
        product.setName(productResponseDto.getName());
        product.setPrice(productResponseDto.getPrice());
        product.setDescription(productResponseDto.getDescription());
        product.setCategory(categoryService.getCategory(productResponseDto.getCategoryId()));
        
        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductResponseDto productResponseDto){
        Product product = new Product();
        product.setName(productResponseDto.getName());
        product.setPrice(productResponseDto.getPrice());
        product.setDescription(productResponseDto.getDescription());
        product.setCategory(categoryService.getCategory(productResponseDto.getCategoryId()));

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable long id){
        productService.deleteProductById(id);
    }
}
