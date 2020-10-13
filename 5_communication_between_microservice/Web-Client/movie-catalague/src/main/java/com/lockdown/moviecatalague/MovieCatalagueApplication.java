package com.lockdown.moviecatalague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalagueApplication {
	@Bean
	public WebClient.Builder getObject()
	{
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalagueApplication.class, args);
	}

}
