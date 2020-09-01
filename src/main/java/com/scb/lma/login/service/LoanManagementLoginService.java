package com.scb.lma.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scb.lma.login.model.UserDetails;
import com.scb.lma.login.repository.UserDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoanManagementLoginService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public ResponseEntity<?> check(UserDetails userDetails) {
		log.info("Validating Login Credentials");
		UserDetails udetails = userDetailsRepository.findByuserNameAnduserPassword(userDetails.getUserName(),
				userDetails.getUserPassword());
		if(Optional.of(udetails).isPresent())
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
