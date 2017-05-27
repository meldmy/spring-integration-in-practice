package com.amid.distributed.spring.service;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    private final Logger log = Logger.getLogger(PrinterService.class);

    //process message and appearing some error
    public void print(Message<?> message) {
        log.info(message.getPayload());
        log.info(message.getHeaders().get("inboundPriority"));
        throw new FakeServiceException("This is error");
    }
}
