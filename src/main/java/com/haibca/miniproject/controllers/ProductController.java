package com.haibca.miniproject.controllers;

import java.util.List;

import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.models.entity.Product;
import com.haibca.miniproject.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    // Memanggil File Product Service
    @Autowired
    private ProductService productService;

    // Menampilkan halaman dashboard sekaligus list product
    @GetMapping("/")
    public String viewProductList(Model model) {
        List<Product> listProduct = (List<Product>) productService.listAll();

        model.addAttribute("listProduct", listProduct);

        return "production/dashboard";
    }

    // Menampilkan halaman tambah product
    @GetMapping("/add_products")
    public String showFormProduct(Model model) {
        List<Category> listCategory = productService.getCategory();

        model.addAttribute("listCategory", listCategory);
        model.addAttribute("product", new Product());

        return "production/addList";
    }

    // Eksekusi method post yang diterima dari halaman tambah product sekaligus halaman edit product
    @PostMapping("/add_products")
    public String addNewProduct(Product product) {
        productService.save(product);

        return "redirect:/";
    }

    // Menampilkan halaman edit product
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.get(id);
        List<Category> listCategory = productService.getCategory();

        model.addAttribute("product", product);
        model.addAttribute("listCategory", listCategory);

        return "production/editList";
    }

    // Eksekusi method delete 
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);

        return "redirect:/";
    }

}
