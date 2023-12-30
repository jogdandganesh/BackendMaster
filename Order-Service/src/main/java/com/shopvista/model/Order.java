package com.shopvista.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="OrderTable")
public class Order {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private int userId;
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> productList ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	

}
