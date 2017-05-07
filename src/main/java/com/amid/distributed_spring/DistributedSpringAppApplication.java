package com.amid.distributed_spring;

import com.amid.distributed_spring.gateway.PrinterGateway;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class DistributedSpringAppApplication implements ApplicationRunner {

    private final Logger log = Logger.getLogger(DistributedSpringAppApplication.class);

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(DistributedSpringAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder
                    .withPayload("Some payload that created for message id: " + i)
                    .build();
            log.info("Sending message " + i);
            gateway.print(message);
        }
    }
}
