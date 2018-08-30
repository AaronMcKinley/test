package com.sogeti.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.repository.OrderRepository;

@CrossOrigin
@RestController
public class OrderController {
	
	private static final Logger logger = Logger.getLogger(OrderController.class);
	
	OrderRepository order = new OrderRepository();
	
	@GetMapping("/orders")
	private String addOrder(@RequestParam("customerId") String customerId) throws Exception {
		logger.debug("In the /orders endpoints");
		return order.addOrder(customerId);
	}
}
