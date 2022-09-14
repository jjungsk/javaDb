package com.ssafy.jdbctest;

// Data Transfer Object
public class ProductDto {

	private String productId;
	private String productName;
	private int price;
	private String color;
	private String registerDate;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", registerDate=" + registerDate + "]";
	}
	
	
	
}
