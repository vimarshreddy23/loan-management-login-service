package com.scb.lma.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class LoanManagementApp {
	public static void main(String[] args) {
		SpringApplication.run(LoanManagementApp.class, args);
		log.info("Loan Management App Started");
	}
}
