package com.abir.users.service;

import java.util.List;


import com.abir.users.entities.Role;
import com.abir.users.entities.User;
import com.abir.users.service.register.RegistationRequest;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	public void sendEmailUser(User u, String code);
	
	User registerUser(RegistationRequest request);
	public User validateToken(String code); 


}
