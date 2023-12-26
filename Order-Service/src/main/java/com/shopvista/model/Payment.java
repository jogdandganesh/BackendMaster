package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PaymentTable")
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private String paymentMode;
	private double totalAmmount;
	private String details;


}
