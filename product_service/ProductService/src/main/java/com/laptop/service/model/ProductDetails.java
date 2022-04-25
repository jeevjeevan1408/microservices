package com.laptop.service.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductDetails {
	
	private long id;
	private String productName;
	private String productCategory;
	private String price;

}
