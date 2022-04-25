package com.specs.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.specs.service.entity.ProductDetailsEntity;
import com.specs.service.service.ProductDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/product_details")
public class Controller {

	@Autowired
	ProductDetailsService productDetails;

	@GetMapping("/get/{id}")
	public ProductDetailsEntity getLaptopSpecs(@PathVariable long id) {
		log.info("In product details service");
		return productDetails.getProductDetails(id);
	}

	/*
	 * @Transactional
	 * 
	 * @PostMapping("/add") public String addSpecs(@RequestBody ProductSpecsRequest
	 * request) { if (productDetails.addSpecs(request)) { return
	 * "Specs stored successfully"; } else { return "Failed to store specs"; } }
	 */
}
