package com.haibca.miniproject.models.repo;

import com.haibca.miniproject.models.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByEmail(String email);
}
