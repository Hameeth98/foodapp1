package com.ty.springBoot_FoodApp1.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp1.dto.User;
import com.ty.springBoot_FoodApp1.repo.UserRepo;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
		
	}
	public User updateUser (int id, User user) {
		User user2=repo.findById(id).get();
		if(user2!=null) {
			user.setId(id);
			repo.save(user);
			return user2;
			
		}
		else {
			return null;
		}
		}

	public User deleteUser (int id) {
		Optional<User> user=repo.findById(id);
		if(user.isPresent()) {
			repo.deleteById(id);
			return user.get();
			
		}
		else {
			return null;
		}
		}
	public User getUserById (int id) {
		Optional<User> user=repo.findById(id);
		if(user.isPresent()) {
			return user.get();
			
		}
		else {
			return null;
		}
		}
	
	
	}


