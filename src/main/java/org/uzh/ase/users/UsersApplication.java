package org.uzh.ase.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource({ "classpath:application-${env:local}.properties" })
public class UsersApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/scores").allowedOrigins("*");
				registry.addMapping("/api/scores/score").allowedOrigins("*");
			}
		};
	}
}
