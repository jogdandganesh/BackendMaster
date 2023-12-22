package com.shopvista.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adminTable")
public class Admin {
	
	@Id
	private int adminId;
	private String adminEmail;
	private String password;
	
	
	private transient List<User> user;
	private transient List<Product> product;
    private transient List<Manufacturer> manufacturer;

}
