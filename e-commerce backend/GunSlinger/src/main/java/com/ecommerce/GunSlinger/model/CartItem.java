package com.ecommerce.GunSlinger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	private Product product;
	
	private String size;
	
	private String platform;
	
	private int quantity;
	
	private Integer price;
	
	private Integer discountedPrice;
	
	private Long userId;
	
	public CartItem() {
		
	}

	public CartItem(Long id, Cart cart, Product product, String size, String platform, int quantity, Integer price,
			Integer discountedPrice, Long userId) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.size = size;
		this.platform = platform;
		this.quantity = quantity;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product + ", size=" + size + ", quantity="
				+ quantity + ", price=" + price + ", discountedPrice=" + discountedPrice + ", userId=" + userId + "]";
	}
	
}
