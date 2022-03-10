package com.haibca.miniproject.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.models.entity.Product;
import com.haibca.miniproject.models.repo.CategoryRepository;
import com.haibca.miniproject.models.repo.ProductRepository;
import com.haibca.miniproject.services.ProductService;

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

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String viewProductList(Model model) {
        List<Product> listProduct = (List<Product>) productRepo.findAll();

        model.addAttribute("listProduct", listProduct);

        return "production/dashboard";
    }

    @GetMapping("/add_products")
    public String showFormProduct(Model model) {
        List<Category> listCategory = (List<Category>) categoryRepository.findAll();

        model.addAttribute("listCategory", listCategory);
        model.addAttribute("product", new Product());

        return "production/addList";
    }

    @PostMapping("/add_products")
    public String addNewProduct(Product product) {
       productService.saveProductWithDefaultStok(product);

        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productRepo.findById(id).get();
        List<Category> listCategory = (List<Category>) categoryRepository.findAll();

        model.addAttribute("product", product);
        model.addAttribute("listCategory", listCategory);

        return "production/editList";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepo.deleteById(id);

        return "redirect:/";
    }

}
