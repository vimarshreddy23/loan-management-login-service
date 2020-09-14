package com.scb.lma.login.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.management.LoanManagementAuthenticationApp;
import com.loan.management.login.model.UserDetailsEntity;
import com.loan.management.login.repository.UserAuthenticationRepository;
import com.loan.management.login.service.LoanManagementLoginService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { LoanManagementAuthenticationApp.class })
public class LoanManagementLoginControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private LoanManagementLoginService lmaLoginService;
	
	@MockBean
	private UserAuthenticationRepository userDetailsRepository;
	
	private ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
	
	private static final String USER_DETAILS = "src/test/resources/data/userDetailsRequest.json";

	UserDetailsEntity userDetails;
	
	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		userDetails = new UserDetailsEntity();
		userDetails = mapper.readValue(new File(USER_DETAILS), UserDetailsEntity.class);
	}
	/*
	 * @Test public void login_IsValid_Request() throws Exception {
	 * when(lmaLoginService.check(any(UserDetailsEntity.class))).thenReturn(new
	 * ResponseEntity<>(HttpStatus.ACCEPTED));
	 * mockMvc.perform(get("/api/login").contentType(MediaType.APPLICATION_JSON)
	 * .content(mapper.writeValueAsString(userDetails))
	 * .accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted()); }
	 * 
	 * @Test public void getLoginStatus_Exception() throws JsonProcessingException,
	 * Exception {
	 * when(lmaLoginService.check(any(UserDetailsEntity.class))).thenThrow(new
	 * RuntimeException());
	 * mockMvc.perform(get("/api/login").contentType(MediaType.APPLICATION_JSON)
	 * .content(mapper.writeValueAsString(userDetails))
	 * .accept(MediaType.APPLICATION_JSON)).andExpect(status().is5xxServerError());
	 * }
	 */

}
