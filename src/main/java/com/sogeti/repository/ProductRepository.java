package com.sogeti.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sogeti.adapter.EntityAdapter;
import com.sogeti.model.Product;

public class ProductRepository extends Repository {
	
	private static final Logger logger = Logger.getLogger(ProductRepository.class);

	private Connection conn = getConnection();

	public String getAllProducts() throws Exception {

		ArrayList<Product> array = new ArrayList<Product>();

		PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT * FROM products"); // retrieve data from db

		ResultSet result = statement.executeQuery(); // result set of db query

		while (result.next()) { // if the ResultSet contains another entry
			
			array.add(EntityAdapter.parseProduct(result));
		}
		
		logger.debug("list of products returned from ProductRepository getAllProducts method");
		
		return new Gson().toJson(array);
	}

	public Product getProductById(int productId) throws SQLException {
		
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM products WHERE productId = " + "'" + (productId+1) + "'" ); // retrieve data from db
		/*
		 * have to add 1 to value of productId
		 * because value returned is products position in array starting at 0
		 * and the id's in the db start at 1
		 */

		ResultSet result = statement.executeQuery(); // result set of db query
		
		result.next(); // loads query result from db
		
		logger.debug("returning a product from ProductRepository getProductById method");

		return EntityAdapter.parseProduct(result);
	}
}