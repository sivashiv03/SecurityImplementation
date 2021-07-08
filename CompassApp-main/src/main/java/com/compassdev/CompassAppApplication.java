package com.compassdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages= {"com.compassdev.*"})
public class CompassAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompassAppApplication.class, args);
	}



}
