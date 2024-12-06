package com.ecommerce.GunSlinger.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.request.CreateProductRequest;

public interface ProductService {
	
	public Product createProduct(CreateProductRequest req);
	
	public String deleteProduct(Long productId) throws ProductException;
	
	public Product updateProduct(Long productId, Product req) throws ProductException;
	
	public Product findProductById(Long productId) throws ProductException;
	
	public List<Product> findProductByCategory(String category);
	
//	public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize);
	
	public List<Product> findAllProducts();

	Page<Product> getAllProduct(String category, List<String> types, List<String> sizes, List<String> platforms,
			Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber,
			Integer pageSize);
	
}
