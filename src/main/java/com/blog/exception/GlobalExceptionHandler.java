package com.blog.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
		return new ResponseEntity<String>(resourceNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String,String> m = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(e -> {
			String error = ((FieldError)e).getField();
			String mess = e.getDefaultMessage();
			m.put(error, mess);
		});
		return new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);
	}
}
