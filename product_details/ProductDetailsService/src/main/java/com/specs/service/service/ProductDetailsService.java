package com.specs.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specs.service.entity.ProductDetailsEntity;
import com.specs.service.repo.ProductDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductDetailsService {

	@Autowired
	ProductDetailsRepository productDetailsRepo;

	public ProductDetailsEntity getProductDetails(long id) {

		ProductDetailsEntity productDetails = productDetailsRepo.getLaptopSpecsByLaptopID(id);
		log.info("return from getProductDetails() method");
		return productDetails;
	}

}
