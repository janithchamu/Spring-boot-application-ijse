package com.ijse.intro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.intro.dto.CategoryReqDto;
import com.ijse.intro.entity.Category;
import com.ijse.intro.services.CategoryService;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/Categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable long id){
        return ResponseEntity.status(200).body(categoryService.getCategory(id));
    }

    @PostMapping("/Categories")
    public ResponseEntity<Category> creaCategory(@RequestBody Category category){
        return ResponseEntity.status(201).body(categoryService.createCategory(category));
    }

    @GetMapping("/Categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @DeleteMapping("/Categories/{id}")
    public void deleteCategoryById(@PathVariable long id){
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/Categories/{id}")
    public Category updaCategory(@PathVariable long id, @RequestBody CategoryReqDto dto){
        Category newCategory = new Category();
        newCategory.setName(dto.getName());
        newCategory.setProducts(categoryService.getCategory(id).getProducts());


        return categoryService.updateCategory(id, newCategory);
    }
    
    
}
