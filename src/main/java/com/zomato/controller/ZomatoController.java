package com.zomato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.dto.UserLogin;
import com.zomato.dto.UserLoginResponse;
import com.zomato.dto.UserRegister;
import com.zomato.service.JWTTokenUtil;
import com.zomato.service.ZomatoUserService;

@RestController
public class ZomatoController {

	@Autowired
	ZomatoUserService service;

	@Autowired
	JWTTokenUtil jwtTokenUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/create/user")
	public String registerUser(@RequestBody UserRegister request) {
		String result = service.registerUser(request);
		return result;
	}

	// This is for Login Operation : Integarte Secuirty Layer + JWT token

	@PostMapping("/login/user")
	public UserLoginResponse loginUser(@RequestBody UserLogin request) {

		// TODO : we need to pass Credentials to the Spring Security layer

		doAuthentication(request.getEmailId(), request.getPassword());

		String token = this.jwtTokenUtil.createToken(request.getEmailId());

		UserLoginResponse response = new UserLoginResponse();
		response.setEmilaId(request.getEmailId());
		response.setToken(token);

		// Internally, Spring Security Layer validates User Credentials

		/// internally Security Layer connects to DB, and check for userName & password

		// If User Is valid and certified by Security , Generates token and attach as
		// part of response objecct

		// JWT token Genearttion : by passing login userName

		// Incase User is Invalid, then we will send a message like Invalid Crdentilas.

		return response;

	}

	private void doAuthentication(String userName, String password) {
		// passing username and password to Authetincation Manager

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password);
		try {
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (BadCredentialsException e) {
			throw new RuntimeException("Invalid User NAme and Password. ");
		}

	}

	@GetMapping("/get/profile")
	public String getProfile() {

		return "Welcome Dilip , Please find Your Profile Details";
	}

	@GetMapping("/get/orders")
	public String getOrders(@RequestHeader String token) {

		return "Welcome Dilip , Please find Your Order Details";
	}

}
