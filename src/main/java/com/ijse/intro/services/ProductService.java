package com.ijse.intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Product;

@Service
public interface ProductService {
    
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product updateProduct(long id, Product product);
    void deleteProductById(long id);
}
