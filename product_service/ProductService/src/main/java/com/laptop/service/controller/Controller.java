package com.laptop.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.service.model.Products;
import com.laptop.service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/product")
@Slf4j
public class Controller {

	@Autowired
	ProductService productService;

//	@GetMapping("/list-all-products")
	@GetMapping("/products-list")
	public List<Products> getAllProducts(@RequestHeader MultiValueMap<String, String> headers) {
		log.info("********************");
		log.info("In product service");
		headers.forEach((key, value) -> {
			log.info("{} : {}", key, value);
		});
		return productService.getProductDetails();
	}
	
	@GetMapping("/get")
	public String dummyData() {
		return "Hello World !!!";
	}
	
	@PostMapping("/add")
	public void addProduct(@RequestBody Products products) {
		
		productService.store(products);
		
	}

}
