package com.amid.distributed.spring.gateway;

import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public interface BankOperationsGateway {

    void print(Message<?> message);

    void printDevidedByFive(Message<?> message);
}
