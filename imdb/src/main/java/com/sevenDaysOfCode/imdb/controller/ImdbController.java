package com.sevenDaysOfCode.imdb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImdbController {
	
	@GetMapping(value = "/250Filmes")
	public List<Object> get250Filmes() {
		String url = "https://imdb-api.com/en/API/Top250Movies/<apiKey>";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> filmes = restTemplate.getForEntity(url, String.class);
		System.out.println(Arrays.asList(filmes));
		return Arrays.asList(filmes);
	}

}