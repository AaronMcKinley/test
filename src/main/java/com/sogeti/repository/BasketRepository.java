package com.sogeti.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.sogeti.adapter.EntityAdapter;
import com.sogeti.model.BasketItem;

public class BasketRepository extends Repository{
	
	private static final Logger logger = Logger.getLogger(BasketRepository.class);
		
	private Connection conn = getConnection();
	
	public ArrayList<BasketItem> getAllListings(String customerId) throws Exception {
		
		ArrayList<BasketItem> basket = new ArrayList<>();
		PreparedStatement getListings = conn.prepareStatement("SELECT * FROM listings WHERE customerId = " + customerId);
		ResultSet results = getListings.executeQuery();
		while(results.next()) {
			
			basket.add(EntityAdapter.parseListing(results));
			
		}
		logger.debug("returning a list of BasketItems from the BasketRepository getAllListings method");
		return basket;
	}
	public int addItemToCart(String customerId, BasketItem itemsIn) throws Exception {
		
		if(customerId.trim().isEmpty()) {
			throw new Exception("Invalid Customer Id");
		}
		
		double totalPrice = itemsIn.getPrice() * itemsIn.getQuantity();
		PreparedStatement insertNewListing = conn.prepareStatement("INSERT INTO listings(customerId, productId, productName, quantity, price) VALUES ('" + customerId + "', '" + itemsIn.getProductId() + "', '" + itemsIn.getProductName() + "', '" + itemsIn.getQuantity() + "', '" + totalPrice + "')");
		logger.debug("inserting a new listing from BasketRepository addItemToCart method");
		return insertNewListing.executeUpdate();
	}
	
	public int removeListingFromCart(String orderId) throws Exception{
		PreparedStatement deleteListing = conn.prepareStatement("DELETE FROM listings WHERE orderId = " + orderId);
		logger.debug("deleting a listing from BasketRepository removeListingFromCart method");
		return deleteListing.executeUpdate();
	}
	public boolean removeAllListingsById(String customerId) throws Exception {
		PreparedStatement removeListings = conn.prepareStatement("DELETE FROM listings WHERE customerId = " + customerId);
		logger.debug("remove customers listing from BasketRepository removeAllListingsById method");
		return removeListings.execute();
	}
}