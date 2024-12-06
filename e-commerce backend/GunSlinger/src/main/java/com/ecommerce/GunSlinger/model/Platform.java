package com.ecommerce.GunSlinger.model;

public class Platform {
	
	private String platform;
	private int quantity;
	
	public Platform() {
		
	}

	public Platform(String platform, int quantity) {
		super();
		this.platform = platform;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "Platform [platform=" + platform + ", quantity=" + quantity + "]";
	}
	
}
