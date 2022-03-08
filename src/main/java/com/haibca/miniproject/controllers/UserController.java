package com.haibca.miniproject.controllers;

import java.util.List;

import com.haibca.miniproject.models.entity.Role;
import com.haibca.miniproject.models.entity.User;
import com.haibca.miniproject.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String viewUsersList(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/add_users")
    public String showFormAddUser(Model model){
        model.addAttribute("user", new User());
        return "add_user_form";
    }

    @PostMapping("/add_users")
    public String addUser(User user) {
        userService.saveUserWithDefaultRole(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.get(id);
        List<Role> listRoles = userService.getRoles();

        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);

        return "edit_user_form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);

        return "redirect:/users";
    }
}
