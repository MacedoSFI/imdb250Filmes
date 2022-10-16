package com.sevenDaysOfCode.imdb.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImdbController {
	
    @Autowired
    private ImDbApiClient imDbApiClient;
    
    @Autowired
    private ImDbHTML imDbHTML;
    
    @Value("k_4qe4eo9s")
	private String apikey;
    
    @GetMapping("/top250filmes")
    public ListOfMovies getTop250Filmes() {
    	ResponseEntity<ListOfMovies> response = null;
    	response = imDbApiClient.getListaFilmes(response, apikey);
    	System.out.println(apikey);
        return response.getBody();
    }

    @GetMapping("/top250filmesHTML")
    public ListOfMovies getTop250FilmesHTML() throws FileNotFoundException {
    	ResponseEntity<ListOfMovies> response = null;
    	response = imDbHTML.getListaFilmes(response, apikey);
        return response.getBody();
    }

    record Movie(String title, String image, String year, String imDbRating){}
    record ListOfMovies(List<Movie> items){}
   
}

