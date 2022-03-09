package com.haibca.miniproject.controllers;

import java.util.List;

import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.models.entity.Product;
import com.haibca.miniproject.models.repo.CategoryRepository;
import com.haibca.miniproject.models.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

   @Autowired
   private CategoryRepository categoryRepository;

   @Autowired
   private ProductRepository productRepo;

   @GetMapping("/products")
   public String viewProductList(Model model) {
       List<Product> listProduct = (List<Product>) productRepo.findAll();

       model.addAttribute("listProduct", listProduct);

       return "products";
   }

   @GetMapping("/add_products")
   public String showFormProduct(Model model) {
       List<Category> listCategory = (List<Category>) categoryRepository.findAll();

       model.addAttribute("listCategory", listCategory);
       model.addAttribute("product", new Product());

       return "add_product_form";
   }

   @PostMapping("/add_products")
   public String addNewProduct(Product product) {
       productRepo.save(product);

       return "redirect:/products";
   }

   @GetMapping("/products/edit/{id}")
   public String editProduct(@PathVariable("id") Long id, Model model) {
       Product product = productRepo.findById(id).get();
       List<Category> listCategory = (List<Category>) categoryRepository.findAll();

       model.addAttribute("product", product);
       model.addAttribute("listCategory", listCategory);

       return "edit_product_form";
   }
    
}
