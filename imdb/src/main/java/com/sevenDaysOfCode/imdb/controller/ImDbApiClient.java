package com.sevenDaysOfCode.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.controller.ImdbController.ListOfMovies;

@Service
@ConfigurationProperties(prefix = "imdb")
public class ImDbApiClient {
	
	@Value("${imdb.apiKey}")
    private String apiKey;
    
    public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
    public String getApiKey() {
		return apiKey;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ListOfMovies getBody() {
		
		ResponseEntity<ListOfMovies> response = this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/" 
		+ apiKey, ListOfMovies.class);
		return response.getBody();
	}

}