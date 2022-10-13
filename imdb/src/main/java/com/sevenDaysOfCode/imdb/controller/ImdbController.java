package com.sevenDaysOfCode.imdb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.dto.FilmeDto;
import com.sevenDaysOfCode.imdb.modelo.Filme;

@RestController
public class ImdbController {
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@GetMapping(value = "/250Filmes")
	public List<FilmeDto> get250Filmes() {
		//String url = "https://imdb-api.com/en/API/Top250Movies/k_4qe4eo9s";
		//ResponseEntity<Filme> filmes = restTemplate.getForObject(url, Filme.class);
		Filme filme = new Filme(246, "Dersu Uzala", "Dersu Uzala (1975)", "1975", 
				"https://m.media-amazon.com/images/M/MV5BYWY0OWJlZTgtMWUzNy00MGJhLTk5YzQtNmY5MDEwOTIxNjMyXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX128_CR0,12,128,176_AL_.jpg", 
				"Akira Kurosawa (dir.), Maksim Munzuk, Yuriy Solomin", 8.0,	29732.0);
		
		//Object[] filmes = (Object[]) restTemplate.getForObject(url, Object[].class);
		//
		List<Filme> filmes = Arrays.asList(filme, filme, filme);
		System.out.println(FilmeDto.converter(filmes));
		return FilmeDto.converter(filmes);
	}

}
