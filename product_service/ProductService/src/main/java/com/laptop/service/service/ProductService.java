package com.laptop.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.service.entity.Product;
import com.laptop.service.feign.ProductSpecsFeign;
import com.laptop.service.model.ProductDetails;
import com.laptop.service.model.Products;
import com.laptop.service.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	ProductSpecsFeign productDetailsFeign;

	public List<Products> getProductDetails() {
		
		List<Products> productsList = new ArrayList<>();
		List<Product> products = productRepo.findAll();
		log.info("{} ",products.size());
		for (Product p : products) {
			Products prods = new Products();
			prods.setId(p.getId());
			prods.setName(p.getProductName());
			log.info("**FEIGN CALL**");
    		ProductDetails details = productDetailsFeign.getProductDetailsFeign(p.getId());
    		log.info("**RESPONSE FROM FEIGN CALL**");
    		prods.setProductDetails(details);

    		productsList.add(prods);
		}
		
		return productsList;
	}

	@Transactional
	public void store(Products products) {
		Product p = new Product();
		p.setProductName(products.getName());
		
		productRepo.save(p);		
	}
}
