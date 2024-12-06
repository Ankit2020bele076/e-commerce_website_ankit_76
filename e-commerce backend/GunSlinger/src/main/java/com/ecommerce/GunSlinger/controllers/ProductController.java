package com.ecommerce.GunSlinger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,
			        @RequestParam List<String>type, @RequestParam List<String> size, @RequestParam List<String> platform, @RequestParam Integer minPrice,
			        @RequestParam Integer maxPrice, @RequestParam Integer minDiscount, @RequestParam String sort,
			        @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
		
		Page<Product> res = productService.getAllProduct(category, type, size, platform, minPrice, maxPrice, minDiscount, sort, stock, pageNumber, pageSize);
		
		return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/products/id/{productId}")
	public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException{
		
		Product product = productService.findProductById(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
		
	}
	
}
