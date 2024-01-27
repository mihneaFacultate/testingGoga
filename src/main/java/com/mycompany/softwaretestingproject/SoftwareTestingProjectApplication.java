package com.mycompany.softwaretestingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mycompany.softwaretestingproject"})
@EnableJpaRepositories(basePackages = {"com.mycompany.softwaretestingproject"})
public class SoftwareTestingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareTestingProjectApplication.class, args);
	}

}
