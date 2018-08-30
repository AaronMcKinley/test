package com.sogeti.connector;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;

public class RepositoryConnector {
	
	private static final Logger logger = Logger.getLogger(RepositoryConnector.class);
	
	// create connection to db method
    public Connection getConnection() {

        	Properties prop = new Properties();
        	InputStream input = null;
        	try {
        		String filename = "sales-PROD.properties";
        		input = RepositoryConnector.class.getClassLoader().getResourceAsStream(filename);
        		if(input==null){
        	            logger.error("Sorry, unable to find " + filename);
        		}
        	//load a properties file from class path, inside static method
        	prop.load(input);    
        	String driver=prop.getProperty("driver");
            String url=prop.getProperty("url"); // db URL
            String username=prop.getProperty("username");
            String password=prop.getProperty("password");
            Class.forName(driver); // specifies which JDBC to make connection with

            return DriverManager.getConnection(url, username, password); // establish connection with given db  
        } 
        catch (Exception e) {
            logger.error(e);
        }

        return null;
    }

}