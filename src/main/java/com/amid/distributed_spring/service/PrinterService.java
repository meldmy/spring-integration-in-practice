package com.amid.distributed_spring.service;

import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class PrinterService {

    public void print(Message<String> message) {
        throw new RuntimeException("This is error");
    }
}
