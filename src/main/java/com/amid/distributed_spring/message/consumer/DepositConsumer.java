package com.amid.distributed_spring.message.consumer;

import com.amid.distributed_spring.entity.Deposit;
import org.springframework.messaging.Message;

/**
 * @author Dmytro Melnychuk
 */
public class DepositConsumer extends Consumer {

    static final String DEPOSIT = "Deposit";

    public void print(Message<?> message) {
        printMessage((Deposit) message.getPayload(), DEPOSIT);
    }
}