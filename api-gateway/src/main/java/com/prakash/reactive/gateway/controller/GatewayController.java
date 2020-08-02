package com.prakash.reactive.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
public class GatewayController {

	@RequestMapping(value="/available")
	public String available() {
		return "Hello!! APIGate way Service Is Available";
	}
	
	
}
