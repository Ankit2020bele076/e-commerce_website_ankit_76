package com.ecommerce.GunSlinger.model;

public class PaymentInformation {
	private String cardHolderName;
	
	private String cardNumber;
	
	private String expirationDate;
	
	private String cvv;

	public PaymentInformation(String cardHolderName, String cardNumber, String expirationDate, String cvv) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "PaymentInformation [cardHolderName=" + cardHolderName + ", cardNumber=" + cardNumber
				+ ", expirationDate=" + expirationDate + ", cvv=" + cvv + "]";
	}
	
}
