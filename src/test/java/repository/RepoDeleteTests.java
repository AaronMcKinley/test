package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sogeti.repository.*;

public class RepoDeleteTests {
	
	BasketRepository basket = new BasketRepository();

	@Test
	public void removeListingTest() {
		try {
			assertEquals(1, basket.removeListingFromCart("10"));
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void removeWrongListingTest() {
		try {
			basket.removeListingFromCart("-1");
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void removeAllListingsByIdTest() {
		try {
			assertEquals(1, basket.removeAllListingsById("3"));
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void removeAllListingsByWrongIdTest() {
		try {
			basket.removeAllListingsById("-1");
			fail();
		} catch(Exception e) {
			assertTrue(true);
		}
	}
}
