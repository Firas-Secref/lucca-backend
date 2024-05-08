package com.nadhem.users.service;

import com.nadhem.users.entities.Role;
import com.nadhem.users.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role){
        return this.roleRepository.save(role);
    }

}
