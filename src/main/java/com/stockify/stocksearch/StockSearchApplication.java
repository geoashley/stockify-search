package com.stockify.stocksearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StockSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockSearchApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/search").allowedOrigins("http://localhost:3000").allowedOrigins("https://localhost:3000");
				registry.addMapping("/aggregate").allowedOrigins("http://localhost:3000").allowedOrigins("https://localhost:3000");
				registry.addMapping("/related").allowedOrigins("http://localhost:3000").allowedOrigins("https://localhost:3000");
			}
		};
	}

}
