package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class UppercasePrinterService {

    private final Logger log = Logger.getLogger(UppercasePrinterService.class);

    public void printUppercase(Message<?> message) {
        log.info(message.getPayload().toString().toUpperCase());
    }
}
