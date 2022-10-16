package com.sevenDaysOfCode.imdb.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.controller.ImdbController.ListOfMovies;

public class ImDbHTML{
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public ResponseEntity<ListOfMovies> getListaFilmes(ResponseEntity<ListOfMovies> responseEntity, 
			String apikey) throws FileNotFoundException {
		
		responseEntity = this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/" 
		+ apikey, ListOfMovies.class);
		
		PrintWriter writer = new PrintWriter("src/main/resources/content.html");
		new HTMLGenerator(writer).generate(responseEntity.getBody());
		writer.close();
		return responseEntity;
	}

}
