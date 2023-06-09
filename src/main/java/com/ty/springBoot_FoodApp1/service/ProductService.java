package com.ty.springBoot_FoodApp1.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;
import com.ty.springBoot_FoodApp1.dao.ProductDao;
import com.ty.springBoot_FoodApp1.dto.Product;
import com.ty.springBoot_FoodApp1.dto.User;
import com.ty.springBoot_FoodApp1.exception.ProductIdNotFound;
import com.ty.springBoot_FoodApp1.exception.UserIdNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductDao pdao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(pdao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<Product>> updateProduct (Product product,int id) {
		Product product2=pdao.updateProduct(product,id);
		if(product2!=null) {
			ResponseStructure<Product> responseStructure= new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(pdao.saveProduct(product));
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
			
			
		}
		else {
			throw new ProductIdNotFound("product id not present");
		}
		}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct (int id) {
		Product product=pdao.deleteProduct(id);
		if(product!=null) {
			ResponseStructure<Product> responseStructure= new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(pdao.saveProduct(product));
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
			
			
		}
		else {
			return null;
		}
		}
	public ResponseEntity<ResponseStructure<Product>> getProductById (int id) {
		Product product=pdao.getProductById(id);
		if(product!=null) {
			ResponseStructure<Product> responseStructure= new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(pdao.saveProduct(product));
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);
			
			
			
		}
		else {
			return null;
		}
		}

	//public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct (int mid) {
	//	List<Product> product=pdao.findallproducts(mid);
	//	ResponseStructure<List<Product>> responseStructure= new ResponseStructure<List<Product>>();
	//	if(product!=null) {
	//		responseStructure.setStatus(HttpStatus.OK.value());
	//		responseStructure.setMessage("Found");
	//		responseStructure.setData(product);
	//		return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.FOUND);
			
			
			
//		}
//		else {
//			throw new NoSuchElementException();
//		}
//		}

}
