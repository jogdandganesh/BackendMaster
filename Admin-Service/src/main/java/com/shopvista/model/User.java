package com.shopvista.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	private int UserId;
	private Long MobileNo;
	private String Email;
	private List<Integer> orderIds;
	
	@OneToOne(cascade = CascadeType.ALL)
	private transient Address adr;


}





