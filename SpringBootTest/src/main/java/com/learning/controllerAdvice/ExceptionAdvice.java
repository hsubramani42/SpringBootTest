package com.learning.controllerAdvice;

import java.util.HashMap;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.exceptions.AccountExistsException;
import com.learning.exceptions.IdNotFoundException;
import com.learning.validationError.ApiError;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

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

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<?> exceptionHandler(AuthenticationException e) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Message", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation Error");
		apiError.addValidationFieldErrors(ex.getBindingResult().getFieldErrors()); // fieldwise errors
		apiError.addValidationObjectErrors(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);

	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}

}
