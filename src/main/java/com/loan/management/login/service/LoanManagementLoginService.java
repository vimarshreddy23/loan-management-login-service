package com.loan.management.login.service;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import com.loan.management.login.repository.UserAuthenticationRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoanManagementLoginService  {

	@Autowired
	private UserAuthenticationRepository userAuthenticationRepository;
	/*
	 * 
	 * public ResponseEntity<?> check(UserDetailsEntity userDetails) {
	 * log.info("-->>>Validating Login Credentials<<<--");
	 * userDetails.setUserPasswordEncrypted(userDetails.getUserPassword());
	 * UserDetailsEntity udetails =
	 * userAuthenticationRepository.findByUserEmailAndUserPassword(userDetails.
	 * getUserEmail(), userDetails.getUserPasswordEncrypted()); if (null != udetails
	 * && Optional.of(udetails).isPresent()) return new ResponseEntity<>(udetails,
	 * HttpStatus.ACCEPTED); return new ResponseEntity<>("Invalid User Credentails",
	 * HttpStatus.FORBIDDEN); }
	 */

}
