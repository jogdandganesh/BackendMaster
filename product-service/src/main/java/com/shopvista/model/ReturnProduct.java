package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class ReturnProduct {

	@Id
	private int productReturnId;
	private String returnReason;
	private int productId;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ReturnProductImages> imgs;
	private String approval;
}
