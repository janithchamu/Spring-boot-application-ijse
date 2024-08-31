package com.ijse.intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Product;
import com.ijse.intro.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
     return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
     return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(long id, Product product){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct != null){

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());

        }

        return productRepository.save(existingProduct);

    }

    @Override
    public void deleteProductById(long id) {
       productRepository.deleteById(id);
    }
    
}
