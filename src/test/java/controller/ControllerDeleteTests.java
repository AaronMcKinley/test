package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;

import org.junit.Test;

public class ControllerDeleteTests extends ControllerTests{
	
	@Test
	public void removeListingsByIdTest() {
		try {
			String url = "http://localhost:8080/baskets?customerId=2&productId=1&quantity=1";
			HttpURLConnection con = getRequest(url);
			
			url = "http://localhost:8080/remove/2";
			con = deleteRequest(url);
			
			assertEquals(200, con.getResponseCode());
		}catch(Exception ex) {
			fail();
		}
	}
	
	@Test
	public void removeListingsByWrongIdTest() {
		try {
			String url = "http://localhost:8080/remove";
			HttpURLConnection con = deleteRequest(url);
			
			assertEquals(400, con.getResponseCode());
		}catch(Exception ex) {
			assertTrue(true);
		}
	}
}
