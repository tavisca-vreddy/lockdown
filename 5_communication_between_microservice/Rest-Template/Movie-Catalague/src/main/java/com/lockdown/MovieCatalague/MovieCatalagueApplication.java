package com.lockdown.MovieCatalague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalagueApplication {

	@Bean
	@LoadBalanced//this will do load balancing and other servics discover with eureka server..this is a client side discoverey
    public RestTemplate getInstance()
	{
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalagueApplication.class, args);
	}

}
