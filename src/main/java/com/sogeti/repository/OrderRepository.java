package com.sogeti.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.sogeti.adapter.EntityAdapter;
import com.sogeti.model.BasketItem;

public class OrderRepository extends Repository {
	
	private static final Logger logger = Logger.getLogger(BasketRepository.class);

	private Connection conn = getConnection();

	public String addOrder(String customerId) throws Exception {
		
		PreparedStatement getAllListings = conn
				.prepareStatement("SELECT * FROM listings WHERE customerId = " + customerId);
		ResultSet results = getAllListings.executeQuery();
		if (!results.next()) {
			return "false";
		} else {
			results.previous(); // move counter back one to include first item in cart
			while (results.next()) {
				BasketItem adapter = EntityAdapter.parseListing(results);
				int productId = adapter.getProductId();
				String productName = adapter.getProductName();
				int quantity = adapter.getQuantity();
				double price = adapter.getPrice();

				PreparedStatement addOrder = conn.prepareStatement(
						"INSERT INTO orders(customerId, productId, productName, quantity, price) VALUES ('" + customerId
								+ "', '" + productId + "', '" + productName + "', '" + quantity + "', '" + price + "')");
				addOrder.execute();

				// decrease stock level of product by quantity bought
				PreparedStatement adjustStock = conn.prepareStatement(
						"UPDATE products SET quantity = (quantity - " + quantity + ") WHERE productId = " + productId);
				adjustStock.execute();

			}
			logger.debug("order added and stock adjusted from OrderRepository addOrder method");
			return "true";
		}
	}
	
	public void setOrderTestConditions() throws SQLException {
		PreparedStatement addTestProduct = conn.prepareStatement("INSERT INTO products(productId, quantity) VALUES ('99', '99'");
		addTestProduct.execute();
	}
	
	public void removeOrder(String customerId) throws SQLException {
		PreparedStatement removeOrder = conn.prepareStatement("DELETE FROM orders WHERE customerId = )" + customerId);
		removeOrder.execute();
		PreparedStatement removeTestProduct = conn.prepareStatement("DELETE FROM products WHERE productId = '99'");
		removeTestProduct.execute();
	}
}
