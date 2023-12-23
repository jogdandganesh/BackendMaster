package com.shopvista;

//import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		System.out.println("Order-Service Running");

	}

//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
}
