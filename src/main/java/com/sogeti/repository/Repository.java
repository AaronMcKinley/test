package com.sogeti.repository;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.sogeti.connector.RepositoryConnector;

public class Repository {
	
	private static final Logger logger = Logger.getLogger(BasketRepository.class);
	
	RepositoryConnector repoConn = new RepositoryConnector();

	protected Repository() {}
	
	protected Connection getConnection() {
		Connection conn = null;
		try {
			conn = repoConn.getConnection();
		} catch (Exception e) {
			logger.error(e);
		}
		return conn;
	}
}
