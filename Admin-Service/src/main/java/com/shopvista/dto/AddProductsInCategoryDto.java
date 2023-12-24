package com.shopvista.dto;

import java.util.List;

import com.shopvista.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductsInCategoryDto {
	
	private String categoryName;
	private List<Product> productList;

}
