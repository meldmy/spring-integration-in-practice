package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    private final Logger log = Logger.getLogger(PrinterService.class);

    public Message<String> print(Message<String> message) {
        printPayload(message);
        return createNewMessage(message);
    }

    private Message<String> createNewMessage(Message<String> message) {
        int messageNumber = (int) message.getHeaders().get("messageNumber");
        return MessageBuilder
                .withPayload("PrinterService send reply for message: " + messageNumber)
                .build();
    }

    private void printPayload(Message<String> message) {
        log.info(message.getPayload());
    }
}
