package com.ty.springBoot_FoodApp1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp1.dto.User;
public interface UserRepo extends JpaRepository<User,Integer>{
	
	

}
