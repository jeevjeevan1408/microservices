package com.specs.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.specs.service.entity.ProductDetailsEntity;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetailsEntity, Long> {

	@Query("select c from ProductDetailsEntity c where c.id = :id")
	public ProductDetailsEntity getLaptopSpecsByLaptopID(Long id);
	
}
