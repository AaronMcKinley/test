package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sogeti.model.BasketItem;
import com.sogeti.repository.*;

public class RepoInsertTests {
	
	BasketRepository basket = new BasketRepository();
	OrderRepository order = new OrderRepository();
	LoginRegRepository login = new LoginRegRepository();
	
	BasketItem b = new BasketItem(99, "a", 10, 10);
	
	@Test
	public void addItemToBasketTest() {
		try{
			assertEquals(1, basket.addItemToCart("99", b));
			basket.removeAllListingsById("99");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void addWrongItemToBasketTest() {
		try {
			basket.addItemToCart(null, b);
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void addOrderTest() {
		try {
			order.setOrderTestConditions();
			basket.addItemToCart("99", b);
			order.addOrder("99");
			order.removeOrder("99");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void addWrongOrderTest() {
		try {
			order.addOrder("-1");
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void registerUserTest() {
		try {
			String response = login.registerUser("name", "password");
			assertNotNull(response);
			login.removeUser("name", "password");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void registerWrongUserTest() {
		try {
			login.registerUser("", "");
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
}
