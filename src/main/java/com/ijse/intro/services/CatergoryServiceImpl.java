package com.ijse.intro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Category;
import com.ijse.intro.repository.CategoryRepository;


@Service
public class CatergoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {

       Category category =  categoryRepository.findById(id).orElse(null);
       if(category != null){
        return category;
       }
       else{
        return null;
       }

    }

    @Override
    public Category createCategory(Category category) {
        
         return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(long id) {
       categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(long id,Category category) {
       Category exisistingCategory = categoryRepository.findById(id).orElse(null);

       if(exisistingCategory != null){
          exisistingCategory.setName(category.getName());
       }

       return categoryRepository.save(exisistingCategory);
        
    }


    
}
