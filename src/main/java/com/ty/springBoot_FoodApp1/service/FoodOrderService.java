package com.ty.springBoot_FoodApp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dao.FoodOrderDao;
import com.ty.springBoot_FoodApp1.dto.FoodOrder;
import com.ty.springBoot_FoodApp1.dto.Items;
import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.dto.Product;

@Service
public class FoodOrderService {

	
	@Autowired
	private FoodOrderDao fdao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Items> list= foodOrder.getItems();
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<>();
		double totalprice=0;
		for(Items items:list) {
			totalprice+=items.getCost()*items.getQuantity();
			foodOrder.setTotalprice(totalprice);
					}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(fdao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder2=fdao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<>();
		if(foodOrder2!=null) {
			List<Items> list= foodOrder2.getItems();
			double totalprice=0;
			for(Items items:list) {
				totalprice+=items.getCost()*items.getQuantity();
				
			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(fdao.saveFoodOrder(foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		}
		else {
			return null;
		}
		}
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder=fdao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<>();
		if(foodOrder!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(fdao.saveFoodOrder(foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		}
		else {
			return null;
		}
		
		}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrder(int id) {
		FoodOrder foodOrder=fdao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure= new ResponseStructure<>();
		if(foodOrder!=null) {
			List<Items> list= foodOrder.getItems();
			double totalprice=0;
			for(Items items:list) {
				totalprice+=items.getCost()*items.getQuantity();
				foodOrder.setTotalprice(totalprice);
			
		}
			
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(fdao.saveFoodOrder(foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
		}
	}


