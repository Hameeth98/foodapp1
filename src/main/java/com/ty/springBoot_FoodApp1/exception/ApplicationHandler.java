package com.ty.springBoot_FoodApp1.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springBoot_FoodApp1.config.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler{
	private Object object;
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> UserNotFound(UserIdNotFoundException ex){
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("user id not found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND); 	
		
	}
		@ExceptionHandler(ProductIdNotFound.class)
		public ResponseEntity<ResponseStructure<String>> ProductIdNotFound(ProductIdNotFound ex){
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage(ex.getMessage());
			responseStructure.setData("user id not found");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND); 	
			
		}
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
				  List<ObjectError> list =ex.getAllErrors();
				  HashMap<String, String> hashMap= new HashMap<>();
				  for (ObjectError error : list) {
					  String message = error.getDefaultMessage();
					  String fieldname= ((FieldError) error).getField();
					  hashMap.put(fieldname, message);
				  }
				  return new ResponseEntity<Object>(hashMap, HttpStatus.BAD_REQUEST);
				  
		}
		
		  

	
}
