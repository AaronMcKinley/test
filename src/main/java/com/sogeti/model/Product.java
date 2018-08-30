package com.sogeti.model;

public class Product {
	private int id;
	private String name;
	private String description;
	private String category;
	private int stockLevel;
	private double price;

	
	public Product(int id, String name, String description, String category, int stockLevel, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category=category;
		this.stockLevel=stockLevel;
		this.price=price;
	}


	public Product() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(String id) {
		int idInt = Integer.parseInt(id);
		this.id = idInt;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public int getStockLevel() {
		return stockLevel;
	}


	public void setStockLevel(String stockLevel) {
		int stockL = Integer.parseInt(stockLevel);
		this.stockLevel = stockL;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(String price) {
		double cost = Double.parseDouble(price);
		this.price = cost;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
}


