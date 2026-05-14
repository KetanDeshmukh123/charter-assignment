package com.reward.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidTransactionException.class)
	public ResponseEntity<String> handle(InvalidTransactionException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
