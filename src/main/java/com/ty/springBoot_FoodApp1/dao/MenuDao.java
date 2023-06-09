package com.ty.springBoot_FoodApp1.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp1.dto.Menu;
import com.ty.springBoot_FoodApp1.repo.MenuRepo;

@Repository
public class MenuDao {

	
	@Autowired
	private MenuRepo repo;
	
	public Menu saveMenu(Menu menu) {
		 return repo.save(menu);
	}

	public Menu updateMenu(Menu menu, int id) {
		Optional<Menu> menu2=repo.findById(id);
		if(menu2.isPresent()) {
			menu.setMid(id);
			repo.save(menu);
			return menu2.get();
			
		}
		else {
			return null;
		}
	}
	
	public Menu deleteMenu(int mid) {
		Optional<Menu> menu=repo.findById(mid);
		if(menu.isPresent()) {
			repo.deleteById(mid);
			return menu.get();
			
		}
		else {
			return null;
		}
}
	public Menu getMenuById(int mid) {
		Optional<Menu> menu=repo.findById(mid);
		if(menu.isPresent()) {
			return menu.get();
			
		}
		else {
			return null;
		}
		
	}
	public Menu getMenuByname(String mname) {
		Menu menu=repo.getMenuByMenuname(mname);
		if(menu!=null) {
			return menu;
		}else {
			return null;
				}
			
	}
}