package com.hydroponic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hydroponic.model.UserAccountDetails;
import com.hydroponic.model.UserInput;
import com.hydroponic.service.RegisterUserServiceImpl;

@RestController
@RequestMapping("/user")
public class RegisterUserController {

	@Autowired
	private RegisterUserServiceImpl curd;

	@PostMapping("/register")
	public ResponseEntity<UserAccountDetails> registerUser(@Valid @RequestBody UserInput input) {

		UserAccountDetails savedCustomer = curd.registerUser(input);

		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

}
