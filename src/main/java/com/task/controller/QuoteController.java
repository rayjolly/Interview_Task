package com.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {
	// localhost:8080/quote
	@GetMapping("/quote")
	public ResponseEntity<Object> getRandomQuote() {
		RestTemplate restTemplate = new RestTemplate();
		String apiUrl = "https://api.quotable.io/random";
		Object quoteResponse = restTemplate.getForObject(apiUrl, Object.class);
		return ResponseEntity.ok(quoteResponse);
	}
}
