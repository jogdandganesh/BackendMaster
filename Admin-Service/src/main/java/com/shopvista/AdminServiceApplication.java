package com.shopvista;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
		System.out.println("Admin-Service Running");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
