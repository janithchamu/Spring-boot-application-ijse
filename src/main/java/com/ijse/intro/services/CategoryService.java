package com.ijse.intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Category;

@Service
public interface CategoryService {
    
    List<Category> getAllCategories();

    Category getCategory(Long id);

    Category createCategory(Category category);

    void deleteCategoryById(long id);

    Category updateCategory(long id ,Category category);
}
