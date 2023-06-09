package com.ty.springBoot_FoodApp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dto.Product;
import com.ty.springBoot_FoodApp1.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	@PutMapping("/updateproduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id,@RequestBody Product product) {
		return service.updateProduct(product,id);
		
	}
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id) {
		return service.deleteProduct(id);
	}
	@GetMapping("/getproduct")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id) {
		return service.getProductById(id);
	}
}
