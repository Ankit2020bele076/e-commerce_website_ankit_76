package com.ecommerce.GunSlinger.response;

public class ApiResponse {
	
	String message;
	boolean status;
	
	public ApiResponse() {
		
	}
	
	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", status=" + status + "]";
	}

}
