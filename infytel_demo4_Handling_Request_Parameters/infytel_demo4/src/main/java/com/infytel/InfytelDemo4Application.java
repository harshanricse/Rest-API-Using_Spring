package com.infytel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//Starter code
@SpringBootApplication
public class InfytelDemo4Application {

	public static void main(String[] args) {
		SpringApplication.run(InfytelDemo4Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
