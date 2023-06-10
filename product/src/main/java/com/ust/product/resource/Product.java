package com.ust.product.resource;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	
	private Integer ProductId;
	
	private String name;
	
	private String category;
	
	private String brand;
	
	private double price;
	

}

