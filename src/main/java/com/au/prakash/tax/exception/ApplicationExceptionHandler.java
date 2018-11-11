package com.au.prakash.tax.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.au.prakash.tax.validation.ValidationError;
import com.au.prakash.tax.validation.ValidationErrorBuilder;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> invalidInput(MethodArgumentNotValidException ex) {
		return new ResponseEntity<>(ValidationErrorBuilder.fromBindingErrors(ex.getBindingResult()),
				HttpStatus.BAD_REQUEST);
	}
}
