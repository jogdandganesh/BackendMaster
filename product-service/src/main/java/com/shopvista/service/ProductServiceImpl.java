package com.shopvista.service;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shopvista.dao.ProductRepository;
import com.shopvista.dto.ProductDTO;

import com.shopvista.model.Manufacturer;
import com.shopvista.model.Product;
import com.shopvista.model.ProductDescription;
import com.shopvista.model.ProductImages;
import com.shopvista.model.ReturnProduct;
import com.shopvista.model.Review;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Product getProduct(int ProductId) {
		if (productRepository.existsById(ProductId)) {
			return productRepository.findById(ProductId).get();
		} else {
			return null;
		}
	}
	
	//....................................................................................................

	@Override
	public Product deleteProduct(int ProductId) {
		if (productRepository.existsById(ProductId)) {
			Product product = productRepository.findById(ProductId).get();
			productRepository.deleteById(ProductId);
			return product;
		} else {
			return new Product();
		}

	}

	// ...........................................................................................................

	// ProductDescription......//

	public Object saveProduct(ProductDTO productDescDto) {

		if (productDescDto != null) {
			Product product = mapper.map(productDescDto, Product.class);

			ProductDescription productDescription = mapper.map(productDescDto, ProductDescription.class);

			Manufacturer manufacturer = mapper.map(productDescDto, Manufacturer.class);

			Review review = mapper.map(productDescDto, Review.class);

			ReturnProduct returnProduct = mapper.map(productDescDto, ReturnProduct.class);

			product.setManufacturer(manufacturer);
			product.setProductDescription(productDescription);

			productRepository.save(product);

			System.out.println(product);

			return product;

		} else
			return "Product Fields Are Empty";
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> list = productRepository.findAll();
		System.out.println(list);
		
		return list;

	}

	public List<Product> getProductsByCategory(String categoryName) {
		List<Product> productList = this.getAllProduct();
		List<Product> categoryList = productList.stream().filter(p->p.getCategoryName().equals(categoryName)).collect(Collectors.toList());
        return categoryList;
	}

	@Override
	public List<Product> findProductBySubCategory(String subCategory) {
		
		List<Product> list = this.getAllProduct();
		List<Product> subCategoryList = list.stream().filter(p->p.getSubCategory().equals(subCategory)).collect(Collectors.toList());
		System.out.println(subCategoryList);	
		return subCategoryList;
	}

	@Override
	public List<Product> getProductByName(String name) {
		if (productRepository.existsByProductName(name)) {
			return productRepository.findByProductName(name);
		} else
			return new ArrayList<>();
	}

	@Override
	public String verifyProduct(int productId) {
		if(productRepository.existsById(productId)) {
			Optional<Product> product = productRepository.findById(productId);
			product.get().setVerification(true);
			return "Product Verified Succesfully";
		}
		else
			return "Product is Not verified";
		
	}

}
