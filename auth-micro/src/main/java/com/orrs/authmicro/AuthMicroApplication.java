package com.orrs.authmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

public class AuthMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthMicroApplication.class, args);
	}

}
