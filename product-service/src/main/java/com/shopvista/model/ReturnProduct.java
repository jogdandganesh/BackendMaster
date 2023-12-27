package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class ReturnProduct {

	@Id
	private int returnId;
	private String returnReason;
	private int productId;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ReturnProductImages> image;
	private String approval;
}
