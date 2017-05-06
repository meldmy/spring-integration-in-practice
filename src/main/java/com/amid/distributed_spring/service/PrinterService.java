package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    private final Logger log = Logger.getLogger(PrinterService.class);

    public Message<String> print(Message<String> message) {
        printHeaders(message);
        printPayload(message);
        return createNewMessage(message);
    }

    private Message<String> createNewMessage(Message<String> message) {
        return MessageBuilder
                .withPayload("Version 2: " + message.getPayload())
                .build();
    }

    private void printHeaders(Message<String> message) {
        message.getHeaders()
                .forEach((key, value) ->
                        log.info(key + " : " + value));
    }

    private void printPayload(Message<String> message) {
        log.info(message.getPayload());
    }
}
