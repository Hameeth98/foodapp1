package com.ty.springBoot_FoodApp1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp1.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder,Integer>{

}
