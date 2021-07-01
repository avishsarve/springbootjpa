package com.spring.springbootjpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.springbootjpa.Exception.ErrorDao;
import com.spring.springbootjpa.Exception.NoSuchAccountException;
import com.spring.springbootjpa.Exception.StateNotFoundException;


@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class AccountExceptionhandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchAccountException.class)
	protected ResponseEntity<ErrorDao> handleWhenNoAccountFound(RuntimeException e){
		return new ResponseEntity<>(ErrorDao
				.builder()
				.errorCode(404)
				.errorMessage(e.getMessage())
				.build(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StateNotFoundException.class)
	protected ResponseEntity<ErrorDao> handleWhenNoAccountWithStateFound(RuntimeException e){
		return new ResponseEntity<>(ErrorDao
				.builder()
				.errorCode(404)
				.errorMessage(e.getMessage())
				.build(), HttpStatus.NOT_FOUND);
	}

}