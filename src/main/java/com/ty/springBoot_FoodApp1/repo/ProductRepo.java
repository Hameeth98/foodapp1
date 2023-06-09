package com.ty.springBoot_FoodApp1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.dto.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
	
	

}
