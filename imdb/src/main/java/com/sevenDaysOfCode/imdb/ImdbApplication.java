package com.sevenDaysOfCode.imdb;

import java.io.File;
import java.io.PrintWriter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.sevenDaysOfCode.imdb.controller.ImdbController.ListOfMovies;
import com.sevenDaysOfCode.imdb.controller.ImdbController.Movie;

@SpringBootApplication
public class ImdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}
	/*
	 * PrintWriter writer1 =null;      
        writer1 = new PrintWriter(new File("C:\\Users\\fbmac\\eclipse-workspace\\imdb\\src\\main\\resources\\templates\250Filmes.html"));  
        writer1.write(html);                                                   
        //HTMLGenerator(writer1);
        writer1.flush();  
        writer1.close();
	 * 
	 * */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	class HTMLGenerator {
	    	
	    	private PrintWriter writer = null;

	    	public void HtmlGenerator(PrintWriter writer) {
	    		this.writer = writer;
	    	}
	    	
	    	public void generate(ListOfMovies items) {
	    		writer.println(
	    	"""
	    	<html>
	    		<head>
	    			<meta charset=\"utf-8\">
	    			<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
	    			<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
	    						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
	    						
	    		</head>
	    		<body>
	    	""");

	    		for (Movie movie : items) {
	    			String div =
	    			"""
	    			<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
	    				<h4 class=\"card-header\">%s</h4>
	    				<div class=\"card-body\">
	    					<img class=\"card-img\" src=\"%s\" alt=\"%s\">
	    					<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
	    				</div>
	    			</div>
	    			""";
	    			
	    			writer.println(String.format(div, movie.title(), movie.image(), movie.title(), movie.imDbRating(), movie.year()));
	    		}

	    				
	    		writer.println(
	    		"""
	    			</body>
	    		</html>
	    		""");
	    	}

	    }
}
