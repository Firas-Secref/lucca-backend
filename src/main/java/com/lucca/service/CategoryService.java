package com.lucca.service;

import com.lucca.entities.Category;
import com.lucca.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;;

    public Category getCategoryById(int categoryId){
        return this.categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("no category match with this id !"));
    }

    public Category saveCategory(Category category){
        return this.categoryRepository.save(category);
    }
}
