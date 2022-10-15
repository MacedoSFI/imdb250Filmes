package com.sevenDaysOfCode.imdb.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImdbController {
	
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/250Filmes")
    public ListOfMovies getTop250Filmes() throws FileNotFoundException {
    	ResponseEntity<ListOfMovies> response =
                this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/k_4qe4eo9s", ListOfMovies.class);
        PrintWriter writer = new PrintWriter("src/main/resources/content.html");
        new HTMLGenerator(writer).generate(response.getBody());
        writer.close();
        return response.getBody();
        
    }

    record Movie(String title, String image, String year, String imDbRating){}
    record ListOfMovies(List<Movie> items){}
    
   
}

