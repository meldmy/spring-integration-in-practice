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
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class DistributedSpringAppApplication implements ApplicationRunner {

    private static final String MESSAGE_NUMBER = "messageNumber";
    private final Logger log = Logger.getLogger(DistributedSpringAppApplication.class);

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(DistributedSpringAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        printMessagesAfterProcessing(createProcessingMessages(10));
    }

    private List<Future<Message<String>>> createProcessingMessages(int messageQuantity) {
        List<Future<Message<String>>> processingMessage = new ArrayList<>();
        for (int messageId = 0; messageId < messageQuantity; messageId++) {
            Message<String> message = createNewMessage(messageId, messageQuantity - messageId);
            logSendingMessage(messageId);
            processingMessage.add(this.gateway.print(message));
        }
        return processingMessage;
    }

    private void printMessagesAfterProcessing(List<Future<Message<String>>> futures) throws InterruptedException, ExecutionException {
        for (Future<Message<String>> future : futures) {
            log.info("Message " + future.get().getHeaders().get(MESSAGE_NUMBER) + " has been processed");
        }
    }

    private void logSendingMessage(int messageNumber) {
        log.info("Sending message " + messageNumber);
    }

    private Message<String> createNewMessage(int messageId, int priority) {
        return MessageBuilder
                .withPayload("Message payload")
                .setHeader(MESSAGE_NUMBER, messageId)
                .setPriority(priority)
                .build();
    }
}
