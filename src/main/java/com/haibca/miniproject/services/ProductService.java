package com.haibca.miniproject.services;

import java.util.List;

import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.models.entity.Product;
import com.haibca.miniproject.models.repo.CategoryRepository;
import com.haibca.miniproject.models.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Product> listAll() {
        return (List<Product>) productRepo.findAll();
    }

    public Product get(Long id) {
        return productRepo.findById(id).get();
    }
    
    public Product save(Product product){
        return productRepo.save(product);
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
    
    public List<Category> getCategory() {
        return (List<Category>) categoryRepo.findAll();
    }
    
    public void saveProductWithDefaultStok(Product product){

        // product.setStock(0);
        productRepo.save(product);
    }
}
