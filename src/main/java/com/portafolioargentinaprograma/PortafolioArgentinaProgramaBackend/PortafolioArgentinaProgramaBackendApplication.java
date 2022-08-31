package com.portafolioargentinaprograma.PortafolioArgentinaProgramaBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class PortafolioArgentinaProgramaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortafolioArgentinaProgramaBackendApplication.class, args);
	}

}
