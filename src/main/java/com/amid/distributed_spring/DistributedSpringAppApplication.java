package com.amid.distributed_spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DistributedSpringAppApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(DistributedSpringAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("Let's integrate");
	}
}
