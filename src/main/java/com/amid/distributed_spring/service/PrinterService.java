package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    private final Logger log = Logger.getLogger(PrinterService.class);

    //process message and appearing some error
    public void print(Message<String> message) {
        log.info(message.getPayload());
        throw new RuntimeException("This is error");
    }
}
