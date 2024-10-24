package com.infytel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InfytelPaginationDemoApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(InfytelPaginationDemoApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	@Bean 
	public RestTemplate restTemplate()
	{ 
		return new RestTemplate();
	}
}
