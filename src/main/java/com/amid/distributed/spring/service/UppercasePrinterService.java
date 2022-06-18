package com.amid.distributed.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class UppercasePrinterService {

    private final Logger log = LogManager.getLogger(UppercasePrinterService.class);

    public void printUppercase(Message<?> message) {
        log.info(message.getPayload().toString().toUpperCase());
    }
}
