package com.laptop.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	private String productName;

}
