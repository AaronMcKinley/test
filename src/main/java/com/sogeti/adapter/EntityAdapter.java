package com.sogeti.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sogeti.model.BasketItem;
import com.sogeti.model.Product;
import com.sogeti.repository.ProductHolder;

public class EntityAdapter {
	
	private EntityAdapter() {
		
	}
	
	public static Product parseProduct(ResultSet result) throws SQLException {
		
		Product product = new Product();
		
		product.setName(result.getString("productName"));
		product.setDescription(result.getString("description"));
		product.setId(Integer.toString(result.getInt("productId")));
		product.setCategory(result.getString("subCategory"));
		product.setPrice(Double.toString(result.getDouble("price")));
		product.setStockLevel(Integer.toString(result.getInt("quantity")));
		
		ProductHolder.getInstance().addToArray(product); // add new object to ArrayList
		
		return product;
		
	}
	
	public static BasketItem parseListing(ResultSet result) throws SQLException {
		
		BasketItem basket = new BasketItem();
		
		basket.setCustomerId(result.getInt("customerId"));
		basket.setProductId(result.getInt("productId"));
		basket.setOrderId(result.getInt("orderId"));
		basket.setProductName(result.getString("productName"));
		basket.setPrice(result.getDouble("price"));
		basket.setQuantity(result.getInt("quantity"));
		
		return basket;
		
	}

}
