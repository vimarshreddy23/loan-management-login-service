package com.loan.management.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.management.security.model.AuthenticationRequest;
import com.loan.management.security.model.AuthenticationResponse;
import com.loan.management.security.model.CustomUserDetails;
import com.loan.management.security.service.JPAUserDetailsService;
import com.loan.management.security.util.JwtUtil;

@RestController
@CrossOrigin
//@RequestMapping("/loan-management") 
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private JPAUserDetailsService userDetailsService;

	@PostMapping(value = "/login")

	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();

		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		final CustomUserDetails userDetails = (CustomUserDetails) userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		AuthenticationResponse response = new AuthenticationResponse(jwt);

		response.setId(userDetails.getId());
		response.setUsername(userDetails.getUsername());
		List<String> roles = new ArrayList<String>();
		userDetails.getAuthorities().forEach((a) -> roles.add(a.getAuthority()));
		response.setRoles(roles);

		return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);

	}

}
