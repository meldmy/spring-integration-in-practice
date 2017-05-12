package com.amid.distributed_spring;

import com.amid.distributed_spring.gateway.PrinterGateway;
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

    private static final int MESSAGE_QUANTITY = 10;
    private static final String MESSAGE_PAYLOAD = "Some payload that created for message id: ";

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(DistributedSpringAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        for (int messageId = 0; messageId < MESSAGE_QUANTITY; messageId++) {
            sendMessage(messageId);
        }
    }

    private void sendMessage(int messageId) {
        Message<String> message = MessageBuilder
                .withPayload(MESSAGE_PAYLOAD + messageId)
                .setHeader("messageId", messageId)
                .build();
        gateway.print(message);
    }
}
