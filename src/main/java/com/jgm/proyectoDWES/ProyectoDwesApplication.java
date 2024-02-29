package com.jgm.proyectoDWES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProyectoDwesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwesApplication.class, args);
	}

}
