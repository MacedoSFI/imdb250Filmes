package com.sevenDaysOfCode.imdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.controller.ImdbController.ListOfMovies;

public class ImDbApiClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public ResponseEntity<ListOfMovies> getListaFilmes(ResponseEntity<ListOfMovies> responseEntity, String apikey) {
		
		responseEntity = this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/" + apikey, ListOfMovies.class);
		return responseEntity;
	}

}