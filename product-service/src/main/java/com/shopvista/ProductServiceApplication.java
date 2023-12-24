package com.shopvista;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.shopvista.dao.ProductRepository;


//@EnableJpaRepositories
@SpringBootApplication
@EntityScan("com.shopvista.model")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		System.out.println("Product-Service run successfully.........");
		}
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper(); 
	}

}
