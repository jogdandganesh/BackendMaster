package com.shopvista.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopvista.communication.AdminClient;
import com.shopvista.dao.ProductRepository;
import com.shopvista.dto.ProductDTO;
import com.shopvista.model.Manufacturer;
import com.shopvista.model.Product;
import com.shopvista.model.ProductDescription;
import com.shopvista.model.ReturnProduct;
import com.shopvista.model.Review;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private AdminClient adminClient;
	@Autowired
	private ModelMapper mapper;

	@Override
	public Product getProduct(int ProductId) {
		if (productRepository.existsById(ProductId)) {
			Product product = productRepository.findById(ProductId).get();
			if (product != null && product.getVerification() == true)
				return product;
		}
		return new Product();
	}

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

	public Object saveProduct(ProductDTO productDescDto) {

		if (productDescDto != null) {
			Product product = mapper.map(productDescDto, Product.class);

			ProductDescription productDescription = mapper.map(productDescDto, ProductDescription.class);

			Manufacturer manufacturer = mapper.map(productDescDto, Manufacturer.class);

			Review review = mapper.map(productDescDto, Review.class);

			ReturnProduct returnProduct = mapper.map(productDescDto, ReturnProduct.class);

			product.setManufacturer(manufacturer);
			
			product.setProductDescription(productDescription);
			
			Product verifiedProduct = adminClient.verifyProduct(product);
			
			productRepository.save(verifiedProduct);

			System.out.println(product);

			return product;

		} else
			return "Product Fields Are Empty";
	}

	@Override
	public List<Product> getAllProduct() {

		List<Product> productList = productRepository.findAll();
		if (!productList.isEmpty())
			for (Product product : productList) {
				if (product != null && product.getVerification() == true)
					return productList;
			}
		return new ArrayList<>();

	}

	public List<Product> getProductsByCategory(String categoryName) {
		List<Product> productList = this.getAllProduct();
		List<Product> categoryList = productList.stream().filter(p -> p.getCategoryName().equals(categoryName))
				.collect(Collectors.toList());
		if (!categoryList.isEmpty()) {
			for (Product product : categoryList) {
				if (product != null && product.getVerification() == true)

					return categoryList;
			}
		}
		return new ArrayList<>();
	}

	@Override
	public List<Product> findProductBySubCategory(String subCategory) {

		List<Product> list = this.getAllProduct();
		List<Product> subCategoryList = list.stream().filter(p -> p.getSubCategory().equals(subCategory))
				.collect(Collectors.toList());
		if (!subCategoryList.isEmpty()) {
			for (Product product : subCategoryList) {
				if (product != null && product.getVerification() == true)
					;
				return subCategoryList;
			}
		}
		return new ArrayList<>();
	}

	@Override
	public List<Product> getProductByName(String name) {
		if (productRepository.existsByProductName(name)) {
			List<Product> productList = productRepository.findByProductName(name);
			if (!productList.isEmpty()) {
				for (Product product : productList) {
					if (product != null && product.getVerification() == true)
						;
					return productList;
				}
			}
		}
		return new ArrayList<>();
	}

	@Override
	public Product verifyProduct(Product product) {
		Product verifiedProduct = mapper.map(product, Product.class);
		productRepository.save(verifiedProduct);
		return verifiedProduct;
	}

	@Override
	public List<Product> getProductByCharStartsWith(String ch) {
		List<Product> productList = productRepository.findByProductNameLike(ch + "%");
		if (!productList.isEmpty())
			for (Product product : productList) {
				if (product != null && product.getVerification() == true)
					return productList;
			}
		return productList;
	}

	@Override
	public List<Product> getProductByCategoryNameStartsWith(String category) {
		List<Product> productList = productRepository.findByCategoryNameLike(category + "%");
		if (!productList.isEmpty())
			for (Product product : productList) {
				if (product != null && product.getVerification() == true)
					return productList;
			}
		return new ArrayList<>();
	}

	@Override
	public List<Product> getProductBySubCategory(String subcategory) {
		List<Product> productList = productRepository.findBySubCategoryLike(subcategory + "%");
		if (!productList.isEmpty())
			for (Product product : productList) {
				if (product != null && product.getVerification() == true)
					return productList;
			}
		return new ArrayList<>();
	}

}
