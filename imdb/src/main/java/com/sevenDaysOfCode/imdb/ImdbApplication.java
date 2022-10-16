package com.sevenDaysOfCode.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.controller.ImDbApiClient;
import com.sevenDaysOfCode.imdb.controller.ImDbHTML;

@SpringBootApplication
public class ImdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public ImDbApiClient imDbApiCLient() {
		return new ImDbApiClient();
	}
	@Bean
	public ImDbHTML imDbHTML() {
		return new ImDbHTML();
	}
	
}
