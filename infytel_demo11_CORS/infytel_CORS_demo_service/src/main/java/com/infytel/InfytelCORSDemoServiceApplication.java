package com.infytel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InfytelCORSDemoServiceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		
		SpringApplication.run(InfytelCORSDemoServiceApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//comment the below line and try to consume the APIs from client of different origin
		registry.addMapping("/**").allowedMethods("GET", "POST");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
