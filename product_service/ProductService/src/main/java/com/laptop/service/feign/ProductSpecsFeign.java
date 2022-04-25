package com.laptop.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.laptop.service.model.ProductDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(value = "product-details-service")
public interface ProductSpecsFeign {
	
	@GetMapping("/product_details/get/{id}")
	@CircuitBreaker(name = "CircuitBreaker1", fallbackMethod = "getFallBack")
	public ProductDetails getProductDetailsFeign(@PathVariable long id);
	
	default ProductDetails getFallBack(long id, Throwable exception) {
		System.out.println("In fallback method: "+ exception);
		return new ProductDetails();
	
	}

}
