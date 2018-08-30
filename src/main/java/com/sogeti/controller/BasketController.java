package com.sogeti.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sogeti.model.BasketItem;
import com.sogeti.model.Product;
import com.sogeti.repository.BasketRepository;
import com.sogeti.repository.ProductRepository;

@CrossOrigin
@RestController
public class BasketController {
	
	private static final Logger logger = Logger.getLogger(BasketController.class);
	
	ProductRepository product = new ProductRepository();
	BasketRepository basket = new BasketRepository();
	
	Gson gson = new Gson();
	
	@GetMapping("/baskets")
	private void addItemsToBasket(@RequestParam("customerId") String customerId, @RequestParam("productId") int productId, @RequestParam("quantity") int quantity) throws Exception {
		logger.debug("In the /baskets endpoints");
		Product prod = product.getProductById(productId);
		BasketItem itemsIn = new BasketItem(prod, quantity);
		basket.addItemToCart(customerId, itemsIn);
	}
	
	@GetMapping("/baskets/{customerId}")
	private String getBasketById(@PathVariable("customerId") String customerId) throws Exception {
		logger.debug("In the /baskets endpoints");
		return gson.toJson(basket.getAllListings(customerId));
	}
	
	@DeleteMapping("/removeListing/{orderId}")
	private void removeListingFromBasket(@PathVariable("orderId") String orderId) throws Exception {
	logger.debug("In the /removeListing endpoints");
		basket.removeListingFromCart(orderId);
	}
	
	@DeleteMapping("/remove/{customerId}")
	private void removeAllListingsFromBasket(@PathVariable("customerId") String customerId) throws Exception {
		logger.debug("In the /remove endpoints");
		basket.removeAllListingsById(customerId);
	}
}
	