package com.learning.controllerAdvice;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learning.exceptions.AccountExistsException;
import com.learning.exceptions.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {

	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(IdNotFoundException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Message", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(AccountExistsException.class)
	public ResponseEntity<?> exceptionHandler(AccountExistsException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Message", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
}
