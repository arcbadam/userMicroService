package com.ibm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ibm.user.entity.UserDTO;
import com.ibm.user.service.JwtUserDetailsService;

@SpringBootApplication
@EnableEurekaClient
public class UserMicroServiceApplication {
	
	@Autowired
	private JwtUserDetailsService userDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(UserMicroServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			UserDTO user = new UserDTO();
			user.setUsername("admin");
			user.setPassword("admin");
			userDetailsService.save(user);
		};
	}

}
