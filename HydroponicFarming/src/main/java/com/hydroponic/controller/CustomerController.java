package com.hydroponic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/get")
	public String getString() {
		return "welcome";
	}

}
