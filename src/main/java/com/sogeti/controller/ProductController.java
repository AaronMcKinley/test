package com.sogeti.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sogeti.model.Product;
import com.sogeti.repository.ProductRepository;

@CrossOrigin
@RestController
public class ProductController {
	
	private static final Logger logger = Logger.getLogger(ProductController.class);
	
	ProductRepository product = new ProductRepository();

	Gson gson = new Gson();
	
	@GetMapping("/products")
	private String getAllProducts() throws Exception{
		logger.debug("In the /products endpoints");
		return product.getAllProducts();
	}
	
	@GetMapping("/products/{product_id}")
	private String getProductById(@PathVariable("product_id") int productId) throws Exception {
		logger.debug("In the /products endpoints");
		Product output = product.getProductById(productId);
		return gson.toJson(output);
	}
}
