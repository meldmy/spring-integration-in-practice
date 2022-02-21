package com.amid.distributed.spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService implements MessageHandler {

    private final Logger log = Logger.getLogger(PrinterService.class);

    //process message and appearing some error
    public void print(Message<?> message) {
        log.info(message.getPayload());
        log.info(message.getHeaders().get("inboundPriority"));
        throw new FakeServiceException();
    }

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        print(message);
    }
}
