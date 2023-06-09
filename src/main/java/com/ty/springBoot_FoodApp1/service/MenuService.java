package com.ty.springBoot_FoodApp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dao.MenuDao;
import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.dto.Product;
@Service
public class MenuService {
	@Autowired
	private MenuDao mdao;
	
	public  ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(mdao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		Menu menu2=mdao.updateMenu(menu,id);
		ResponseStructure<Menu> responseStructure= new ResponseStructure<>();
		if(menu2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(mdao.saveMenu(menu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
			
			
		}
		else {
			return null;
		}
		}
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int mid) {
		Menu menu=mdao.deleteMenu(mid);
		ResponseStructure<Menu> responseStructure= new ResponseStructure<>();
		if(menu!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(mdao.saveMenu(menu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
			
			
		}
		else {
			return null;
		}
		}
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int mid) {
		Menu menu=mdao.getMenuById(mid);
		ResponseStructure<Menu> responseStructure= new ResponseStructure<>();
		if(menu!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(mdao.saveMenu(menu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
			
			
		}
		else {
			return null;
		}
		}

	public ResponseEntity<ResponseStructure<Menu>> getMenuByName(String mname) {
		Menu menu=mdao.getMenuByname(mname);
		ResponseStructure<Menu> responseStructure= new ResponseStructure<>();
		if(menu!=null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(mdao.saveMenu(menu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.FOUND);
			
		}
		else {
		return null;
	}
	}
}


