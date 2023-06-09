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
import com.ty.springBoot_FoodApp1.dto.FoodOrder;
import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.service.FoodOrderService;
@RestController
public class FoodOrderController {
	@Autowired
	private FoodOrderService service;
	
	@PostMapping("/savefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodorder) {
		return service.saveFoodOrder(foodorder);
	}
	@PutMapping("/updatefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodorder,@RequestParam int id) {
		return service.updateFoodOrder(foodorder, id);
	}
	@DeleteMapping("/deletefoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}
	@GetMapping("/getfoodorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(@RequestParam int id) {
		return service.getFoodOrder(id);
	}

}
