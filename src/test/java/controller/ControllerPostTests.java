package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;

import org.junit.Test;

public class ControllerPostTests extends ControllerTests {
	
	@Test
	public void addItemsTest() {
		try {
			String url = "http://localhost:8080/baskets?customerId=2&productId=1&quantity=1";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void addWrongItemsTest() {
		try {
			String url = "http://localhost:8080/baskets";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(400, con.getResponseCode());
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void addOrderTest() {
		try {
			String url = "http://localhost:8080/baskets?customerId=2&productId=1&quantity=1";
			HttpURLConnection con = getRequest(url);
			
			url = "http://localhost:8080/orders?customerId=2";
			con = getRequest(url);
			
			assertEquals(200, con.getResponseCode());
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void addWrongOrderTest() {
		try {
			String url = "http://localhost:8080/orders";
			HttpURLConnection con = getRequest(url);
			
			assertEquals(400, con.getResponseCode());
		}catch(Exception ex) {
			assertTrue(true);
		}
	}
	
	@Test
	public void registerUserTest() {
		try {
			String url = "http://localhost:8080/validateregister?username=2&password=b";
			HttpURLConnection con = postRequest(url);
			
			assertEquals(200, con.getResponseCode());
			
			StringBuffer response = getResponse(con);
			assertEquals("true", response.toString());
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void registerWrongUserTest() {
		try {
			String url = "http://localhost:8080/register";
			HttpURLConnection con = postRequest(url);
			
			assertEquals(400, con.getResponseCode());
		}catch (Exception ex) {
			assertTrue(true);
		}
	}
	
}
