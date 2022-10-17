package com.sevenDaysOfCode.imdb.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImdbController {
	
	private ListOfMovies movies = new ListOfMovies(new ArrayList<>());
	
    @Autowired
    private ImDbApiClient imDbApiClient;
    
    @GetMapping("/top250filmes")
    public ListOfMovies getTop250Filmes(@RequestParam(required = false) String title)  throws FileNotFoundException {
    	//exemplo: http://localhost:8080/top250filmes?title=Psycho
    	ListOfMovies response = this.imDbApiClient.getBody();
    	if (Objects.nonNull(title)) {
            this.movies.items().addAll(response.items().stream()
                    .filter(movie -> movie.title.contains(title))
                    .collect(Collectors.toList()));
        } else {
            this.movies.items.addAll(response.items());
        }
    	PrintWriter writer = new PrintWriter("src/main/resources/content.html");
		new HTMLGenerator(writer).generate(movies);
		writer.close();
		
        return movies;
    }
    
    record Movie(String title, String image, String year, String imDbRating){}
    record ListOfMovies(List<Movie> items){}
   
}

