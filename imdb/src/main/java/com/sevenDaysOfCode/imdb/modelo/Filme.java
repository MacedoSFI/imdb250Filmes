package com.sevenDaysOfCode.imdb.modelo;

import java.util.Objects;

public class Filme {
	
	private Long id;
	private int rank;
	private String title;
	private String fullTitle;
	private String year;
	private String image;
	private String crew;
	private Double imDbRating;
	private Double imDbRatingCount;
	
	public Filme() {}
	
	public Filme(int rank, String title, String fullTitle, String year, String image, String crew, Double imDbRating,
			Double imDbRatingCount) {
		super();
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.year = year;
		this.image = image;
		this.crew = crew;
		this.imDbRating = imDbRating;
		this.imDbRatingCount = imDbRatingCount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(crew, fullTitle, id, imDbRating, imDbRatingCount, image, rank, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(crew, other.crew) && Objects.equals(fullTitle, other.fullTitle)
				&& Objects.equals(id, other.id) && Objects.equals(imDbRating, other.imDbRating)
				&& Objects.equals(imDbRatingCount, other.imDbRatingCount) && Objects.equals(image, other.image)
				&& rank == other.rank && Objects.equals(title, other.title) && Objects.equals(year, other.year);
	}

	public Long getId() {
		return id;
	}

	public int getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public String getYear() {
		return year;
	}

	public String getImage() {
		return image;
	}

	public String getCrew() {
		return crew;
	}

	public Double getImDbRating() {
		return imDbRating;
	}

	public Double getImDbRatingCount() {
		return imDbRatingCount;
	}

}
