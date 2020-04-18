package com.example.demo.service;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration

@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.requestMatchers().antMatchers("/publishes") // Deny access to
				.and().authorizeRequests().antMatchers("/publishes").permitAll().and().requestMatchers()
				.antMatchers("/private") // Deny access to "/ private"
				.and().authorizeRequests().antMatchers("/private").access("hasRole('USER')").and().requestMatchers()
				.antMatchers("/admin") // Deny access to "/ admin"
				.and().authorizeRequests().antMatchers("/admin").access("hasRole('ADMIN')").and().requestMatchers()
				.antMatchers("/products/**") // Deny access to "/ admin"
				.and().authorizeRequests().antMatchers("/products/**").access("hasRole('ADMIN')");
	}

	@RequestMapping("/publishes")
	public String publico() {
		return "Public Page";
	}

	@RequestMapping("/private")
	public String privatep() {
		return "Private Page";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "Administrator Page";
	}
	
}