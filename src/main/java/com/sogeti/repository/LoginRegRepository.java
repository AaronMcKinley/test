package com.sogeti.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class LoginRegRepository extends Repository {
	
	private static final Logger logger = Logger.getLogger(BasketRepository.class);

	private Connection conn = getConnection();

	public String loginUser(String name, String password) throws Exception {
		
		if(name.isEmpty() || password.isEmpty()) {
			throw new Exception("Name and Password must not be empty");
		}

		// check given username and password against the db
		PreparedStatement statement = conn.prepareStatement("SELECT name, password FROM users WHERE name = " + "'" + name + "'" + " AND password = " + "'" + password + "'" );

		ResultSet result = statement.executeQuery();
		
		if (result.next()) {
			logger.info("user logged in");
			return "true"; // username and password match with row in db // send true/false to front end to be handled
		} else { 
			return "false";
		}

	}

	public String registerUser(String name, String password)
			throws Exception {
		
		if(name.isEmpty() || password.isEmpty()) {
			throw new Exception("Name and Password must not be empty");
		}

		// search db to check if any user exists with given username
		PreparedStatement statement = conn.prepareStatement("SELECT name, password FROM users WHERE name = " + "'" + name + "'"); // retrieve data from db
		
		ResultSet result = statement.executeQuery();
		
		if (result.next()) {
			return "false";
		} else { // if username not taken, insert user
			insertUser(name, password);
			logger.info("new user registered");
			return "true"; // send true/false to front end to be handled
		}
	}

	private void insertUser(String name, String password) throws SQLException {

		PreparedStatement statement = conn.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?)");

		statement.setString(1, name);
		statement.setString(2, password);
		statement.executeUpdate();
	}
	
	public void removeUser(String name, String password) throws SQLException {
		
		PreparedStatement removeUser = conn.prepareStatement("DELETE FROM users WHERE name = " + name + " AND password = " + password);
		removeUser.execute();
	}

}
