package com.nadhem.users;

import com.nadhem.users.dto.request.UserRequestDto;
import com.nadhem.users.entities.*;
import com.nadhem.users.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.annotation.PostConstruct;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class UsersMicroserviceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, DepartmentService departmentService, RequestService requestService, CategoryService categoryService, StatusSevice statusSevice, RoleService roleService){
		return args -> {
//			statusSevice.saveStatus(new Status(1, "NEW", "#e87d9a", new ArrayList<>()));
//			statusSevice.saveStatus(new Status(2, "ACCEPTED", "#1cdc00", new ArrayList<>()));
//			statusSevice.saveStatus(new Status(3, "REFUSED", "#dc033e", new ArrayList<>()));

//			categoryService.saveCategory(new Category(1,"PAID VACATION", new ArrayList<>()));
//			categoryService.saveCategory(new Category(2,"MEDICAL LEAVE", new ArrayList<>()));
//			categoryService.saveCategory(new Category(3,"OTHER", new ArrayList<>()));
//			categoryService.saveCategory(new Category(4,"HOME OFFICE", new ArrayList<>()));

//			departmentService.addNewDepartment(new Department(3, "Department RH",new ArrayList<>()));
//			departmentService.addNewDepartment(new Department(1, "Department Marketing",new ArrayList<>()));
//			departmentService.addNewDepartment(new Department(2, "Department Technique",new ArrayList<>()));

//			roleService.saveRole(new Role(null, "RH"));
//			roleService.saveRole(new Role(null, "MANAGER"));
//			roleService.saveRole(new Role(null, "EMPLOYEE"));

//			userService.addRole(new Role(null,"ADMIN"));
//			userService.addRole(new Role(null,"USER"));
//
//			//ajouter les users
//			userService.saveUser(new UserRequestDto(
//					"firass1",
//					"1234",
//					"firas",
//					"secref",
//					"firas@po.com",
//					"bennane",
//					"bennane",
//					"tunisia",
//					"14-2-2023",
//					"RH"
//			));
//			userService.saveUser(new User(null,"admin","123",true,null));
//			userService.saveUser(new User(null,"nadhem","123",true,null));
//			userService.saveUser(new User(null,"yassine","123",true,null));
//
//			//ajouter les rôles aux users
//			userService.addRoleToUser("firass", "MANAGER");
//			userService.addRoleToUser("admin", "USER");
//
//			userService.addRoleToUser("nadhem", "USER");
//			userService.addRoleToUser("yassine", "USER");
		};
	}
//    @PostConstruct
//	void init_users() {
//		//ajouter les rôles
//		userService.addRole(new Role(null,"ADMIN"));
//		userService.addRole(new Role(null,"USER"));
//
//		//ajouter les users
//		userService.saveUser(new User(null,"admin","123",true,null));
//		userService.saveUser(new User(null,"nadhem","123",true,null));
//		userService.saveUser(new User(null,"yassine","123",true,null));
//
//		//ajouter les rôles aux users
//		userService.addRoleToUser("admin", "ADMIN");
//		userService.addRoleToUser("admin", "USER");
//
//		userService.addRoleToUser("nadhem", "USER");
//		userService.addRoleToUser("yassine", "USER");
//	}
    
    @Bean
	BCryptPasswordEncoder getBCE() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(false);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept",
				"Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origine", "Content-Type", "Accept", "Authorization", "Access-Control-Allow-Origin",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}



}
