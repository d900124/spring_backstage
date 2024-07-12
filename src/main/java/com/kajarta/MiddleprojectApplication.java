package com.kajarta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.kajarta", "com" })
public class MiddleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleprojectApplication.class, args);
	}

}
