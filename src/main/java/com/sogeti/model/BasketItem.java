package com.sogeti.model;

//This object stores how many of each item a customer adds to their basket
public class BasketItem {

	private int orderId;
	private int productId;
	private int customerId;
	private String productName;
	private int quantity;
	private double price;
	
	public BasketItem(int orderId, String productName, int quantity, double price) {
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public BasketItem(Product product, int quantity) {
		this.productId = product.getId();
		this.productName = product.getName();
		this.quantity = quantity;
		this.price = product.getPrice();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public BasketItem() {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
