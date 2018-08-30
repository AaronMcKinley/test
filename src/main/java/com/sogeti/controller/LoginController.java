package com.sogeti.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sogeti.repository.LoginRegRepository;

@CrossOrigin
@RestController
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	LoginRegRepository login = new LoginRegRepository();
	
	@PostMapping("/login")
	private void login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		logger.debug("In the /login endpoints");
		login.loginUser(username, password);
	}
	
	@PostMapping("/register")
	private void register(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		logger.debug("In the /register endpoints");
		login.registerUser(username, password);
	}
	
	@GetMapping("/validatelogin")
	private String validateLogin(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		logger.debug("In the /validatelogin endpoints");
		return login.loginUser(username, password);
	}
	
	@GetMapping("/validateregister")
	private String validateRegister(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
		logger.debug("In the /validateregister endpoints");
		return login.registerUser(username, password);
	}

}
