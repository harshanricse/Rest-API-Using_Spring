package com.infytel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class InfyTelAsyncDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyTelAsyncDemoApplication.class, args);
	}

}
