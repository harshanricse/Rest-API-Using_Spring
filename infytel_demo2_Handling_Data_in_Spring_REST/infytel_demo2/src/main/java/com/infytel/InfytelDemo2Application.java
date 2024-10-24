package com.infytel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Spring Boot application's starter code
@SpringBootApplication
public class InfytelDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(InfytelDemo2Application.class, args);
	}
	
	//Bean that helps mapping DTOs and entities
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
