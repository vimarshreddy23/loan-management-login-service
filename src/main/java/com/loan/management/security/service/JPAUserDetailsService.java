package com.loan.management.security.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;

import com.loan.management.login.model.UserDetailsEntity;
import com.loan.management.login.repository.UserAuthenticationRepository;
import com.loan.management.security.model.CustomUserDetails;

import org.slf4j.Logger;

@Service
public class JPAUserDetailsService implements UserDetailsService {

	Logger log = LoggerFactory.getLogger(JPAUserDetailsService.class);
	@Autowired
	UserAuthenticationRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<UserDetailsEntity> user = userRepository.findByUserEmail(userEmail);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userEmail));
		return user.map(CustomUserDetails::new).get();
		
	}


}