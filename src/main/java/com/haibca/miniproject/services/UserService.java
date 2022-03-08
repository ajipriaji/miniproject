package com.haibca.miniproject.services;

import java.util.List;

import com.haibca.miniproject.models.entity.Role;
import com.haibca.miniproject.models.entity.User;
import com.haibca.miniproject.models.repo.RoleRepository;
import com.haibca.miniproject.models.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

        userRepo.save(user);
    }

    public void save(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Role> getRoles() {
        return (List<Role>) roleRepo.findAll();
    }
    
}
