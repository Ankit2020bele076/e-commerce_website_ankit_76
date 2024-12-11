package com.ecommerce.GunSlinger.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.GunSlinger.exception.ProductException;
import com.ecommerce.GunSlinger.model.Category;
import com.ecommerce.GunSlinger.model.Product;
import com.ecommerce.GunSlinger.repository.CategoryRepository;
import com.ecommerce.GunSlinger.repository.ProductRepository;
import com.ecommerce.GunSlinger.request.CreateProductRequest;
import com.ecommerce.GunSlinger.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Product createProduct(CreateProductRequest req) {
		
		Category topLevel = categoryRepo.findByName(req.getTopLevelCategory());
		if(topLevel == null) {
			Category topLevelCategory = new Category();
			topLevelCategory.setName(req.getTopLevelCategory());
			topLevelCategory.setLevel(1);
			topLevel = categoryRepo.save(topLevelCategory);
		}
		
		Category secondLevel = categoryRepo.findByNameAndParent(req.getSecondLevelCategory(), topLevel.getName());
		if(secondLevel == null) {
			Category secondLevelCategory = new Category();
			secondLevelCategory.setName(req.getSecondLevelCategory());
			secondLevelCategory.setParentCategory(topLevel);
			secondLevelCategory.setLevel(2);
			secondLevel = categoryRepo.save(secondLevelCategory);
		}
		
		Category thirdLevel = categoryRepo.findByNameAndParent(req.getThirdLevelCategory(), secondLevel.getName());
		if(thirdLevel == null) {
			Category thirdLevelCategory = new Category();
			thirdLevelCategory.setName(req.getThirdLevelCategory());
			thirdLevelCategory.setParentCategory(secondLevel);
			thirdLevelCategory.setLevel(3);
			thirdLevel = categoryRepo.save(thirdLevelCategory);
		}
		
		Product product = new Product();
		product.setTitle(req.getTitle());
		product.setType(req.getType());
		product.setDescription(req.getDescription());
		product.setDiscountedPrice(req.getDiscountedPrice());
		product.setDiscountPercent(req.getDiscountPercent());
		product.setImageUrl(req.getImageUrl());
		product.setBrand(req.getBrand());
		product.setPrice(req.getPrice());
		
		if(req.getSize() == null) {
			product.setSizes(null);
		}
		else {
			product.setSizes(req.getSize());
		}
		
		if(req.getPlatform() == null) {
			product.setPlatform(null);
		}
		else {
			product.setPlatform(req.getPlatform());
		}
		
		product.setQuantity(req.getQuantity());
		product.setCategory(thirdLevel);
		product.setCreatedAt(LocalDateTime.now());
		
		Product savedProduct = productRepo.save(product);
		
		return savedProduct;
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		Product product = findProductById(productId);
		product.getSizes().clear();
		product.getPlatform().clear();
		productRepo.delete(product);
		return "Product deleted Successfully";
	}

	@Override
	public Product updateProduct(Long productId, Product req) throws ProductException {
		Product product = findProductById(productId);
		
		if(req.getQuantity()!=0) {
			product.setQuantity(req.getQuantity());
		}
		if(req.getImageUrl() != null) {
			product.setImageUrl(req.getImageUrl());
		}
		
		return productRepo.save(product);
		
	}

	@Override
	public Product findProductById(Long productId) throws ProductException {
		Optional<Product> opt = productRepo.findById(productId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new ProductException("Product not found with id-"+productId);
		
	}

	@Override
	public List<Product> findProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> getAllProduct(String category, List<String> types, List<String> sizes, List<String> platforms, Integer minPrice,
			Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
		
		Pageable pageble = PageRequest.of(pageNumber, pageSize);
		
		List<Product> products = productRepo.filterProducts(category, minPrice, maxPrice, minDiscount, sort);
		
		if(!types.isEmpty()) {
			products=products.stream().filter(p -> types.stream().anyMatch(c -> c.equalsIgnoreCase(p.getType()))).collect(Collectors.toList());
		}
		
		if(stock!=null) {
			if(stock.equals("in_stock")) {
				products=products.stream().filter(p->p.getQuantity()>0).collect(Collectors.toList());
			}
			else if(stock.equals("out_of_stock")){
				products=products.stream().filter(p->p.getQuantity()<1).collect(Collectors.toList());
			}
		}
		
		int startIndex = (int) pageble.getOffset();
		int endIndex = Math.min(startIndex + pageble.getPageSize(),products.size());
		
		List<Product> pageContent = products.subList(startIndex, endIndex);
		
		Page<Product> filteredProducts = new PageImpl<>(pageContent,pageble, products.size());
		
		return filteredProducts;
		
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = productRepo.findAll();
		return products;
	}

	@Override
	public Page<Product> getProductByName(String category, String name, Integer pageNumber, Integer pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<Product> products = productRepo.filterProductsByNameSearch(category, name);
		if(products != null) {
			products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
		}
		int startIndex = (int) page.getOffset();
		int endIndex = Math.min(startIndex + page.getPageSize(), products.size());
		
		List<Product> pageContent = products.subList(startIndex, endIndex);
		Page<Product> filteredProducts = new PageImpl<Product>(pageContent, page, products.size());
		return filteredProducts;
	}

}
