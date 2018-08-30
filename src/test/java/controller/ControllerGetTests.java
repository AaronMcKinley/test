package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;
import org.junit.Test;

import com.google.gson.Gson;

public class ControllerGetTests extends ControllerTests{
	
	Gson gson = new Gson();
	
	@Test
	public void getAllProductsTest() {
		try {
			String url = "http://localhost:8080/products";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
			
			StringBuffer response = getResponse(con);
			assertNotNull(response);
			
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void getProductByIdTest() {
		try {
			String url = "http://localhost:8080/products/1";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
			
			StringBuffer response = getResponse(con);
			assertNotNull(response);
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void getProductByWrongIdTest() {
		try {
			String url = "http://localhost:8080/products/1000000";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(500, con.getResponseCode());
		}catch(Exception ex) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getBasketByIdTest() {
		try {
			String url = "http://localhost:8080/baskets/1";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
			
			StringBuffer response = getResponse(con);
			
			assertNotNull(response);
		}catch(Exception ex) {
			fail();
		}
	}
		
	@Test
	public void getBasketByWrongIdTest() {
		try {
			String url = "http://localhost:8080/baskets/100000";
			HttpURLConnection con = getRequest(url);
			
			StringBuffer response = getResponse(con);
			
			assertEquals("[]", response.toString());
		}catch(Exception ex) {
			assertTrue(true);
		}
	}
	
	@Test
	public void validateLoginTest() {
		try {
			String url = "http://localhost:8080/validatelogin?username=1&password=a";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
			
			StringBuffer response = getResponse(con);
			
			assertEquals("true", response.toString());
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void validateWrongLoginTest() {
		try {
			String url = "http://localhost:8080/validatelogin";
			HttpURLConnection con = getRequest(url);
			
			StringBuffer response = getResponse(con);
			
			assertEquals("false", response.toString());
		}catch(Exception ex) {
			assertTrue(true);
		}
	}
}
