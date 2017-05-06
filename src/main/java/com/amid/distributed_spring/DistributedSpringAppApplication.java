package com.amid.distributed_spring;

import com.amid.distributed_spring.service.PrinterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class DistributedSpringAppApplication implements ApplicationRunner {

    private final Logger log = Logger.getLogger(PrinterService.class);

    @Autowired
    private DirectChannel inboundChannel;
    @Autowired
    private DirectChannel outputChannel;

    public static void main(String[] args) {
        SpringApplication.run(DistributedSpringAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        outputChannel.subscribe(this::printMessage);

        Message<String> message = MessageBuilder
                .withPayload("Let's integrate")
                .setHeader("HeaderKey", "HeaderValue")
                .build();

        inboundChannel.send(message);
    }

    private void printMessage(Message<?> message) {
        log.info(message.getPayload());
    }
}
