package com.infytel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Spring Boot application's starter code
@SpringBootApplication
public class InfytelDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(InfytelDemo1Application.class, args);
	}
	
	//Bean that helps mapping a DTO to an entity and vice versa
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
