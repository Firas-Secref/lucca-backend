package com.lucca.service;

import com.lucca.entities.User;
import com.lucca.dto.request.UserRequestDto;
import com.lucca.entities.Role;

public interface UserService {
	User saveUser(UserRequestDto user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}
