package com.infytel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
@EnableAsync
@SpringBootApplication
public class InfyTelDemoDevToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyTelDemoDevToolsApplication.class, args);
	}

}
