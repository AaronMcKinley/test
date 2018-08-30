package repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.gson.Gson;
import com.sogeti.repository.*;

public class RepoSelectTests {
	
	BasketRepository basket = new BasketRepository();
	ProductRepository product = new ProductRepository();
	LoginRegRepository login = new LoginRegRepository();
	
	Gson gson = new Gson();

	@Test
	public void getAllProductsTest() {
		try {
			String response = product.getAllProducts();
			assertNotNull(response);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void getProductByIdTest() {
		try {
			String response = gson.toJson(product.getProductById(1));
			assertNotNull(response);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void getProductByWrongIdTest() {
		try {
			product.getProductById(-1);
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void getListingsByIdTest() {
		try {
			String response = gson.toJson(basket.getAllListings("1"));
			assertNotNull(response);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void getListingByWrongIdTest() {
		try {
			basket.getAllListings("a");
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void valdiateUsersTest() {
		try {
			String response = login.loginUser("1", "a");
			assertNotNull(response);
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void validateWrongUsersTest() {
		try {
			login.loginUser("", "");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
