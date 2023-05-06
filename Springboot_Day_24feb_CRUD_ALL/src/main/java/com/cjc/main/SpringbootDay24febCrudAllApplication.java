package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@EntityScan
@SpringBootApplication
public class SpringbootDay24febCrudAllApplication {

	public static void main(String[] args) {
		
		System.out.println("this is crud operation");
		SpringApplication.run(SpringbootDay24febCrudAllApplication.class, args);
	}

}
