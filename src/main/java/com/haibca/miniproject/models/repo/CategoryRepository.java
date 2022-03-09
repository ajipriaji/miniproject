package com.haibca.miniproject.models.repo;

import com.haibca.miniproject.models.entity.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    
}
