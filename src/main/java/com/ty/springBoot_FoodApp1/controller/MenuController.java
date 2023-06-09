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
import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.service.MenuService;
@RestController
public class MenuController {
	@Autowired
	private MenuService service;
	
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}
	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@RequestParam int id) {
		return service.updateMenu(menu, id);
	}
	@DeleteMapping("/deletemenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int mid) {
		return service.deleteMenu(mid);
	}
	@GetMapping("/getmenubyid")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int mid) {
		return service.getMenuById(mid);
	}
	@GetMapping("/getmenubyname")
	public ResponseEntity<ResponseStructure<Menu>> getMenuByName(@RequestParam String mname) {
		return service.getMenuByName(mname);
	}
	
}
