package com.lucca.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lucca.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
}
