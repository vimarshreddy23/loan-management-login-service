package com.scb.lma.login.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.scb.lma.login")
public class LoanManagementControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex) {
		log.info("Exception Occured",ex.getMessage());
		return "Exception_Occured";
	}
}

