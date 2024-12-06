package com.ecommerce.GunSlinger.request;

public class AddItemRequest {
	
	private Long productId;
	
	private String size;
	
	private String platform;
	
	private int quantity;
	
	private Integer price;
	
	public AddItemRequest() {
		
	}

	public AddItemRequest(Long productId,String platform, String size, int quantity, Integer price) {
		super();
		this.productId = productId;
		this.size = size;
		this.platform = platform;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "AddItemRequest [productId=" + productId + ", size=" + size + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}
