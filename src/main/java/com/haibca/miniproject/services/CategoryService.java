package com.haibca.miniproject.services;

import java.util.List;

import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.models.repo.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> listAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public Category getId(Long id){
        return categoryRepo.findById(id).get();
    }

    public void deleteCategory(Long id){
        categoryRepo.deleteById(id);
    }
    
}
