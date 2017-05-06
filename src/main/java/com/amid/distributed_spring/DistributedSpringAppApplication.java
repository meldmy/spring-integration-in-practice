package com.amid.distributed_spring;

import com.amid.distributed_spring.service.PrinterService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
public class DistributedSpringAppApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(DistributedSpringAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
        Message<String> message = MessageBuilder
                .withPayload("Let's integrate")
                .setHeader("HeaderKey", "HeaderValue")
                .build();

        PrinterService service = new PrinterService();
        service.print(message);
    }
}
