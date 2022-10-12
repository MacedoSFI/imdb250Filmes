package com.sevenDaysOfCode.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevenDaysOfCode.imdb.modelo.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
