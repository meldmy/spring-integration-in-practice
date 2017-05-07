package com.amid.distributed_spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    private final Logger log = Logger.getLogger(PrinterService.class);

    public void print(Message<String> message) {
        log.info(message.getPayload());
    }
}
