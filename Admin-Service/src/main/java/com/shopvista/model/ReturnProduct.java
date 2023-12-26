package com.shopvista.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnProduct {
	
	private int returnId;
	private String returnReason;
	private int productId;
	private List<ReturnProduct> images;
	private String approval;
	
	
	
	 
	


}
