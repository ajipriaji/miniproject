package com.haibca.miniproject.models.repo;

import com.haibca.miniproject.models.entity.Stock;

import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
    
}
