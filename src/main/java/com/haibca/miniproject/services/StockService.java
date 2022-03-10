package com.haibca.miniproject.services;

import java.util.List;

import com.haibca.miniproject.models.entity.Product;
import com.haibca.miniproject.models.entity.Stock;
import com.haibca.miniproject.models.repo.ProductRepository;
import com.haibca.miniproject.models.repo.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class StockService {
    
    @Autowired
    private StockRepository stockRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<Stock> listAll() {
        return (List<Stock>) stockRepo.findAll();
    }

    public Stock get(Long id){
        return stockRepo.findById(id).get();
    }

    public Stock save(Stock stock){
        return stockRepo.save(stock);
    }

    public List<Product> getProduct(){
        return (List<Product>) productRepo.findAll();
    }
}
