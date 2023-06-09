package com.ty.springBoot_FoodApp1.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dao.UserDao;
import com.ty.springBoot_FoodApp1.dto.User;
import com.ty.springBoot_FoodApp1.exception.UserIdNotFoundException;

@Service
public class UserService {

	
	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<User>> updateUser (int id, User user) {
		User user2=dao.updateUser(id,user);
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		if(user2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user successfully updated");
			responseStructure.setData(dao.saveUser(user));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			return null;
		}
		}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser (int id) {
		User user=dao.deleteUser(id);
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user successfully deleted");
			responseStructure.setData(dao.saveUser(user));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			return null;
		}
		}
	public ResponseEntity<ResponseStructure<User>> getUserById (int id) {
		User user=dao.getUserById(id);
		ResponseStructure<User> responseStructure= new ResponseStructure<>();
		if(user!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("user successfully found");
			responseStructure.setData(dao.saveUser(user));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
			
		}
		else {
			throw new NoSuchElementException();
		}
		}


}
