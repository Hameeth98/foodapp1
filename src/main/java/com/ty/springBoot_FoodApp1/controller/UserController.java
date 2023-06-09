package com.ty.springBoot_FoodApp1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dto.User;
import com.ty.springBoot_FoodApp1.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value ="Save User", notes = "API is used to save user for given user id")
	@ApiResponses(value = {@ApiResponse(code =200, message="sucessfully saved"),@ApiResponse
			(code=400,message="id not found for the given user id")})
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	@ApiOperation(value ="Update User", notes = "API is used to update the user for given user id")
	@ApiResponses(value = {@ApiResponse(code =201, message="sucessfully updated"),@ApiResponse
			(code=404,message="id not found for the given user id")})
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id,@RequestBody User user) {
		return service.updateUser(id, user);
		
	}
	@ApiOperation(value ="Delete User", notes = "API is used to delete the user for given user id")
	@ApiResponses(value = {@ApiResponse(code =200, message="sucessfully deleted"),@ApiResponse
			(code=404,message="id not found for the given user id")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteuser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}
	@ApiOperation(value ="Get User By Id", notes = "API is used to get the user by id")
	@ApiResponses(value = {@ApiResponse(code =302, message="user id is found"),@ApiResponse
			(code=404,message="user id is not found")})
	@GetMapping("/getuser")
	public ResponseEntity<ResponseStructure<User>> getuserById(@Valid @RequestParam int id) {
		return service.getUserById(id);
	}
	
}
