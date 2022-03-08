package com.haibca.miniproject.models.repo;

import com.haibca.miniproject.models.entity.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    
    public Role findByName(String name);
}
