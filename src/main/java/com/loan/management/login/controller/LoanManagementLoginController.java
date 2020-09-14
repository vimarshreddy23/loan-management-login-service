package com.loan.management.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.management.login.model.UserDetailsEntity;
import com.loan.management.login.service.LoanManagementLoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author ctsjavauser300
 *
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class LoanManagementLoginController {

	@Autowired
	private LoanManagementLoginService lmaLoginService;
	
	@GetMapping("/hello")
	public ResponseEntity<?> sayHello() {
		log.info("saying hello");
		return  ResponseEntity.ok().body("Welome");
	}
	 

}
