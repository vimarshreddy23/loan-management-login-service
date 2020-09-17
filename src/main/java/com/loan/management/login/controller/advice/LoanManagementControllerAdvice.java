package com.loan.management.login.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.*"})
public class LoanManagementControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
		return new ResponseEntity<>("Exception Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
