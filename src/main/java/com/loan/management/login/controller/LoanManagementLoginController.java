package com.loan.management.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author ctsjavauser300
 *
 */

@RestController
@RequestMapping("/api")
public class LoanManagementLoginController {

	@GetMapping("/hello")
	public ResponseEntity<?> sayHello() {
		return ResponseEntity.ok().body("Welome");
	}

}
