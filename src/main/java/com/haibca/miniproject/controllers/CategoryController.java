package com.haibca.miniproject.controllers;

import java.util.List;

import com.haibca.miniproject.models.entity.Category;
import com.haibca.miniproject.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/categories")
    public String viewCategoryList(Model model) {
        List<Category> listCategory = categoryService.listAll();
        model.addAttribute("listCategory", listCategory);
        return "categories";
    }

    @GetMapping("/add_categories")
    public String showFormCategory(Model model){
        model.addAttribute("category", new Category());

        return "add_category_form";
    }

    @PostMapping("/add_categories")
    public String addNewCategory(Category category) {
        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model){
        Category category = categoryService.getId(id);

        model.addAttribute("category", category);

        return "edit_category_form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category) {
        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);

        return "redirect:/categories";
    }


}
