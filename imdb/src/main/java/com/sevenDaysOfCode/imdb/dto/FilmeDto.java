package com.sevenDaysOfCode.imdb.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sevenDaysOfCode.imdb.modelo.Filme;

public class FilmeDto {
	
	private Long id;
	private String title;
	private String image;
	private Double imDbRating;
	private String year;
	
	public FilmeDto() {}
	
	public FilmeDto(Filme filme) {
		this.title = filme.getTitle();
		this.image = filme.getImage();
		this.imDbRating = filme.getImDbRating();
		this.year = filme.getYear();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public Double getImDbRating() {
		return imDbRating;
	}
	public String getYear() {
		return year;
	}

	public static List<FilmeDto> converter(List<Filme> filmes) {
		return filmes.stream().map(FilmeDto::new).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "FilmeDto [title=" + title + ", image=" + image + ", imDbRating=" + imDbRating + ", year=" + year + "]";
	}

}
