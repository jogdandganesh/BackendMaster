package com.shopvista.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Manufacturer {

	@Id
	private int manufacturerId;
	private String manufacturerName;
	private String manufacturerAddress;
	private String mailId;
	private String productManuCategory;
	
	
}
