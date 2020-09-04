package com.scb.lma.login.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = {"com.scb.lma.login"})
public class LoanManagementControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
		log.info("Exception Occured", ex.getMessage());
		return new ResponseEntity<>("Exception Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
