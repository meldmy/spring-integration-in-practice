package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class UppercasePrinterService {

    private final Logger log = Logger.getLogger(UppercasePrinterService.class);

    public Message<String> printUppercase(Message<String> message) {
        log.info(message.getPayload().toUpperCase());
        return createNewMessage(message);
    }

    private Message<String> createNewMessage(Message<String> message) {
        int messageNumber = (int) message.getHeaders().get("messageNumber");
        return MessageBuilder
                .withPayload("UppercasePrinterService send reply for message: " + messageNumber)
                .build();
    }

}
