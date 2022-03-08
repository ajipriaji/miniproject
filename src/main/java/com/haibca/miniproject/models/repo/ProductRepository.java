package com.haibca.miniproject.models.repo;

import com.haibca.miniproject.models.entity.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
