package com.abir.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.abir.users.service.UserService;

@SpringBootApplication
@EnableEurekaClient
public class UsersMicroserviceApplication {
	
	@Autowired
	UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	
	/*@PostConstruct
	void init_users() {
		//ajouter les rôles
		userService.addRole(new Role(null,"ADMIN"));
		userService.addRole(new Role(null,"USER"));
		
		//ajouter les users
		userService.saveUser(new User(null,"admin","123",true,null));
		userService.saveUser(new User(null,"abir","123",true,null));
		userService.saveUser(new User(null,"oussema","123",true,null));
		
		//ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("admin", "USER");
		
		userService.addRoleToUser("abir", "USER");
		userService.addRoleToUser("oussema", "USER");		
	} 
	
	*/
	



}
