package com.javatechie.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication

public class SpringSecurityBasicAuthenticationApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicAuthenticationApplication.class, args);
	}

}
