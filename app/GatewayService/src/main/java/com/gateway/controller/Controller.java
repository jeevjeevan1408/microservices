package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Controller {
	
	@GetMapping("/product/fallback")
	String getFallBack() {
		log.info("In fallback method()");
		return "Underlying system down";
	}

}
